package java8.by.winterbe._01_modern_java_a_guide_to_java8._15_annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// @Repeatable，Java 8 允许我们对同一类型使用多重注解
@Retention(RetentionPolicy.RUNTIME) // 若无这个,  则
@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}

// 老方法: 使用注解容器
@Hints({@Hint("hint1"), @Hint("hint2")})
class Person1 {}

// 新方法: 使用可重复注解
@Hint("hint1")
@Hint("hint2")
class Person2 {}

public class RepeatableTest {
    public static void main(String[] args) {
        oldAnnotation();
        newAnnotation();
    }

    private static void oldAnnotation(){
        System.out.println("[oldAnnotation]");
        Hint hint = Person1.class.getAnnotation(Hint.class);
        System.out.println(hint); // null

        Hints hints = Person1.class.getAnnotation(Hints.class);
        System.out.println(hints.value().length); // 2
    }

    private static void newAnnotation(){
        System.out.println("[newAnnotation]");
        Hint hint = Person2.class.getAnnotation(Hint.class);
        System.out.println(hint); // null

        // getAnnotationsByType与getAnnotation的区别在于:
        // getAnnotationsByType: 会检测注解对应的重复注解容器.
        // 若被注解元素为类, 当前类上找不到注解, 且该注解为可继承, 则去父类检测对应的注解.
        Hint[] hints = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println(hints.length); // 2

        // 尽管我们绝对不会在Person2类上声明@Hints注解,
        // 但是它的信息仍然可以通过getAnnotation(Hints.class)来读取.
        Hints hints2 = Person2.class.getAnnotation(Hints.class);
        System.out.println(hints2.value().length); // 2
    }
}
