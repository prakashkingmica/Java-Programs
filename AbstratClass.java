package pra;
abstract class AbstractClassEx{
	abstract void add();
	abstract void add1();
	abstract void add2();
	void add3(){
	}
	void add4(){
		int a=1;
		int b=2;
		int c=a+b;
		System.out.println(c);
	}
}
public class AbstratClass extends AbstractClassEx{
	void add(){
		System.out.println("Overrided method");
	}
	void add1(){
		System.out.println("Overrided method1");
	}
	void add2(){
		System.out.println("Overrided method2");
	}
	static public void main(String args[]){
		AbstratClass ab = new AbstratClass();
		ab.add();
	}
}