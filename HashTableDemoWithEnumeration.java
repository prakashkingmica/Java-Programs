// Demonstrate a Hashtable with Enumeration

import java.util.*;
class HashTableDemoWithEnumeration {
	public static void main(String args[]) {
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		Enumeration<String> names;
		String str;
		double bal;
		balance.put("John Doe", new Double(3434.34));
		balance.put("Tom Smith", new Double(123.22));
		balance.put("Jane Baker", new Double(1378.00));
		balance.put("Todd Hall", new Double(99.22));
		balance.put("Ralph Smith", new Double(-19.08));

		// Show all balances in hash table.
		names = balance.keys();
		System.out.println();
		while(names.hasMoreElements()) {
			str = names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();

		// Deposit 1,000 into John Doe's account
		bal = balance.get("John Doe").doubleValue();
		balance.put("John Doe", new Double(bal+1000));
		System.out.println("John Doe's new balance: " + balance.get("John Doe"));

		// Clear the HashTable
		balance.clear();
		names = balance.keys();
		System.out.println("After clearing the Hashtable the values are.....");
		while(names.hasMoreElements()) {
			str = names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();
	}
}
