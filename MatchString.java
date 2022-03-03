import java.io.*;
public class MatchString{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("First String is : ");
		String str1 = br.readLine();
		System.out.print("Second String is : ");
		String str2 = br.readLine();
		System.out.println("First String Length is : "+str1.length());
		System.out.println("Second String Length is : "+str2.length());
		System.out.print("The index of the first character in the current String used for comparing to str2 is : ");
		int c1 = Integer.parseInt(br.readLine());
		System.out.print("The index of the first character in str2 used for comparing to the current String is : ");
		int c2 = Integer.parseInt(br.readLine());
		System.out.print("The number of characters within the two String objects to compare is                 : ");
		int c3 = Integer.parseInt(br.readLine());

		boolean result = str1.regionMatches(true, c1, str2, c2, c3);
		System.out.println("The Result is "+result);
	}
}