import java.io.*;
class StringReverseByLogic{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the String : ");
		StringBuffer a = new StringBuffer(br.readLine());
		StringBuffer b = new StringBuffer();
		for(int i = a.length()-1; i >= 0; i--){
				b = b.append(a.charAt(i));
		}
		System.out.println("Reversed String is "+b);
	}
}