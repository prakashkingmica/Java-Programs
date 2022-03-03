class A{
	void add(){
		System.out.println("A class");
	}
	void sub(){
		System.out.println("A class Second Method");
	}
	void add(int a){
		System.out.println("A class Third Method");
	}
}
class B extends A{
	void add(int d){
		System.out.println("B class");
	}
}
class OverRidingExa{
	public static void main(String args[]){
		A a = new A();
		A b = new B();
		a.add();
		b.add(1);
		b.sub();
	}
}