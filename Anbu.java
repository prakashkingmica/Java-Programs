import java.io.*;
import java.sql.*;
class Anbu{
	public static void main(String args[]){
		//BufferedReader br;
		top:
			for(;;){
				try{
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					Class.forName("org.gjt.mm.mysql.Driver");
					String ads = "jdbc:mysql://127.0.0.1:3306/anbu";
					Connection con = DriverManager.getConnection(ads,"root","root");
					Statement st = con.createStatement();
					System.out.println("MENU");
					System.out.println("1.ADDITION");
					System.out.println("2.SUBTRACTION");
					System.out.println("3.MULTIPLICATION");
					System.out.println("4.DIVISION");
					System.out.println("5.MODULO DIVISION");
					System.out.println("6.EXIT");
					System.out.println("Enter Ur Option : ");
					int o = Integer.parseInt(br.readLine());
					if(o<6 && o>0){
						System.out.print("Enter the value of a : ");
						int a = Integer.parseInt(br.readLine());
						System.out.print("Enter the value of b : ");
						int b = Integer.parseInt(br.readLine());
						int c=0;
						String p="";
						switch(o){
							case 1:
									p="Addition";
									c=a+b;
									System.out.println("Result is "+c);
									break;
							case 2:
									p="Subtraction";
									c=a-b;
									System.out.println("Result is "+c);
									break;
							case 3:
									p="Multiplication";
									c=a*b;
									System.out.println("Result is "+c);
									break;
							case 4:
									p="Division";
									c=a/b;
									System.out.println("Result is "+c);
									break;
							case 5:
									p="Modulo Division";
									c=a%b;
									System.out.println("Result is "+c);
									break;
							default:
									//System.out.println("Exit");
									break;
						}
						ResultSet rs1 = st.executeQuery("select ifnull(max(slno),0) from calMenu");
						String m="";
						while(rs1.next()){
							m=rs1.getString(1);
							m=""+(Integer.parseInt(m)+1);
						}
						String in  = "insert into calMenu values('"+m+"','"+p+"',"+a+","+b+","+c+")";
						st.executeUpdate(in);
						System.out.println(in);
						ResultSet rs = st.executeQuery("Select * from calMenu");
						System.out.println("\t\tcount\t\tprocess\t\tinputA\t\tinputB\t\toutputC");

						while(rs.next()){
							System.out.println("\t\t"+rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
						}
						rs.close();
					}
					st.close();
					con.close();
					opt:
						for(;;){
							System.out.println("Do u want to continue (Y/N) : ");
							String v = br.readLine();
							if(v.equalsIgnoreCase("Y")){
								continue top;
							}else if(v.equalsIgnoreCase("N")){
								System.exit(0);
							}else{
								System.out.println("Please Enter Correct Option....");
								continue opt;
							}
						}
				}catch(Exception ex){
					ex.printStackTrace();
					System.out.println("That's One Exception Occured");
				}
				finally{
					System.out.println("This is finally block");
				}
			}
	}
}