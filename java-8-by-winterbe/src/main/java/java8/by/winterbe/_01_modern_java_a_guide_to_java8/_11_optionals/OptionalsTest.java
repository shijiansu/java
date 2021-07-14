package java8.by.winterbe._01_modern_java_a_guide_to_java8._11_optionals;

import java.util.Optional;

public class OptionalsTest {
    private static void optional(){
        System.out.println("[optional]");
        // Optional不是一个函数式接口，而是一个精巧的工具接口，用来防止NullPointerException产生。
        // Optional是一个简单的值容器，这个值可以是null，也可以是non-null。
        // 考虑到一个方法可能会返回一个non-null的值，也可能返回一个空值。
        // 为了不直接返回null，我们在Java 8中就返回一个Optional。
        Optional<String> optional = Optional.of("bam");

        boolean present = optional.isPresent();// true
        System.out.println(present);

        String s = optional.get();// "bam"
        System.out.println(s);

        String fallback = optional.orElse("fallback");// "bam"
        System.out.println(fallback);

        optional.ifPresent(ss -> System.out.println(ss.charAt(0))); // "b"
    }

    public static void main(String[] args) {
        optional();
    }
}
