package java8.newfeatures._4_new_utils._1_function;

import static java.util.Comparator.*;

import java.util.Comparator;
import java8.newfeatures.Person;

public class _5_Comparator {
  public static void main(String[] args) {
    Comparator<Person> comparator = comparing(p -> p.firstName);
    Person p1 = new Person("John", "Doe");
    Person p2 = new Person("Alice", "Wonderland");
    comparator.compare(p1, p2); // > 0
    comparator.reversed().compare(p1, p2); // < 0
  }
}
