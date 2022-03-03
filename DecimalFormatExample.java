import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalFormatExample
{
  public static void main(String args[])
  {
  double amount = 2192.015;
  DecimalFormat formatter = new DecimalFormat("#.##");
  String a = formatter.format(amount);
  System.out.println("The Decimal Value is:"+a);
  }
}