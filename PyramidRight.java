class PyramidRight{
 /* public static void main(String[] args) {
	  int[][] a2 = new int[10][5];
	  for (int i=0; i<a2.length; i++) {
		for (int j=0; j<a2[i].length; j++) {
		 a2[i][j] = i+j;
		 System.out.print(" " + a2[i][j]);
		}
	  	System.out.println("");
	  }
  }*/
  public static void main(String[] args) {
  	  int n = 20;
  	  for (int i=1; i<=n; i++) {
  		for (int j=0; j<i; j++) {
  		 System.out.print("*");
  		}
  	  	System.out.println("");
  	  }
  }
}