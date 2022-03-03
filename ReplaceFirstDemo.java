public class ReplaceFirstDemo {
	public static void main(String[] args) {
		String str = "Her name is Tamana and Tamana is a super Figure.";
		String strreplace = "Hansika";
		String result = str.replaceFirst("Tamana", strreplace);
		System.out.println("\nGiven input is '"+str+"'");
		System.out.println("The replaced output is '"+result+"'\n");
	}
}