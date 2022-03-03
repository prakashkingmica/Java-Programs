import java.io.*;
class BiggestValue{
	public static void main(String args[]){
		System.out.print("No is : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String no = br.readLine();
			int a1 = Integer.parseInt(Character.toString(no.charAt(0)));
			int b1 = Integer.parseInt(Character.toString(no.charAt(1)));
			int big = (a1>b1?a1:b1);
			for(int i=2; i<no.length(); i++){
				int c1 = Integer.parseInt(Character.toString(no.charAt(i)));
				big = (big>c1?big:c1);
			}
			System.out.println("Biggest value is "+big);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

// To compile  javac -d . BiggestValue.java
// To run      java common.BiggestValue