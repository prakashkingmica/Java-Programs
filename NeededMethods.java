import java.util.Hashtable;
public class NeededMethods{

	String outputArray1[];
	String outputArray2[];
	String outputArray3[][];

	public Hashtable<String, String> stringSplitToHashtable(String output, String row, String column){
		outputArray1 = output.split(row);
		Hashtable<String, String> hash = new Hashtable<String, String>();
		for(int i = 0; i < outputArray1.length; i++){
			outputArray2 = outputArray1[i].split(column);
			String key = outputArray2[0];
			String value = outputArray2[1];
			hash.put(key, value);
		}
		return hash;
	}

	public String[][] stringSplitToArray(String output, String row, String column){
		outputArray1 = output.split(row);
		for(int i = 0; i < outputArray1.length; i++){
			outputArray2 = outputArray1[i].split(column);
			for(int j = 0; j < outputArray2.length; j++){
				outputArray3[i][j] = outputArray2[j];
			}
		}
		return outputArray3;
	}
}