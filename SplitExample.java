class SplitExample{
	public static void main(String args[]){

		//1st exa
		String name = args[0];
	//	String a[] = name.split("\\.");
		String limiter = "\\-";
		String a[] = name.split(limiter);
		for(int i=0; i<a.length; i++){
			System.out.println(i+1+"th word is "+a[i]+"\n");
		}

		//2nd exa
		String rep = name.replaceAll("o","*");
		System.out.println("replace value is "+rep);
		}
}