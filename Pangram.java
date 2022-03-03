
//A pangram is a sentence or expression that uses all the letters of the alphabet.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Pangram {
	public static void main(String[] args) {
		String sentence="";
		Scanner input=new Scanner (System.in);
		try{
			String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			ArrayList<String> arr = new ArrayList<String>();
			for(int i = 0; i < alpha.length; i++){
				arr.add(alpha[i]);
			}
			System.out.print("Please enter a sentence: " );
			sentence = input.nextLine();
			StringTokenizer token = new StringTokenizer(sentence);
			while(token.hasMoreTokens()){
				String word = token.nextToken();
				for(int j = 0; j < word.length(); j++){
					char c = word.charAt(j);
					for(int k = 0; k < arr.size(); k++){
						if(arr.get(k).equals(Character.toString(c))){
							arr.remove(k);
							break;
						}
					}
				}
			}
			
			if(arr.size() == 0)
				System.out.println("sentence is a pangram");
			else
				System.out.println("sentence is not a pangram");
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}