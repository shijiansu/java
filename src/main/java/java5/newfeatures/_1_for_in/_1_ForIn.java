package java5.newfeatures._1_for_in;

import java.util.ArrayList;

public class _1_ForIn {
  public static void main(String[] args) {
    for (char c : new char[] {'H', 'E', 'L', 'L', 'O'}) {
      System.out.println(c);
    }
    for (String str :
        new ArrayList<String>() {
          {
            add("W");
            add("O");
            add("R");
            add("L");
            add("D");
          }
        }) {
      System.out.println(str);
    }
  }
}
