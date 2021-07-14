package java8.by.winterbe._01_modern_java_a_guide_to_java8._06_predicates;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicatesTest {
    public static void main(String[] args) {
        predicate();
        wrap();
    }

    private static void predicate() {
        // Predicate是一个布尔类型的函数，该函数只有一个输入参数。
        // Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean a = predicate.test("foo"); // true
        boolean b = predicate.negate().test("foo"); // false

        System.out.println(a);
        System.out.println(b);
    }

    private static void wrap() {
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
