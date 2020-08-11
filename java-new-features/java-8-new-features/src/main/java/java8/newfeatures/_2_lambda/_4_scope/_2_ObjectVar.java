package java8.newfeatures._2_lambda._4_scope;

// Lambda表达式中是无法访问到默认方法的.
public class _2_ObjectVar {
  @FunctionalInterface
  interface Converter<F, T> {
    T convert(F from);
  }

  static class Lambda4 {
    // 可以访问和修改
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
      @SuppressWarnings("unused")
      Converter<Integer, String> stringConverter1 =
          (from) -> {
            outerNum = 23;
            return String.valueOf(from);
          };
      @SuppressWarnings("unused")
      Converter<Integer, String> stringConverter2 =
          (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
          };
    }
  }
}
