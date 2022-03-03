class ThisExa{
	 String t;
	public  void display(String b){
				String t = "11111";
				this.t = b;
				System.out.println("b is "+b);
				System.out.println("t is "+t);
				System.out.println("this.t is "+this.t);
		}

	public static void main(String a[]){
		String aa = "welcome";
		new ThisExa().display(aa);

	}
}