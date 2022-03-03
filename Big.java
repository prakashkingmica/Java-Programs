// By Loop
class Big{
	public static void main (String args[]){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);
		if(a>b && a>c && a>d){
			System.out.println("big is "+a);
		}else if(b>c && b>d){
			System.out.println("big is "+b);
		}else if(c>d){
			System.out.println("big is "+c);
		}else{
			System.out.println("big is "+d);
		}


	}

}