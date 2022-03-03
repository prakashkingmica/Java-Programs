public class EqualsTest {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = s1;
		String s5 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println("== comparison1 : " + (s1 == s5));
		System.out.println("== comparison2 : " + (s1.equals(s5)));
		System.out.println("== comparison : " + (s1 == s2));
		System.out.println("Using equals method : " + s1.equals(s2));
		System.out.println("== comparison : " + s3 == s4);
		System.out.println("Using equals method : " + s3.equals(s4));
		System.out.println("== comparison : " + s1 == s4);
	}
}