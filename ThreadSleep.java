import java.io.*;
public class ThreadSleep extends Thread{

	public void run(){
		System.out.println("\nRun method is called");
	}

	public void display(){
		System.out.println("Display method is called");
	}

	public static void main(String[] args)throws IOException{
		try{

		Thread th = new Thread();
		ThreadSleep ths = new ThreadSleep();
		ths.start();
		ths.sleep(50);
		ths.sleep(50);

		BufferedReader br = null;
		System.out.println("Numbers are printing line by line after 5 seconds : ");
		try{

			for(int i = 1; i <= 10; i++){
				System.out.println(i);
				if(i==5){
					ths.display();
					ths.sleep(500);
				}
				Thread.sleep(200);
			}

			System.out.print("\nEnter the String : ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String in = br.readLine();
			System.out.println();

			for(int i = 0; i < in.length(); i++){
				char c = in.charAt(i);
				th.sleep(100);
				System.out.print(c);
			}
			System.out.println();

		}catch(InterruptedException e){
			System.out.println("Thread interrupted!");
			e.printStackTrace();
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
}