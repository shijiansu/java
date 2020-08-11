package java8.newfeatures._4_new_utils._1_function;

import java.util.Objects;
import java.util.function.Predicate;

public class _4_Preficate {
  public static void main(String[] args) {
    Predicate<String> predicate = (s) -> s.length() > 0;
    predicate.test("foo"); // true
    predicate.negate().test("foo"); // false
    Predicate<Boolean> nonNull = Objects::nonNull;
    Predicate<Boolean> isNull = Objects::isNull;
    Predicate<String> isEmpty = String::isEmpty;
    Predicate<String> isNotEmpty = isEmpty.negate();
    System.out.println(nonNull);
    System.out.println(isNull);
    System.out.println(isEmpty);
    System.out.println(isNotEmpty);
  }
}
