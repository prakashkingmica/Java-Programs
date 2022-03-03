import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class EquilibriumFinder {
	public static void main(String[] args){
		System.out.print("\nEnter the total: ");
		Scanner sc = new Scanner(System.in);
		Integer len = sc.nextInt();
		System.out.println("Length is : " + len);
		System.out.println("Enter the Numbers: ");
		Integer[] numbers = new Integer[len];
		long backEnd = 0;
		for(Integer a = 0; a < len; a++){
			numbers[a] = sc.nextInt();
			backEnd += numbers[a]; 
		}
		System.out.println("Your Final Array is " + Arrays.toString(numbers));
		findEquilibrium(numbers, backEnd);
	}
	public static void findEquilibrium(Integer[] Numbers, long backEnd1){
		Map<Integer, Integer> equili = new TreeMap<Integer, Integer>();
		long len = Numbers.length;
		long frontEnd = 0;
		long backEnd = backEnd1;
		for(Integer i = 0; i < len; i++){
			backEnd -= Numbers[i];
			if(frontEnd == backEnd){
				equili.put(i, Numbers[i]);
			}
			frontEnd += Numbers[i];
		}
		String message = equili.size() > 0 ? "Equilibrium Indexes and Numbers are " + equili : "No Equilibrium Indexes are found";
		System.out.println(message);
	}
}