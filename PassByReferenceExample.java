public class PassByReferenceExample{
	public static void main(String[] args){
	//"test" is a pointer.
		int[] test = {1, 2, 3, 4};
	//The original hex value of the pointer
		System.out.println("test's pointer: ");
        for(int i=0; i<test.length; i++)  {
               System.out.print(test[i]+" ");
          }
          System.out.println();
	//Let’s pass test’s pointer into a method.
	//The method attempts to change test's //pointer.
        PassByReferenceExample e = new PassByReferenceExample();
        e.modifyPointer(test);
	//The method failed to change the pointer!
		System.out.println("test's pointer: ");
	//This prints out "1 2 3 4", not "9 9 9 9"
        for(int i=0; i<test.length; i++)  {
               System.out.print(test[i]+" ");
          }
          System.out.println();
     }

    public void modifyPointer(int[] a){
      //"b" is a new pointer.
		int[] b = {9, 9, 9, 9};
	//The hex value of b’s pointer
		System.out.println("b's pointer: ");
        for(int i=0; i<b.length; i++)  {
               System.out.print(b[i]+" ");
          }
          System.out.println();
//"a" now points to the same thing as "b".
          a = b;
//The hex value of a’s pointer
		System.out.println("a's pointer: ");
        for(int i=0; i<a.length; i++)  {
               System.out.print(a[i]+" ");
          }
          System.out.println();
  //But this affects nothing outside the

//method. "test" does not point to "b"!

//Only "a" points to "b".

	}
}



/*
Output :


test's pointer:
1 2 3 4
b's pointer:
9 9 9 9
a's pointer:
9 9 9 9
test's pointer:
1 2 3 4


*/