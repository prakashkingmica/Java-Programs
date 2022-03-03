class Test2{
	public static void main (String arg[]){
		byte b=127;
		String a="prakash";
		int x=0x1234;
		Integer i = new Integer(0);
		Float f=new Float(0);
		//System.out.println(i==f);
		System.out.println(i.equals(f));
		String s1="Prakash hai..........";
		System.out.println(s1);
		System.out.println("Value of b is : "+b);
		System.out.println("Value of x is : "+x);
		if(0.0==-0.0){
			System.out.println("This is true");
			}
		if("prakash".startsWith("")){
			System.out.println("True");
		}else{
			System.out.println("false");
		}
		System.out.println("prakash".substring(0,6));
		if("prakash".substring(0,6)=="String"){
			System.out.println("Equal");
			}else{
				System.out.println("false");
			}

	}public static void main (String arg[]){}

}