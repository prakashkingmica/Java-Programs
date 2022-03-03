
import java.util.Arrays;

public class  ArrayExa{
	public static void main(String[] args){
		String input = "name=prakash/age=24/sex=male";
		ArraySplitToString ex = new ArraySplitToString();
		String[][] outArray = ex.stringSplitToString(input, "/", "=");
		System.out.println("Length is "+outArray.length);
		for(int i=0; i<outArray.length; i++){
			System.out.println(i+1+"th key is "+outArray[i][0]);
			System.out.println(i+1+"th value is "+outArray[i][1]);
		}
		int[] num = {50,20,45,82,25,63};
		int[][] matrix = new int[20][40];
		int l = num.length;
		int i;
		System.out.print("Given number : ");
		for (i = 0;i < l;i++ ){
			System.out.print("  " + num[i]);
		}
		System.out.println();
		System.out.print("Accending order number : ");
		Arrays.sort(num);
		for(i = 0;i < l;i++){
			System.out.print("  " + num[i]);
		}
		System.out.println("\n");
		System.out.println("Number of rows in matrix array is " + matrix.length);
		System.out.println("Number of columns in matrix array is " + matrix[0].length);
		System.out.println("Number of rows in num array is " + num.length);
	}
}