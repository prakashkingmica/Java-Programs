//Create Thread By Implementing Runnable Interface

public class ThreadExample2 implements Runnable {
   public void run() {
  /* Code which gets executed when
         thread gets executed. */
  	System.out.println("Creation of Thread By Implementing Runnabale Interface");
  }
   public static void main(String args[]) {
      ThreadExample2 Tt = new ThreadExample2();
      Thread t = new Thread(Tt);
     // t.start();
     t.run();
   }
}
