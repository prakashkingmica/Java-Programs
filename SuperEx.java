package pra;
class A{
	int a=10;
	int b;
	int c;
	A(){
		System.out.println("This is a constructor");
	}

	A(int p, int q, int r){
		int a  = p;
		b = q;
		c = super.a + b;
		int d = c + r;
		System.out.println(c);
		System.out.println(d);
	}
}
class B extends A{
	B(int p, int q, int r, int s){
		super(p,q,r);
		System.out.println(s);
	}
	int a=2;
	int b;
	int c;
	void meth(){
	//super(p,q,r);
	a=super.a;
		b=10;
		c=a+b;
		System.out.println(c);
	}
}
class SuperEx{
	public static void main(String args[]){
		//A a1=new A();
		A a=new A(20,10,15);
		//B b=new B();
		B b1=new B(1,2,3,4);
		b1.meth();
	}
}