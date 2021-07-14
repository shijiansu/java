package java8.by.winterbe._01_modern_java_a_guide_to_java8._07_functions;

import java.util.function.Function;

public class FunctionsTest {
    public static void main(String[] args) {
        function();
    }

    private static void function() {
        System.out.println("[function]");
        // Function接口接收一个参数，并返回单一的结果。
        // 默认方法可以将多个函数串在一起 (compse, andThen)
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        String s = backToString.apply("123"); // "123"
        System.out.println(s);
    }
}
