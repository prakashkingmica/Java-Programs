import java.io.*;
class FibonacciExample implements Runnable{
	public void run(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Total No. : ");
			int total = Integer.parseInt(br.readLine()), a = 0, b = 1, sum = 0;
			if(total>2){
				Thread.sleep(300);
				System.out.println(a);
				Thread.sleep(300);
				System.out.println(b);
				for(int i = 2; i <total; i++){
					sum = a+b;
					Thread.sleep(300);
					System.out.println(sum);
					a = b;
					b = sum;
				}
			}else{
				System.out.println("\nEnter no. more than 2");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] ar){
		FibonacciExample fe = new FibonacciExample();
		fe.run();
	}
}