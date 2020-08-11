package java8.newfeatures._2_lambda._1_old_and_new_ways;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1_OldeAndNewWays {
  public static void old(List<String> names) {
    Collections.sort(
        names,
        new Comparator<String>() {
          @Override
          public int compare(String a, String b) {
            return b.compareTo(a);
          }
        });
  }

  public static void new1(List<String> names) {
    // 这里匿名了Comparator, 应该是自动推断.
    Collections.sort(
        names,
        (String a, String b) -> {
          return b.compareTo(a);
        });
  }

  public static void new2(List<String> names) {
    // 省略了{}和return
    Collections.sort(names, (String a, String b) -> b.compareTo(a));
  }

  public static void new3(List<String> names) {
    // 省略了String
    Collections.sort(names, (a, b) -> b.compareTo(a));
  }

  public static void main(String[] args) {
    // 排列字符串的
    List<String> names;
    // old
    names = Arrays.asList("peter", "anna", "mike", "xenia");
    old(names);
    System.out.println(names);
    // new1
    names = Arrays.asList("peter", "anna", "mike", "xenia");
    new1(names);
    System.out.println(names);
    // new2
    names = Arrays.asList("peter", "anna", "mike", "xenia");
    new2(names);
    System.out.println(names);
    // new3
    names = Arrays.asList("peter", "anna", "mike", "xenia");
    new3(names);
    System.out.println(names);
  }
}
