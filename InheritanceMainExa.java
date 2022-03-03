//base and derived -- serious problem in my understanding
class Base
{
    int i=1;
    int j=2;
    public Base()
    {
		System.out.println("This's Base class Constructor");
    }
    public void display()
    {
		System.out.println("This's Base class Display Method");
        System.out.println("i="+i);
        System.out.println("j="+j);
    }
    public void baseDisplay()
	{
		System.out.println("This's Base class baseDisplay Method");
	    System.out.println("i*i value is "+i*i);
	    System.out.println("j*j value is "+j*j);
    }
}
class Derived extends Base
{
    int p=3;
    int q=4;
    public Derived()
    {
		System.out.println("This's Derived class Constructor");
    }
    public void display()
    {
		System.out.println("This's Derived class Display Method");
        System.out.println("p="+p);
        System.out.println("q="+q);
    }

    public void uniqueDisplay()
    {
    	System.out.println("This is uniqueDiplay method");
    }
}
public class InheritanceMainExa
{
    public static void main(String[] args)
    {
        Base b=new Base();
        Derived d=new Derived();

        b.display();
        d.display();
        d.uniqueDisplay();
        d.baseDisplay();


/*        // derived is assigned to base

        b=d;

        // Object is derived, reference is of base type

        b.display();
        b.uniqueDisplay();*/






    }
}
