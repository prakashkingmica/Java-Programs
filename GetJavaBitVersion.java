public class GetJavaBitVersion{
	public static void main(String args[]){
		String bitVersion = System.getProperty("sun.arch.data.model");
		System.out.println("bitVersion is " + bitVersion);
	}
}
