//Create Thread by Extending Thread class

public class ThreadExample extends Thread {
  public void run() {
      System.out.println("Creation of Thread By Extending Thread Class");
   }
   public static void main(String args[]) {
      ThreadExample t = new ThreadExample();
      t.start();
   }
}
