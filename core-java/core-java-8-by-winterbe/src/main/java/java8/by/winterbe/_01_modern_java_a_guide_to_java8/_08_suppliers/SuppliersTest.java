package java8.by.winterbe._01_modern_java_a_guide_to_java8._08_suppliers;

import java.util.function.Supplier;

class Person {
    Person() {
    }
}

public class SuppliersTest {
    public static void main(String[] args) {
        supplier();
    }

    private static void supplier() {
        // Supplier接口产生一个给定类型的结果。
        // 与Function不同的是，Supplier没有输入参数。
        Supplier<Person> personSupplier = Person::new;
        Person person = personSupplier.get(); // equivalent: new Person
        System.out.println(person);
    }
}
