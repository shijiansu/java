package java8.newfeatures._2_lambda._5_examples;

public class _4_Example {
  static class List<E> {
    static <Z> List<Z> nil() {
      return null;
    }

    static <Z> List<Z> cons(Z head, List<Z> tail) {
      return null;
    }

    E head() {
      return null;
    }
  }

  public static void main(String[] args) {
    // 通过方法赋值的目标参数来自动推断泛型的类型
    List<String> l = List.nil();
    // 而不是显示的指定类型
    // List<String> l = List.<String>nil();
    // 通过前面方法参数类型推断泛型的类型
    List.cons(42, List.nil());
    // 而不是显示的指定类型
    // List.cons(42, List.<Integer>nil());
  }
}
