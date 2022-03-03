//import java.util.*;
import java.io.*;
//import java.lang.String;

public class StringCount{
	public static void main(String args[]){
		String searchFor = "i";
		String base = "This is the method";
		int len = searchFor.length();
		System.out.println("length of searched word is "+len);
		int result = 0;
		if (len > 0) {
			int start = base.indexOf(searchFor);
			System.out.println("start position of the char ("+searchFor+") is "+start);
			while (start != -1) {
				result++;
				start = base.indexOf(searchFor, start+len);
				//System.out.println("Start value in While Loop is "+start);
			}
		}
		System.out.println("No. of ("+searchFor+")s in the given String is "+result);
	}
}