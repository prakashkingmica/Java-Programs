
public class SortWords{
	public static void main(String args[]){
		String str = "This is my new string";
		char[] content = str.toCharArray();
		System.out.println(content);		
		java.util.Arrays.sort(content);
		String sorted = new String(content);
		System.out.println(sorted);
	}
}