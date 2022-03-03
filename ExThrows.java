import java.io.*;
class ExThrows{
	public static void main(String args[]){
		  String mark[] = new String[3];
		  mark[0] = "H";
		  mark[1] = "A";
		  mark[2] = "I";
		  pass(mark);
	}
	static void pass(String mark[]){
		try{
			for(int i=0;i<=4;i++){
				System.out.println(mark[i]);
			}
		}catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Enter All Require Information");
		}
	}
}
