package java8.newfeatures._2_lambda._3_double_colon;

public class _1_Example {
  @FunctionalInterface
  interface Converter<F, T> {
    T convert(F from);
  }

  public static void main(String[] args) {
    Converter<String, Integer> converter = Integer::valueOf;
    Integer converted = converter.convert("123");
    System.out.println(converted); // 123
    // 通过对象
    String something = "Java";
    Converter<Integer, String> converter2 = something::substring;
    String converted2 = converter2.convert(1);
    System.out.println(converted2); // "ava"
  }
}
