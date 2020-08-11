package java8.newfeatures._2_lambda._3_double_colon;

import java8.newfeatures.Person;

public class _2_Example {
  interface PersonFactory<P extends Person> {
    // 只有一个方法的时候, 自动变为functional interface
    P create(String firstName, String lastName);
    // P create(String firstName, String lastName, String middleName);
  }

  public static void main(String[] args) {
    // 自动关联到create
    PersonFactory<Person> personFactory = Person::new;
    Person person = personFactory.create("Peter", "Parker");
    System.out.println(person);
  }
}
