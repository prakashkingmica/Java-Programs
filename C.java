package pra;
class A{
	int x;
	int y;
	int get(int p, int q){
		x=p;
		y=q;
		return(0);
	}
	void show(){
		System.out.println("X is : "+x);
	}
}
class B extends A{
	void display(){
		System.out.println("Y is : "+y);
	}
}
class C extends B{
	void detail(){
		System.out.println("X is : "+x);
	}
	public static void main(String args[]){
		A a = new A();
		a.get(3,4);
		a.show();
		C c = new C();
		c.get(2,3);
		c.show();
		c.display();
	}
}
