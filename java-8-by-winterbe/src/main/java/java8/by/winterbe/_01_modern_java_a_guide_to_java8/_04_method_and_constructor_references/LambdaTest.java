package java8.by.winterbe._01_modern_java_a_guide_to_java8._04_method_and_constructor_references;

import java8.by.winterbe._01_modern_java_a_guide_to_java8._03_functional_interfaces.Converter;

public class LambdaTest {
    public static void main(String[] args) {
        functional();
        byStatics();
        byObject();
        byConstructor();
    }

    private static void functional() {
        System.out.println("[functional]");
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted); // 123
    }

    private static void byStatics() {
        System.out.println("[byStatics]");
        // Java 8 允许你通过::关键字获取方法或者构造函数的的引用。
        // 静态方法引用
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    private static void byObject() {
        System.out.println("[byObject]");
        // 对象方法引用
        Example example = new Example();
        Converter<String, String> converter = example::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted); // "J"
    }

    private static void byConstructor() {
        System.out.println("[byConstructor]");
        // 构造函数引用
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person); // "J"
    }
}
