package com.jaiet.common.util;



import java.util.*;



import com.jaiet.common.dbutil.*;



import java.sql.Connection;



import java.net.*;






public class Common{







	public static void printArray(String[][] data){






		if(data != null){



			for(int i=0; i< data.length; i++){



				String row = "";



				if(data[i] != null){



					for(int j=0; j< data[i].length; j++){



						row =  row+"\t"+data[i][j];



					}



				}



				System.out.println(row+"\n");



			}



		}
	}





	public static void printArray(String[] data){






		if(data != null){



			for(int i=0; i< data.length; i++){



				System.out.println("Data["+i+"]"+data[i]);



			}



		}
	}






	public static String buildString(String[] data, String columnSeperator){



		if(data == null)



			return "";



		StringBuffer outputString =new StringBuffer();



		for(int i=0; i< data.length; i++){
			if(data[i] == null)


				data[i] = " ";


			//outputString= outputString+data[i]+columnSeperator;
			outputString.append(data[i]);

			outputString.append(columnSeperator);



		}
		//outputString=outputString.substring(0,outputString.length()-columnSeperator.length());
		outputString=outputString.deleteCharAt(outputString.length()-1);




		return outputString.toString();



	}







	public static Hashtable unBuildString2Hashtable (String data, String columnSeperator, String rowSeperator){



		Hashtable response = null;

		if(data == null || data =="" || data.length() <1)

			return null;
		else{

			response = new Hashtable();


			String [] rows = data.split(rowSeperator);

			for(int o=0; o< rows.length; o++){

				String[] columns = rows[o].split(columnSeperator);

				if(columns.length > 1)

					response.put(columns[0],columns[1]);

				else

					response.put(columns[0]," ");	// when only key comes, we are adding empty string

													// as value...
			}
		}
		return response;
	}

	public static Hashtable buildHashtableVector(String[][] data){







		Hashtable response = null;







		if(data != null){



			response = new Hashtable();



			Vector rights	= null;







			for(int j=0; j < data.length; j++){



				if(response.get(data[j][0]) != null){



					rights	= (Vector) response.get(data[j][0]);



					rights.add(data[j][1]);



				}



				else{



					rights = new Vector();



					rights.add(data[j][1]);



					response.put(data[j][0],rights);



				}



			}



		}



		return response;



	}






	public static String buildString(String[][] data, String columnSeperator,String rowSeperator){
		if(data == null)
			return "";
		StringBuffer outputString =new StringBuffer();
		for(int i=0; i< data.length; i++){
			if(data[i] != null){
				for(int j=0; j< data[i].length; j++){
					if(data[i][j] == null)
						data[i][j] = " ";
					outputString.append(data[i][j]);
					outputString.append(columnSeperator);
				}
				//outputString=outputString.substring(0,outputString.length()-columnSeperator.length());
				//outputString = outputString+rowSeperator;

				outputString=outputString.deleteCharAt(outputString.length()-1);

				outputString.append(rowSeperator);
			}
		}
		//outputString=outputString.substring(0,outputString.length()-rowSeperator.length());
		outputString=outputString.deleteCharAt(outputString.length()-1);

		return outputString.toString();
	}



	public static String buildString(String[][] data, String columnSeperator,String rowSeperator,boolean encode){





		if(data == null)


			return "";





		//printArray(data);





		StringBuffer outputString =new StringBuffer();




		try{
			for(int i=0; i< data.length; i++){
				//System.out.println("data[i]   :"+data[i]);
				if(data[i] != null){
					for(int j=0; j< data[i].length; j++){
						if(data[i][j] == null || data[i][j].equals("null")){
							data[i][j] = " ";
						}
						//outputString= outputString+URLEncoder.encode(data[i][j],"UTF-8")+columnSeperator;
						outputString.append(URLEncoder.encode(data[i][j],"UTF-8"));

						outputString.append(columnSeperator);

					}
					//outputString=outputString.substring(0,outputString.length()-columnSeperator.length());
					//outputString = outputString+rowSeperator;
					outputString=outputString.deleteCharAt(outputString.length()-1);

					outputString.append(rowSeperator);

				}
			}
			//outputString=outputString.substring(0,outputString.length()-rowSeperator.length());
			outputString=outputString.deleteCharAt(outputString.length()-1);

		}catch(Exception e){
			e.printStackTrace();
		}
		return outputString.toString();





	}





	public static String buildString(String[][] data, String columnSeperator,String rowSeperator,String addRowNumber){
		if(data == null)
			return "";
		StringBuffer outputString =new StringBuffer();
		int k=0;
		try{
			for(int i=0; i< data.length; i++){
				k++;
				if(data[i] != null){
					for(int j=0; j< data[i].length; j++){
						if(data[i][j] == null)
							data[i][j] = " ";
						//outputString= outputString+URLEncoder.encode(data[i][j],"UTF-8")+columnSeperator;
						outputString.append(URLEncoder.encode(data[i][j],"UTF-8"));

						outputString.append(columnSeperator);

					}
					//outputString= outputString+k+columnSeperator;
					//outputString=outputString.substring(0,outputString.length()-columnSeperator.length());
					//outputString = outputString+rowSeperator;
					outputString.append(k);

					outputString.append(columnSeperator);

					outputString=outputString.deleteCharAt(outputString.length()-1);

					outputString.append(rowSeperator);

				}
			}
			//outputString=outputString.substring(0,outputString.length()-rowSeperator.length());
			outputString=outputString.deleteCharAt(outputString.length()-1);

		}catch(Exception e){
			e.printStackTrace();
		}
		return outputString.toString();
	}


	public static String[] unBuildString(String data, String columnSeperator){
		if(data == null)
			return null;
		String[] innerData = data.split("\\"+columnSeperator);
		return innerData;
	}







	public static String[][] unBuildString(String data, String columnSeperator, String rowSeperator){



		if(data == null)



			return null;







		String[] innerData = data.split("\\"+rowSeperator);



		String[][] totalData = new String[innerData.length][];



		for(int j=0; j< innerData.length; j++){



			totalData[j] = innerData[j].split("\\"+columnSeperator);



		}



		return totalData;



	}







	public static String sort2DArray(String data,String colSeperator,String rowSeperator){







		if(data.length()<2)



			return "";



		Hashtable ht = new Hashtable();



		Vector v = new Vector();



		String[] rows = data.split(rowSeperator);



		for(int i=0;i<rows.length;i++){



					String[] columns = rows[i].split(colSeperator);



					String uniqueId = columns[1]+columns[0];



					v.add(uniqueId);



					ht.put(uniqueId,rows[i]);



			}







			int length = v.size();



			String[] partyNames = new String[length];



			Enumeration en = v.elements();



			int j=0;



			while(en.hasMoreElements()){







				partyNames[j] = (String)en.nextElement();



				j++;



			}







			Arrays.sort(partyNames);







			String result = "";



			for(int k=0;k<partyNames.length;k++){



				String row = (String)ht.get(partyNames[k]);



				if(rowSeperator.equals("\\#"))



					result = result+row+"#";



				else if(rowSeperator.equals("\\$"))



					result = result+row+"$";



				else if(rowSeperator.equals("\\|"))



					result = result+row+"|";



			}



			return result;



	}







	public static synchronized String getUniqueId(String tableName){




		Connection con = DBPool.getConnection();





		boolean status = true;





		int count = 0;



		DatabaseController dbController = new DatabaseController();



		String uniqueId = "";



		String query = "select * from UniqueIds where tableName = ?";







		String[] data = {tableName.trim()};



		String[][] responseData = dbController.getData(query,data,con);
		//System.out.println("responseData>>>>>>>>>>>>>>>>>>");


		Common.printArray(responseData);





		if(responseData != null){
			//System.out.println("<<<<<<<<<<<if>>>>>>>>>>responseData>>>>>>>>>>>>>>>>>>");


			int x = Integer.parseInt(responseData[0][1]);



			String newId = new Integer(x+1).toString();



			String[] mData = {newId,tableName};



			query = "update UniqueIds set lastuniqueno =? where tablename = ?";



			count = dbController.updateUniqueIdData(query,mData,con);
			//System.out.println(">>>if >>>responseData>>>>>>>>>>>>>>>>>>"+count);


			if(count > 0){


				status = true;


			}else{


				status = false;


			}





			if(status){



				uniqueId = tableName+newId;
				//System.out.println("<<if   responseData>>>>>>>>>>>>>>>>>>"+uniqueId);


			}





		}



		else{
			//System.out.println(">>>else >>>responseData>>>>>>>>>>>>>>>>>>");


			query = "insert into UniqueIds values (?,?)";



			String[] vdata ={tableName,"1001"};



			count 	= dbController.updateUniqueIdData(query,vdata,con);
			//System.out.println(">>>else >>>responseData>>>>>>>>>>>>>>>>>>"+count);





			if(count > 0){


				status = true;


			}else{


				status = false;


			}





			if(status){



				uniqueId = tableName+"1001";
				//System.out.println("<<else   responseData>>>>>>>>>>>>>>>>>>"+uniqueId);


			}









		}



		DBPool.updateConnection(con,status);





		return uniqueId;



	}









	public static boolean updateData(String query, String[] data, Connection[] con){
		boolean status= false;
		DatabaseController dbController = new DatabaseController();
		int count 		= dbController.updateData(query,data,con);
		if(count > 0)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean updateData(String query, String[] data, Connection con){
		DatabaseController dbController = new DatabaseController();
		int count 		= dbController.updateData(query,con,data);
		return (count > 0);
	}


	public static Vector buildVector(String data, String columnSeperator){



			Vector v = null;



			String[] members = data.split(columnSeperator);



			for(int z=0; z< members.length; z++){



				if(v == null)



					v = new Vector();



				v.add(members[z]);



			}



		return v;



	}











}



