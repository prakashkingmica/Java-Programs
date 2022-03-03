class BaseExa{
	int c = 10;
	BaseExa(){
		System.out.println("This is Base class constructor");
	}
	void welcome(){
		System.out.println("This is Base class method\n");
	}
}
class DerivedExa extends BaseExa{
	DerivedExa(){
		super();
		System.out.println("This is Derived class constructor");
	} 
	int c=23;
	public int add(){
		int c = 5;
		System.out.println("Value of c is (this) "+this.c);
		System.out.println("Value of c is (super) "+super.c);
		System.out.println("Value of c inside the method is "+c);
		return c;
	}
}
public class InheritanceExa extends DerivedExa{
	public static void main(String arg[]){
	BaseExa b = new BaseExa();
	//Base d = new Derived();
	//Derived b = new Base();
	b.welcome();
	DerivedExa d = new DerivedExa();
	System.out.println("Value of c by using return "+d.add()+"\n");
	}
}

