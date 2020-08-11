package java8.newfeatures._2_lambda._4_scope;

public class _1_Variable {
  @FunctionalInterface
  interface Converter<F, T> {
    T convert(F from);
  }

  public static void main(String[] args) {
    final int num = 1;
    Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
    stringConverter.convert(2); // 3

    // No final is also OK. But it cannot be modified.
    int num2 = 1;
    Converter<Integer, String> stringConverter2 = (from) -> String.valueOf(from + num2);
    stringConverter2.convert(2); // 3
  }
}
