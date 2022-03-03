package pra;
class Base{
	String a;
	Base(){
		a="base";
		System.out.println("base without arguements");
	}
	Base(int a){
		System.out.println("base "+a);
	}
	void display(){
		System.out.println("Display base "+a);
	}
}
class Derived extends Base{
	String a;
	Derived(){
		a="Derived";
		System.out.println("Derived");
	}
	Derived(int a){
		this();
		System.out.println("Derived "+a);
	}
	void display(){
		super.display();
		System.out.println("Display derived "+a+" "+super.a);
	}
	static public void main(String args[]){
		Derived d = new Derived(10);
		d.display();
	}
}