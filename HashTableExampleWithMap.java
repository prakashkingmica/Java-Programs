
import java.util.*;
import java.io.*;

public class HashTableExampleWithMap{
	public static void main(String[] args) throws IOException{
		String key;
		String value;
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("How many elements you want to enter to the hash table : ");
			int n = Integer.parseInt(in.readLine());
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			for(int i = 0; i < n; i++){
				System.out.print("Enter key for the hash table : ");
				key = in.readLine();
				System.out.print("Enter value for the key : ");
				value = in.readLine();
				hashTable.put(key, value);
			}
			Map<String, String> map = new TreeMap<String, String>(hashTable);
			System.out.println("map is "+map);
		}
		catch(Exception ne){
			System.out.println(ne.getMessage() + " is not a legal value.");
			System.out.println("Please enter a String value.");
			System.exit(1);
		}
	}
}