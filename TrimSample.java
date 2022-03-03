public class TrimSample{
    public static void add(){
		System.out.println("Welcome to Servlet");
	}
    public static void main(String[] args){
        String str = "\t    This is a String.   \n";

        // Trim the whitespace from the front and back of the
        // String.
        String newStr = str.trim();
        add();

        // Display the strings for comparison.
        System.out.println("old = " + str);
        System.out.print("new = " + newStr+"!");
    }
}