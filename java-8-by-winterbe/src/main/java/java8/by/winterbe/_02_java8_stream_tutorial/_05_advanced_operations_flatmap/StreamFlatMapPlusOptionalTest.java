package java8.by.winterbe._02_java8_stream_tutorial._05_advanced_operations_flatmap;

import java.util.Optional;

class Outer {
  Nested nested;

  public Outer() {}

  public Outer(Nested nested) {
    this.nested = nested;
  }
}

class Nested {
  Inner inner;

  public Nested(Inner inner) {
    this.inner = inner;
  }
}

class Inner {
  String foo;

  public Inner(String foo) {
    this.foo = foo;
  }
}

public class StreamFlatMapPlusOptionalTest {
  public static void main(String[] args) {
    oldNotNull();
    oldNull();
    newNotNull();
    newNull();
  }

  private static void oldNotNull() {
    System.out.println("[oldNotNull]");
    // 考虑简化版
    // 需要添加多个null检查来避免潜在的NullPointerException
    Outer outer = new Outer(new Nested(new Inner("Foo")));
    if (outer != null && outer.nested != null && outer.nested.inner != null) {
      System.out.println(outer.nested.inner.foo);
    }
  }

  private static void oldNull() {
    System.out.println("[oldNull]");
    // 考虑简化版
    // 需要添加多个null检查来避免潜在的NullPointerException
    Outer outer = new Outer();
    if (outer != null && outer.nested != null && outer.nested.inner != null) {
      System.out.println(outer.nested.inner.foo);
    }
  }

  private static void newNotNull() {
    System.out.println("[newNotNull]");
    // 相同的行为
    Optional.of(new Outer(new Nested(new Inner("Foo"))))
        .flatMap(o -> Optional.ofNullable(o.nested))
        .flatMap(n -> Optional.ofNullable(n.inner))
        .flatMap(i -> Optional.ofNullable(i.foo))
        .ifPresent(System.out::println);
  }

  private static void newNull() {
    System.out.println("[newNull]");
    // 相同的行为
    Optional.of(new Outer())
        .flatMap(o -> Optional.ofNullable(o.nested))
        .flatMap(n -> Optional.ofNullable(n.inner))
        .flatMap(i -> Optional.ofNullable(i.foo))
        .ifPresent(System.out::println);
  }
}
