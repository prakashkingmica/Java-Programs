
import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class HashMapExample{
	public static void main(String args[]){

		Hashtable<Integer, String> hash =  new Hashtable<Integer, String>();
		HashMap<String, Serializable> hmap1 = new HashMap<String, Serializable>();
		HashMap<String, Object> hmap2 = new HashMap<String, Object>();

		for(int i = 0; i < 10; i++){
			hash.put(new Integer(i), "hash"+i);
			hmap2.put(new Integer(i).toString(), "map"+i);
		}
		hmap2.put("name", "hmap2");
		hmap1.put("hashvalue", hash);
		hmap1.put("name", "hmap1");

		Map<Integer, String> map = new TreeMap<Integer, String>(hash);
		Map<Integer, String> map1 = new HashMap<Integer, String>(map);
		Map<String, Serializable> map2 = new TreeMap<String, Serializable>(hmap1);
		Map<String, Serializable> map3 = new TreeMap<String, Serializable>(map2);
		HashMap<Integer, String> hmap3 = new HashMap<Integer, String>(map1);
		HashMap<Integer, String> hmap4 = new HashMap<Integer, String>(hash);
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>(map);
		Hashtable<String, Object> htl = new Hashtable<String, Object>(hmap2);
		Hashtable<Integer, String> htb = new Hashtable<Integer, String>(hash);

		hmap2.put("map3value", map3);

		System.out.println("\nValue is by hash is "+hash.get(new Integer(3)));
		System.out.println("\nValue is by ht is "+ht.get(new Integer(5)));
		System.out.println("\nValue is by htl is "+htl.get("3"));
		System.out.println("\nValue is by htb is "+htb.get(new Integer(7)));
		System.out.println("\nValue is by hmap1 is "+hmap1.get("hashvalue"));
		System.out.println("\nValues are by hmap1 is "+hmap1);
		System.out.println("\nValues are by hmap2 is "+hmap2);
		System.out.println("\nValue is by hmap3 is "+hmap3.get(new Integer(2)));
		System.out.println("\nValue is by hmap4 is "+hmap4);
		System.out.println("\nValues are by map is "+map);
		System.out.println("\nValue is by map31 is "+map1);
		System.out.println("\nValue is by map2 is "+map2.get("hashvalue"));
		System.out.println("\nValue is by map3 is "+map3);

		// With Iterator used hmap1 Keys are

		Set<String> set = hmap1.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println("\nValue is from hmap1 by iterator (keySet) is "+it.next());
		}

		Set<?> set2 = hmap2.entrySet();
		Iterator<?> it2 = set2.iterator();
		while(it2.hasNext()){
			System.out.println("\nValue is from hmap2 by iterator (entrySet) is "+it2.next());
		}

		// With Enumeration used hmap2 Keys and values are

		Enumeration<?> en = Collections.enumeration(hmap4.entrySet());
		while(en.hasMoreElements()){
			System.out.println("\nValue is from hmap4 by enumeration is "+en.nextElement());
		}

		// Displaying All Sizes

		System.out.println("\nhash  size is "+hash.size());
		System.out.println("\nht    size is "+ht.size());
		System.out.println("\nhtl   size is "+htl.size());
		System.out.println("\nhtb   size is "+htb.size());
		System.out.println("\nhmap1 size is "+hmap1.size());
		System.out.println("\nhmap2 size is "+hmap2.size());
		System.out.println("\nhmap3 size is "+hmap3.size());
		System.out.println("\nhmap4 size is "+hmap4.size());
		System.out.println("\nmap   size is "+map.size());
		System.out.println("\nmap1  size is "+map1.size());
		System.out.println("\nmap2  size is "+map2.size());
		System.out.println("\nmap3  size is "+map3.size());
	}
}