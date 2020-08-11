package java8.by.winterbe._07_java8_api_strings_numbers_math_and_files;

import static java.lang.System.out;

public class _2_NumberAndMathTest {
  public static void main(String[] args) {
    oldOverflow();
    oldUnsignedInt();
    newUnsignedInt();
    newOverflow();
    newToInt();
  }

  private static void oldOverflow() {
    out.println("[oldOverflow]");
    // Java8添加了对无符号数的额外支持。Java中的数值总是有符号的，例如，让我们来观察Integer：
    // int可表示最多2 ** 32个数。Java中的数值默认为有符号的，所以最后一个二进制数字表示符号（0为正数，1为负数）。
    // 所以从十进制的0开始，最大的有符号正整数为2 ** 31 - 1。
    // 整数溢出
    out.println(Integer.MAX_VALUE); // 2147483647
    out.println(Integer.MAX_VALUE + 1); // -2147483648
  }

  private static void oldUnsignedInt() {
    out.println("[oldUnsignedInt]");
    long maxUnsignedInt = (1l << 32) - 1; // 4294967295 = 2147483647 + 2147483648
    String string = String.valueOf(maxUnsignedInt);
    try {
      Integer.parseInt(string, 10);
    } catch (NumberFormatException e) {
      System.err.println("could not parse signed int of: " + string);
    }
  }

  private static void newUnsignedInt() {
    out.println("[newUnsignedInt]");
    // Java8添加了解析无符号整数的支持
    long maxUnsignedInt = (1l << 32) - 1;
    String string = String.valueOf(maxUnsignedInt);
    int unsignedInt = Integer.parseUnsignedInt(string, 10);
    String string2 = Integer.toUnsignedString(unsignedInt, 10);

    out.println("maxUnsignedInt: " + maxUnsignedInt);
    out.println("string: " + string);
    out.println("unsignedInt: " + unsignedInt); // -2147483648
    out.println("string2: " + string2); // -2147483648
  }

  private static void newOverflow() {
    out.println("[newOverflow]");
    // Java8添加了严格数学运算的支持来解决这个问题。
    // Math扩展了一些方法，它们全部以exact结尾，例如addExact。
    // 当运算结果不能被数值类型装下时，这些方法通过抛出ArithmeticException异常来合理地处理溢出。
    try {
      Math.addExact(Integer.MAX_VALUE, 1);
    } catch (ArithmeticException e) {
      System.err.println(e.getMessage()); // integer overflow
    }
  }

  private static void newToInt() {
    out.println("[newToInt]");
    // 当尝试通过toIntExact将长整数转换为整数时，可能会抛出同样的异常
    try {
      Math.toIntExact(Long.MAX_VALUE);
    } catch (ArithmeticException e) {
      System.err.println(e.getMessage()); // integer overflow
    }
  }
}
