package java8.newfeatures._2_lambda._2_functional_interface;

public class _1_FunctionalInterface {
  @FunctionalInterface
  interface Converter<F, T> {
    T convert(F from);
  }

  public static void main(String[] args) {
    // 这里有趣, Converter作为一个借口, 不是类, 在这里可以被"实现化"
    Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
    // 之后就可以作为一个"函数"直接使用了
    Integer converted = converter.convert("123");
    System.out.println(converted); // 123
  }
}
