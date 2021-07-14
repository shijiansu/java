package java8.by.winterbe._01_modern_java_a_guide_to_java8._03_functional_interfaces;

public class ConverterTest {
  public static void main(String[] args) {
    Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
    System.out.println(converted); // 123
  }
}
