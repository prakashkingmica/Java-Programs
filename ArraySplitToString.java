
public class ArraySplitToString {
	public String[][] stringSplitToString(String input, String row, String col){

		String[] rowSplit = input.split(row);
		if(rowSplit != null){
			int len = rowSplit[0].split(col).length;
			String[][] data = new String[rowSplit.length][len];		
			for(int i = 0; i < rowSplit.length; i++){
				String[] colSplit = rowSplit[i].split(col);
				for(int j = 0;  j < colSplit.length; j++){
					data[i][j] = colSplit[j];
				}
			}
			return data;
		}
		return null;
	}
	public static void main(String[] args){
		String inp = "a#b#c$d#e#f$g#h#i$";
		ArraySplitToString a1 = new ArraySplitToString();
		String[][] data = a1.stringSplitToString(inp, "\\$", "#");
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println();
		}
	}
}
