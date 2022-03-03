package pra;

class SumOfArrays{
		  public static void main(String[] args)  {
		  int array[][]= {{4,5,6},{6,8,9}};
		  int array1[][]= {{5,4,6,3},{5,6,7,4}};
		 // System.out.println("Number of Row= " + array.length);
		  //System.out.println("Number of Column= " + array[0].length);
		  int l= array.length;
		  int m= array[0].length;
		  System.out.println("Array length : "+l);
		  System.out.println("Matrix 1 : ");
		  for(int i = 0; i < l; i++) {
			  for(int j = 0; j < m; j++) {
				  System.out.print(" "+ array[i][j]);
			  }  
			  System.out.println();
		  }  
		  int n= array1.length;
		  int o= array1[0].length;
		  System.out.println("Array1 length : "+m);
		  System.out.println("Matrix 2 : ");
		  for(int i = 0; i < n; i++) {
			  for(int j = 0; j < o; j++) {
				  System.out.print(" "+array1[i][j]);
			  }  
			  System.out.println();
		  }
		  m = n>l?n:l;
		  l = o>m?o:m;
		  System.out.println("Addition of both matrix : ");
		  for(int i = 0; i < m; i++) {
			  for(int j = 0; j < l; j++) {
				  int sum1;
				  int sum2;
				  
				  try {
					sum1 = array[i][j];
				  } catch (Exception e) {
					sum1 = 0;
				  }
				  try {
					sum2 = array1[i][j];
				  } catch (Exception e) {
					sum2 = 0;
				  }
				  
				  System.out.print(" "+(sum1+sum2));
			  }  
			  System.out.println();
		  }
	  }
	}