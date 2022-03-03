// Use iterators with a Hashtable.

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
class HashTableDemoWithIterator {
	public static void main(String args[]) {
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		String str;
		double bal;
		balance.put("John Doe", new Double(3434.34));
		balance.put("Tom Smith", new Double(123.22));
		balance.put("Jane Baker", new Double(1378.00));
		balance.put("Todd Hall", new Double(99.22));
		balance.put("Ralph Smith", new Double(-19.08));

		// show all balances in hashtable
		Set<String> set = balance.keySet(); // get set-view of keys

		// get iterator
		Iterator<String> itr = set.iterator();
		System.out.println();
		while(itr.hasNext()) {
			str = itr.next();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();

		// Deposit 1,000 into John Doe's account
		bal = balance.get("John Doe").doubleValue();
		balance.put("John Doe", new Double(bal+1000));
		System.out.println("John Doe's new balance: " +
		balance.get("John Doe"));
	}
}