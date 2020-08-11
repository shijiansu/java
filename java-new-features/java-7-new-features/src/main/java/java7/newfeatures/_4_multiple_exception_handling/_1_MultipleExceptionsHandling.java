package java7.newfeatures._4_multiple_exception_handling;

public class _1_MultipleExceptionsHandling {
  public void test() {
    try {
      Integer.parseInt("Hello");
    } catch (NumberFormatException | Error e) { // 使用'|'分割，多个类型，一个对象e
    }
  }
}
