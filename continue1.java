package pra;
class continue1{
	public static void main(String args[]){
		for(int i=0;i<10;i++){
			System.out.println(i);
			if(i%2==0){
				System.out.println("inner if "+i);
				continue;
			}
			System.out.println("Hi........");
		}
	}
}