import java.io.*;
public class SubStringExa{
  public static void main(String args[])throws IOException{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	System.out.println("\n*******This is first Example*******");
	 System.out.print("Enter the String : ");
 	 String s = br.readLine();
 	 System.out.print("Enter the  Posititon the o/p String will Start: ");
 	 int p = Integer.parseInt(br.readLine());
 	 String t = s.substring(p);
 	 System.out.println("Input String is    : "+s);
 	 System.out.println("Resulted String is : "+t+"\n");

 	System.out.println("\n*******This is second Example******");
 	 System.out.print("Enter the Posititon the o/p String will Start: ");
 	 int st = Integer.parseInt(br.readLine());
 	 System.out.print("Enter the Posititon the o/p String will End: ");
 	 int ed = Integer.parseInt(br.readLine());
 	 String t1 = s.substring(st,ed+1);
 	 System.out.println("Input String is    : "+s);
 	 System.out.println("Resulted String is : "+t1+"\n");
  }
}