package java8.by.winterbe._01_modern_java_a_guide_to_java8._04_method_and_constructor_references;

public class Person {
  String firstName;
  String lastName;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
