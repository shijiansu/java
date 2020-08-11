package java8.newfeatures._4_new_utils._1_function;

import java.util.function.Function;

public class _1_Function {
  // Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
  public static void main(String[] args) {
    // 定义函数
    Function<String, Integer> toInteger = Integer::valueOf;
    Function<String, String> backToString = toInteger.andThen(String::valueOf);
    backToString.apply("123"); // "123"
  }
}
