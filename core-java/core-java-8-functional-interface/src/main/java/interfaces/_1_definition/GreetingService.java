package interfaces._1_definition;

import static java.lang.Integer.max;

@FunctionalInterface
interface GreetingService {
  String message(String message);

  // allow default method
  default Integer maxNumber(Integer a, Integer b) {
    return max(a, b);
  }

  // allow default method
  default Integer sum(Integer a, Integer b) {
    return a + b;
  }

  // allow static method
  static String hello(String s) {
    return "hello " + s;
  }

  // allow override java.lang.Object public method
  @Override
  boolean equals(Object obj);
}
