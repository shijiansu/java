package java8.by.winterbe._01_modern_java_a_guide_to_java8._01_default_methods_for_interfaces;

public class FormulaTest {
  public static void main(String[] args) {
    formulate();
  }

  private static void formulate() {
    System.out.println("[formulate]");
    Formula formula =
        new Formula() {
          @Override
          public double calculate(int num) {
            return sqrt(num * 100);
          }
        };
    Number num2 = formula.sqrt(16); // 4.0
    System.out.println(num2);

    Number num = formula.calculate(100); // 100.0
    System.out.println(num);
  }
}
