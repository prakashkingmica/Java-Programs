
import java.util.*;
public class HashSetDemo {
        public static void main(String args[]) {

                HashSet<String> HSet = new HashSet<String>();

                HSet.add("C");
                HSet.add("A");
                HSet.add("B");
                HSet.add("E");
                HSet.add("F");
                HSet.add("D");
                HSet.add("A");
                HSet.add("E");

                Set<String> set = new TreeSet<String>(HSet);
                Iterator<String> i = set.iterator();
                while(i.hasNext()){
				    String value =i.next();
				    System.out.println("Value :"+value);
        		}
                System.out.println("The HashSet elements are: " + HSet);
        }
}