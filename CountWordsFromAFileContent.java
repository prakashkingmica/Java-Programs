import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

class CountWordsFromAFileContent {
	static String fileName = "Test.txt";
	static HashMap<String, Integer> words = null;
	static BufferedReader reader = null;
	
	public static void main(String[] args){
		try{
			String textContent = getFile();
			countWords(textContent);
			findWord();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// To read the Content from the File
	public static String getFile(){
		String textContent = "";
		try{
			File file = new File(fileName);
			if (!file.exists()) {
				return "";
			}
			reader = new BufferedReader(new FileReader(fileName));
			StringBuilder content = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(" ");
			}
			textContent = content.toString();
		}catch(FileNotFoundException fi){
			fi.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return textContent;
	}
	
	// To count the words in a String
	public static void countWords(String textContent){
		words = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(textContent.toLowerCase(), ". ", false);
		System.out.println("\nThe String is:  " + textContent);
		System.out.println("Total no. of words is:  " + st.countTokens());
		while(st.hasMoreTokens()){
			String word = st.nextToken();
			int count = 1;
			if(words != null){
				if(words.containsKey(word)){
					Integer cnt = words.get(word);
					count += cnt.intValue();
				}
				words.put(word, new Integer(count));
			}
		}
	}
	
	//To find a particular word that is how many times appeared in a String
	public static void findWord(){
		try{
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the word to find that how many times appeard in that String: ");
			String fnWord = reader.readLine().trim();
			//fnWord = !fnWord.equals("") ? fnWord.toLowerCase() : "";
			if(fnWord.equals("")){
				System.out.println("Searcheable word is empty....");
			}else if(words != null && words.size() > 0 && words.containsKey(fnWord.toLowerCase())){
				System.out.println("The Word '" + fnWord + "' is appeard at " + words.get(fnWord.toLowerCase()) + " time(s)....");
			}else{
				System.out.println("The Word '" + fnWord + "' is not appeard...");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}