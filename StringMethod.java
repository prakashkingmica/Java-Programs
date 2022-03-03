public class StringMethod{
	public static void main(String[] args){
		String string1 = "Hi";
		String string2 = new String("Hi");
		if (string1 == string2) {
			System.out.println("The strings are equal.");
		} else {
			System.out.println("The strings are unequal.");
		}
		if (string1.equals(string2)) {
			System.out.println("The string values are equal.");
		} else {
			System.out.println("The string values are unequal.");
		}
	}
}