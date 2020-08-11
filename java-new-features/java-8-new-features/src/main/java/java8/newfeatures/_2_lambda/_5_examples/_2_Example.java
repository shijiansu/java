package java8.newfeatures._2_lambda._5_examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class _2_Example {
  public static void filter(List<String> names, Predicate condition) {
    names.stream()
        .filter((name) -> (condition.test(name)))
        .forEach(
            (name) -> {
              System.out.println(name + " ");
            });
  }

  public static void main(String[] args) {
    List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

    // TODO 这里有点奇怪, 识别不了String的类型, 需要toString()以下. 待查.
    System.out.println("Languages which starts with J :");
    filter(languages, (str) -> str.toString().startsWith("J"));

    System.out.println("Languages which ends with a ");
    filter(languages, (str) -> str.toString().endsWith("a"));

    System.out.println("Print all languages :");
    filter(languages, (str) -> true);

    System.out.println("Print no language : ");
    filter(languages, (str) -> false);

    System.out.println("Print language whose length greater than 4:");
    filter(languages, (str) -> str.toString().length() > 4);
  }
}
