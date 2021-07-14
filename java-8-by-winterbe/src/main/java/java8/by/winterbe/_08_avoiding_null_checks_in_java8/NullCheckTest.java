package java8.by.winterbe._08_avoiding_null_checks_in_java8;

import static java.lang.System.out;

import java.util.Optional;
import java.util.function.Supplier;

public class NullCheckTest {
  public static void main(String[] args) {
    oldNullCheck();
    newNullCheck();
    newNullCheckAlternative();
  }

  private static void oldNullCheck() {
    out.print("[oldNullCheck]");
    Outer outer = new Outer();
    if (outer != null && outer.nested != null && outer.nested.inner != null) {
      out.println(outer.nested.inner.foo);
    }
  }

  // Please keep in mind that both solutions are probably not as
  // performant as traditional null checks.
  private static void newNullCheck() {
    out.print("[newNullCheck]");
    Optional.of(new Outer())
        .map(Outer::getNested)
        .map(Nested::getInner)
        .map(Inner::getFoo)
        .ifPresent(System.out::println);
  }

  // Please keep in mind that both solutions are probably not as
  // performant as traditional null checks.
  private static void newNullCheckAlternative() {
    out.print("[newNullCheckAlternative]");
    Outer obj = new Outer();
    resolve(() -> obj.getNested().getInner().getFoo()).ifPresent(System.out::println);
  }

  private static <T> Optional<T> resolve(Supplier<T> resolver) {
    try {
      T result = resolver.get();
      return Optional.ofNullable(result);
    } catch (NullPointerException e) {
      return Optional.empty();
    }
  }
}
