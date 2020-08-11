package java8.newfeatures._2_lambda._5_examples;

import java.util.Arrays;
import java.util.List;

public class _1_Example {
  public static void testFunction() {
    // Before Java 8:
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println("Before Java8 ");
              }
            })
        .start();

    // Java 8 way:
    new Thread(() -> System.out.println("In Java8!")).start();
  }

  public static void testLoop() {
    // Prior Java 8 :
    List<String> features =
        Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    for (String feature : features) {
      System.out.println(feature);
    }

    // In Java 8:
    List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    features2.forEach(n -> System.out.println(n));

    // Even better use Method reference feature of Java 8
    // method reference is denoted by :: (double colon) operator
    // looks similar to score resolution operator of C++
    features2.forEach(System.out::println);
  }

  public static void main(String[] args) {
    _1_Example.testFunction();

    System.out.println();

    _1_Example.testLoop();
  }
}
