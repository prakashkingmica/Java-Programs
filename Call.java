package pra;
class A implements InterfaceEx{
	int a,b,c;
	void add(int p){
		a=p;
		System.out.println("a is "+p);
	}
	void add(int p,int q){
			a=p;
			b=q;
			System.out.println("a is "+p);
			System.out.println("b is "+q);
	}
	void add(int p, int q, int r){
			a=p;
			b=q;
			c=r;
			System.out.println("a is "+p);
			System.out.println("b is "+q);
			System.out.println("c is "+r);
	}
	public void add1(){
		System.out.println("Hi");
	}
	public void add(){
			System.out.println(a);
			InterfaceEx.a =100;
			System.out.println(InterfaceEx.a);
	}
}
class Call{
	public static void main(String args[]){
		int p = Integer.parseInt(args[0]);
		int q = Integer.parseInt(args[1]);
		int r = Integer.parseInt(args[2]);
		A ob = new A();
		ob.add(p,q);
		ob.add();
	}
}