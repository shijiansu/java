package java8.newfeatures._3_multiple_annotation;

import java.lang.annotation.Repeatable;

public class Test {

  @interface Hints {
    Hint[] value();
  }

  @Repeatable(Hints.class)
  @interface Hint {
    String value();
  }

  // 老方法
  @Hints({@Hint("hint1"), @Hint("hint2")})
  class Person {}

  // 新方法
  @Hint("hint1")
  @Hint("hint2")
  class Person2 {}

  public static void main(String[] args) {
    // Java编译器会隐性的帮你定义好@Hints注解，了解这一点有助于你用反射来获取这些信息：
    Hint hint = Person.class.getAnnotation(Hint.class);
    System.out.println(hint); // null
    Hints hints1 = Person.class.getAnnotation(Hints.class);
    System.out.println(hints1.value().length); // 2
    Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
    System.out.println(hints2.length); // 2
  }
}
