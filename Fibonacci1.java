
class Fibonacci1{
	public static void main(String args[]){
	 int limit = 15;
	 int [] sequence = new int[limit];
	 sequence[0] = 0;
	 sequence[1] = 1;
	 System.out.println(sequence[0]+" ");
	 System.out.println(sequence[1]+" ");
	 for(int i=2;i<limit;i++){
		 sequence[i] = sequence[i-2]+sequence[i-1];
		 System.out.println(sequence[i]+" ");
	}
		// System.out.println("The Fibonacci series is upto 15");
   }
}