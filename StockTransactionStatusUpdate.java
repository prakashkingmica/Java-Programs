import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;


public class StockTransactionStatusUpdate {

    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static HashMap<String, String> users = null;
    static HashMap<String, String> allData = null;
    static String[][] allUsers = null;
	
    static{
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		setAllUsers();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public static Connection getConnection(String user){
		
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.238:1521:tstsharp", user, user); // For Test Sharp
		}catch(Exception e){
			try{
				con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.238:1521:newsharp", user, user); // For Live Sharp
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return con;
		
	}
    
    public static void setAllUsers(){
    	allUsers = getUsers();
    	if(allUsers != null && allUsers.length > 0){
    		users = new HashMap<String, String>();
    		for(int i = 0; i < allUsers.length; i++){
    			users.put(allUsers[i][0].trim(), allUsers[i][1].trim());
    		}
    		System.out.println("No. of Connections is "+users.size());
    	}
    }
	
    public static String[][] getUsers() {

        String query =  "select " +
        					"um.org_id, " +
        					"um.user_id " +
        				"from " +
        					"sharp_user_mast um " +
        				"where " +
        					"org_id in " +
        						"(select " +
        							"cl.branch_id " +
        						"from " +
        							"connection_list cl " +
        						"where " +
        							"cl.branch_id in " +
        								"(select " +
        									"org.orgid " +
        								"from " +
        									"organizationdetails org " +
        								"where " +
        									"org.orgtype = 7)) " +
        				"order by um.user_id";
        String[][] users = null;
        try{
        	con = getConnection("microsharp");
        	users = getData(query, new String[0], con);
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	releaseConnection(con);
        }
        return users;
    }
    
	public  static void releaseConnection(Connection con){
		try{
			if(con!=null && !con.isClosed()){
				if(!con.getAutoCommit()){
					con.commit();
				}
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	public  static void closePreparedStatement(PreparedStatement ps){
		try{
			if(ps != null)
				ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public  static void closeResultSet(ResultSet rs){
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
    
	public static String[][] getData(String query, String[] inputData,Connection con) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[][] data = null;
		try{
			ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setFetchSize(1);
			for(int j=0; j< inputData.length; j++){
				ps.setString(j+1,inputData[j]);
			}
			rs = ps.executeQuery();
			data = convert2String(rs);

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeResultSet(rs);
				closePreparedStatement(ps);
			}catch(Exception ex){
				closePreparedStatement(ps);
			}
		}
		if(data != null && data.length == 0){
			data = null;
		}
		return data;
	}
    
    public static String[][] convert2String(ResultSet rs){
		String[][] data = null;
		try{
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			rs.last();
			int noOfRecords=rs.getRow();
			data=new String[noOfRecords][columnCount];
			rs.beforeFirst();
			int k=0;
			while(rs.next()){
				for(int i=1; i <= columnCount; i++){
					data[k][i-1]=rs.getString(i);
					if(data[k][i-1]!=null){
						data[k][i-1]=data[k][i-1].replaceAll("\\;","");
					}
				}
				k++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
    
	public static int updateData(String query, String[] data, Connection con){
		int count = 0;
		PreparedStatement ps = null;
		boolean connectionReceived = true;
		try{
			if(con == null){
				con = getConnection("common");
				connectionReceived = false;
			}
			ps = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setFetchSize(1);
			for(int j=0; j< data.length; j++){
				if(data[j].startsWith("<<<NULL>>>")){
					String[] values= data[j].split("#");
					int type = Integer.parseInt(values[1]);
					if(type== 1){
						ps.setNull(j+1,Types.VARCHAR);
					}
					else
					if(type==3)
						ps.setNull(j+1,Types.DATE);
					else
						ps.setNull(j+1,Types.NUMERIC);
				}
				else
					ps.setString(j+1,data[j]);
			}
			count = ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			closePreparedStatement(ps);
			if(!connectionReceived){
				releaseConnection(con);
			}
		}
		return count;
	} 
	
	public static boolean updateConnection(Connection con,boolean status){
		try{
			if(con!=null){
				if(status){
					if(!con.getAutoCommit()){
						con.commit();
					}
				}else{
					con.rollback();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			releaseConnection(con);
		}
		return status;
	}
	
    public static void main(String[] args) {
    	if(allUsers != null && allUsers.length > 0){
    		for(int i = 0; i < allUsers.length; i++){
    			//if(allUsers[i][0].trim().equals("229")){ // For test
    			String user = users.get(allUsers[i][0].trim());
    			try{
    				con = getConnection(user.trim());
    				String[][] data = receiverStockTransactionStatus(allUsers[i][0].trim(), con);
    				splitUpdatebleData(data);
    			}catch(Exception e){
    				e.printStackTrace();
    			}finally{
    				releaseConnection(con);
    			}
    			//}
    		}
    		compaignAllData();
    	}
		
	}
    
    public static void compaignAllData(){
		if(allData != null && allData.size() > 0){
			System.out.println(allData.size() + " Branches Table Should be Updated");
			boolean status = false;
			for(String orgId : allData.keySet()){
				System.out.println("\nFrom orgId is "+orgId);
				String user = users.get(orgId.trim());
				if(user != null){
					try{
						System.out.println("user is "+user);					
						con = getConnection(user.trim());
						String value = allData.get(orgId.trim());
						String[] tranId = null;
						if(value != null && !value.trim().equals("")){
				    		tranId = value.split("\\#");
				    		System.out.println(tranId.length + " TransactionIds should be updated 'C' in TransactionStatus");
				    	}
						status = updateSenderTransactionStatus(con, orgId, tranId);
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						updateConnection(con, status);
					}
				}
			}
		}    	
    }
    
    public static boolean updateSenderTransactionStatus(Connection conn, String fromOrgId, String[] value){
    	boolean status = false;
    	int updatedRowCount = 0;
		String[] inData = {"F", fromOrgId};
    	String query = "update " +
							"StockTransfer st " +
						"set " +
							"st.transactionstatus = ? " +
						"where " +
							"st.fromorgid = ? " +
							"and st.fromorgid in (select org.orgid from organizationdetails org where org.orgtype = 7) "+    						
							"and st.transactionstatus = 'Comp' and st.transactionid in (";
    	if(value != null && value.length > 0){
    		int len = (value.length <= 1000) ? 1 : (value.length / 1000);
    		len = ((value.length > 1000) && (value.length % 1000) > 0) ? (len + 1) : len;
    		int addCount = 0;
    		for(int a = 0; a < len; a++){
    			String innerQuery = "";
	    		inner:for(int i = addCount; i < value.length; i++){
	    			innerQuery += "'"+ value[i] +"'";
	    			if(i < (addCount + 999) && i < value.length-1){
	    				innerQuery +=  ", ";
	    			}else{
	    				addCount += 1000;
	    				break inner;
	    			}
	    		}
    			if(innerQuery != null && !innerQuery.trim().equals("")){
		    		String finalQuery = query.trim() + innerQuery.trim() + ")";
	        		int upCount = updateData(finalQuery, inData, conn);
	        		if(upCount > 0){
	        			updatedRowCount += upCount;
	        			status = true;
	        		}
    			}
    		}
    	}

    	System.out.println("updated Status is "+status);
    	System.out.println(updatedRowCount + " rows Updated");
    	return status;
    }
    
    public static void splitUpdatebleData(String[][] data){
    	if(data != null && data.length > 0){
    		if(allData == null){
    			allData = new HashMap<String, String>();
    		}
    		for(int i = 0; i < data.length; i++){
    			String orgId = data[i][1].trim();
    			if(allData != null && allData.containsKey(orgId)){
    				String value = allData.get(orgId).trim() + "#" + data[i][0].trim();
    				allData.put(orgId, value);
    			}else{
    				allData.put(orgId, data[i][0].trim());
    			}
    		}
    	}
    }
    
    public static String[][] receiverStockTransactionStatus(String orgId, Connection conn){
    	
    	String query =  "select "+
			    		       "st.transactionid, "+
			    		       "st.fromorgid, "+
			    		       "st.toorgid, "+
			    		       "st.transactiontype "+
			    		"from "+
			    		       "stocktransfer st "+
			    		"where "+
			    		       "st.transactiontype in ('B', 'H') "+
			    		       "and st.transactionstatus = 'C' "+
			    		       "and st.toorgid = ?";
    	
    	return getData(query, new String[]{orgId}, conn); 
    }	
}
