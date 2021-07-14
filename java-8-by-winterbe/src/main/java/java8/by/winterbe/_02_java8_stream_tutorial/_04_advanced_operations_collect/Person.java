package java8.by.winterbe._02_java8_stream_tutorial._04_advanced_operations_collect;

public class Person {
  public String name;
  public int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name;
  }
}
