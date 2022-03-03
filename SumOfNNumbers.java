import java.io.*;
class SumOfNNumbers{
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Total No. : ");
			int t = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int i = 1; i <= t; i++){
				sum	 = sum + i;
			}
			System.out.println("Sum of "+t+" Numbers is : "+sum);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}