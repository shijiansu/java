package java8.by.winterbe._01_modern_java_a_guide_to_java8._01_default_methods_for_interfaces;

public interface Formula {
  double calculate(int num);

  // 为接口声明添加非抽象的方法实现
  default double sqrt(int num) {
    return Math.sqrt(num);
  }
}
