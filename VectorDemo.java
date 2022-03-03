// Demonstrate various Vector operations.

import java.util.Enumeration;
import java.util.Vector;
class VectorDemo {
	public static void main(String args[]) {

	// initial size is 3, increment is 2
		Vector<Object> v = new Vector<Object>(3, 3);

		System.out.println("Initial size               : " + v.size());
		System.out.println("Initial capacity           : " +v.capacity()+"\n");

		v.addElement(new Integer(10));
		v.addElement(new Integer(20));
		v.addElement(new Integer(30));
		v.addElement(new String("Prakash"));

		System.out.println("Capacity after 4 additions : " +v.capacity());
		System.out.println("Current size               : " + v.size()+"\n");

		v.addElement(new Double(5.45));

		System.out.println("Current capacity           : " +v.capacity());
		System.out.println("Current size               : " + v.size()+"\n");

		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));

		System.out.println("Current capacity           : " +v.capacity());
		System.out.println("Current size               : " + v.size()+"\n");

		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));

		System.out.println("Current capacity           : " +v.capacity());
		System.out.println("Current size               : " + v.size()+"\n");

		v.addElement(new Integer(11));
		v.addElement(new Integer(12));

		System.out.println("Current capacity           : " +v.capacity());
		System.out.println("Current size               : " + v.size()+"\n");

		System.out.println("First element              : " +(Integer)v.firstElement());
		System.out.println("3rd element                : " +(String)v.elementAt(3)+"\n");

		boolean bo = (v.contains(new Integer(234)));
		System.out.println("Status is "+bo+"\n ");

		if(v.contains(new Integer(3)))
		System.out.println("Vector contains 3.\n");

		// enumerate the elements in the vector.
		Enumeration<Object> Enum = v.elements();
		System.out.print("Elements in vector           :\n\n");

		while(Enum.hasMoreElements())
		System.out.print(Enum.nextElement() + " ");

		System.out.println("");
	}
}