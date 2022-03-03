//package pra;
import java.util.StringTokenizer;
// Demonstrate StringTokenizer.

public class StringTokenizerDemo {
	static String in = "title=Java-Samples;author=Emiley J;publisher=java-samples.com;copyright=2007;";
	public static void main(String args[]) {
		StringTokenizer st = new StringTokenizer(in, "=;");
		while(st.hasMoreTokens()) {
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + "\t" + val);
		}
		
	  StringTokenizer stringTokenizer = new StringTokenizer("You are tokenizing a string into many Tokens", " ", false);
			  System.out.println("The total no. of tokens generated :  " + stringTokenizer.countTokens());
			  while(stringTokenizer.hasMoreTokens()){
				  System.out.println(stringTokenizer.nextToken());
			  }
	}
}
