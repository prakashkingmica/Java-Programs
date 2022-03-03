import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
class MyCollections{
	public static void main(String[] args){
		Hashtable<Integer, String> htable = new Hashtable<Integer, String>();
		HashMap<Integer, String> hmap	 = null;
		//HashSet<String> hset	 = null;
		Map<Integer, String> map			 = null;
		//Map<Integer, String> tmap		 = null;
		Set<Integer> set			 = null;
		TreeMap<Integer, String> trmap	 = null;
		TreeSet<String> tset	 = new TreeSet<String>();;

		htable.put(new Integer(2), "Two");
		htable.put(new Integer(4), "Four");
		htable.put(new Integer(5), "Five");
		htable.put(new Integer(1), "One");
		htable.put(new Integer(3), "Three");

		Hashtable<Integer, String> ht1 	 = new Hashtable<Integer, String>(htable);
		hmap 			 = new HashMap<Integer, String>(ht1);
		map 	 	 	 = new HashMap<Integer, String>(hmap);
		Hashtable<Integer, String> ht4 	 = new Hashtable<Integer, String>(map);
		trmap			 = new TreeMap<Integer, String>(map);
		Hashtable<Integer, String> ht5 	 = new Hashtable<Integer, String>(trmap);

		set = ht4.keySet();

		System.out.println("\n htable Size is "+htable.size());
		System.out.println("\n htable values are "+htable);
		System.out.println("\n ht4 size is "+ht4.size());
		System.out.println("\n ht4 values are "+ht4);
		System.out.println("\n trmap size is "+trmap.size());
		System.out.println("\n trmap values are "+trmap);
		System.out.println("\n ht5 values are "+ht5);
		System.out.println("\n set values are "+set);
		System.out.println("\n tset size is "+tset.size());


		System.out.println("*****HashTable***");
		Hashtable<String, String> htb1 = new Hashtable<String, String>();
		Hashtable<String, String> htb2 = new Hashtable<String, String>(3);
		htb1.put("1", "One");
		htb1.put("5", "FIve");
		htb1.put("6", "Six");
		htb1.put("7", "Seven");
		System.out.println("htb2 size before  is "+htb2.size());
		htb2 = new Hashtable<String, String>(htb1);
		System.out.println("htb2 size after is "+htb2.size());

	}
}