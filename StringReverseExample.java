import java.io.*;
public class StringReverseExample{
  public static void main(String[] args){
  	String string=args[0];
	StringBuffer rever = new StringBuffer(string);
	StringBuffer re = rever.reverse();
	String reverse = re.toString();
	System.out.println("\nString before reverse: "+string);
	System.out.println("String after reverse:  "+reverse);
  }
}
