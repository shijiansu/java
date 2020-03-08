package java5.newfeatures._8_new_utils._1_formatter;

import java.util.Formatter;

public class _1_Formatter {
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Formatter formatter = new Formatter();
    System.out.println(formatter.format("Remaining account balance: $%.2f", 100.2));
  }
}
