package java8.by.winterbe._01_modern_java_a_guide_to_java8._10_comparators;

import java.util.Comparator;

class Person {
    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}

public class ComparatorsTest {
    public static void main(String[] args) {
        compare();
    }

    private static void compare() {
        System.out.println("[compare]");
        // Java 8 为这个接口添加了不同的默认方法。
        // Comparator<Lambda2> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> comparator = Comparator.comparing(Person::getFirstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        int i = comparator.compare(p1, p2); // > 0
        System.out.println(i);

        int j = comparator.reversed().compare(p1, p2); // < 0
        System.out.println(j);
    }
}
