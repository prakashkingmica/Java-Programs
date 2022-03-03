
// By Condition

class Biggest{
	public static void main (String args[]){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		int d = Integer.parseInt(args[3]);
		int big1 = a>b?a:b;
		int big2 = c>d?c:d;
		int output = big1>big2?big1:big2;
		System.out.println("big is "+output);

	}

}