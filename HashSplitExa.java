import java.util.*;
class HashSplitExa{
	public static void main(String args[]){
		Hashtable<String,String> hash = null;
		Enumeration<String> e = null;
		String key;
		String value;
		String name = "0=zero/1=one/2=two/3=three/4=four/5=five/6=six/7=seven/8=eight/9=nine";
		NeededMethods need = new NeededMethods();
		hash = need.stringSplitToHashtable(name, "/", "=");
		e = hash.keys();
		while(e.hasMoreElements()){
			key = e.nextElement();
			value = hash.get(key);
			System.out.println("Key is "+key);
			System.out.println("Value is "+value);
			System.out.println();
		}

	}

}