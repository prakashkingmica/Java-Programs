import java.io.*;
class Throw{
	void success(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//int balance, debit;
			//balance=2000;
			//debit=1488;
			System.out.print("Available balance is : ");
			int balance = Integer.parseInt(br.readLine());
			System.out.print("Enter Debit amount : ");
			int debit = Integer.parseInt(br.readLine());
			balance=balance-debit;
			if(balance<500){
				throw new LBException();
			}else{
				System.out.println("Transaction Success");
				System.out.println("Your Current balance is "+balance);
			}
		}catch(LBException ex){
			System.out.println(ex);
		}
	}
	public static void main(String args[]){
		Throw t = new Throw();
		t.success();
	}
}