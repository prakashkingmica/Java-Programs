package newFiles;

public class StringBuilderMethods {

	public static void main(String[] args) {
		
		StringBuilder sa = new StringBuilder("Hi");
		String 		   s = new String("welcome");
		StringBuilder sb = new StringBuilder(s);
		/*StringBuilder sc = new StringBuilder(10);
		StringBuilder sd = new StringBuilder('a');
		StringBuilder se = mew StringBuilder();*/
		
// Append boolean value		
		sa.append(true);
		System.out.println("Sa after append of true is "+sa);
// Append a character		
		sa.append('s');
		System.out.println("Sa after append of 's' is "+sa);
// Find sb length		
		System.out.println("StringBuilder length is " + sa.length());
// Append char seq or string with specified start and end position itself
		sa.append(sa, 0, 3);
		System.out.println("Sa after append of char seq is "+sa);
// Append a object		
		sa.append(sa);
		System.out.println("Sa after append of object sa is "+sa);
// Insert boolean value			
		sa.insert(3, false);
		System.out.println("Sa after insert of boolean false is "+sa);
// Get the position of the String 		
		int s2 = sa.indexOf("t");
		System.out.println("Index of sa is "+s2);
// Get the position of the String from specified position 
		int s3 = sa.indexOf("Hit", 0);
		System.out.println("Index of sa is "+s3);
// Insert the boolean value in between specified position		
		sb.insert(3, true);
		System.out.println("sb after insert true in position 3 is "+sb);
// Insert at specified position with specified start and end position of input		
		sb.insert(5, s, 0, 5);
		/* It inserts from 5th position of source object. insertion starts from 0th position to
		   4th position */
		System.out.println("sb after insert is "+sb);
// LastIndex of the String		
		int s4 = sb.lastIndexOf("m");
		System.out.println("lastIndex of m in sb is "+s4);
// Delete from Object		
		System.out.println("sb is "+sb);
		sb.delete(2, 5);
		// It deletes from 2nd position to 4th position
		System.out.println("sb after deletion is "+sb);

	}

}
