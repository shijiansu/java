package java8.by.winterbe._01_modern_java_a_guide_to_java8._09_consumers;

import java.util.function.Consumer;

class Person {
    String firstName;
    String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

public class ConsumersTest {
    public static void main(String[] args) {
        consumer();
    }

    private static void consumer() {
        System.out.println("[consumer]");
        // Consumer代表了在一个输入参数上需要进行的操作.
        Consumer<Person> greeter = p -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
