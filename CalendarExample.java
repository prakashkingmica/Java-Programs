import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarExample {

  public static void main(String args[]) {
	  Date date = Calendar.getInstance().getTime();
	  Date d = new Date();
	  System.out.println("Current date and time is: " + date);
	  System.out.println("Current date and time is: " + d);
	  System.out.println();
  }
}