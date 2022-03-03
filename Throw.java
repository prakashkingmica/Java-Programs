import java.io.BufferedReader;
import java.io.InputStreamReader;
class Throw{
	int balance, debit;
	void amount(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Available balance is : ");
			balance = Integer.parseInt(br.readLine());
			System.out.print("Enter Debit amount : ");
			debit = Integer.parseInt(br.readLine());

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	void success(){
		try{

			//balance=2000;
			//debit=1488;
			System.out.println("bal====>" + balance);
			balance=balance-debit;
			if(balance < 500){
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
		t.amount();
		t.success();
	//	System.out.println(t);
	}

	/*public String toString(){
		System.out.println("This is created by Anbu");
		return "This is created by prakash";
	}*/
}