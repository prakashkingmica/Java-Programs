import java.io.*;
class StringConcat{
  public static void main(String[] args)throws IOException{
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  System.out.print("First String is  : ");
	  String str1 = bf.readLine();
	  System.out.print("Second String is : ");
	  String str2 = bf.readLine();

	  System.out.println("By First Method");
	  String Game = str1.concat(str2);
	  System.out.println("Resulted String is : "+Game);

	  System.out.println("\nBy Second Method");
	  String Game1 = str1+str2;
	  System.out.println("Resulted String is : "+Game1);
  }
}