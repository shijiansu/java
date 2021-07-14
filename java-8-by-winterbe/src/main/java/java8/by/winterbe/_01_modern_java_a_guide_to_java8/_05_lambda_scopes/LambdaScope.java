package java8.by.winterbe._01_modern_java_a_guide_to_java8._05_lambda_scopes;

import java8.by.winterbe._01_modern_java_a_guide_to_java8._03_functional_interfaces.Converter;

public class LambdaScope {
  // 默认方法无法在lambda表达式内部被访问
  static int outerStaticNum;
  int outerNum;

  void accessLocalVar() {
    // 可以访问本地final变量
    final int num = 1;
    Converter<Integer, String> converter = from -> String.valueOf(from + num);
    String result = converter.convert(2); // 3
    System.out.println(result);
  }

  void accessLocalVarNoFinal() {
    // 可以访问本地变量, final不是必须的, 只需要是effectively
    int num = 1;
    Converter<Integer, String> converter = from -> String.valueOf(from + num);
    String result = converter.convert(2); // 3
    System.out.println(result);
  }

  void accessLocalVarNotFinal() {
    // 可以访问本地变量, final不是必须的, 但是如果num有被修改, 则RuntimeError
    int num = 1;
    Converter<Integer, String> converter = from -> String.valueOf(from + num);
    String result = converter.convert(2);
    System.out.println(result);
    // num = 3; // 不能运行
  }

  void accessClassVar() {
    Converter<Integer, String> converter1 =
        from -> {
          outerNum = 1;
          return String.valueOf(from + outerNum);
        };
    String result = converter1.convert(2); // 3
    System.out.println(result);
  }

  void accessStaticVar() {
    Converter<Integer, String> converter1 =
        from -> {
          outerStaticNum = 1;
          return String.valueOf(from + outerStaticNum);
        };
    String result = converter1.convert(2); // 3
    System.out.println(result);
  }
}
