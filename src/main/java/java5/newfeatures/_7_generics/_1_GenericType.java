package java5.newfeatures._7_generics;

import java.util.List;

// 示例：
public class _1_GenericType<I> {
  class ClassName<T1> {
    // T1...Tn是将ClassName参数化的类型形参（type parameter），或者叫类型变量（type
    // variables），可以有1-N个
  }

  private I item;

  void put(I i) {
    item = i;
  }

  I get() {
    return item;
  }

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    _1_GenericType<Number> cn = new _1_GenericType<Number>();
    // Java 7引入了钻石操作符，可以根据cn的变量类型推倒构造器的type argument：
    // Container<Number> cn = new Container<>();
    _1_GenericType<List<String>> cn2 = new _1_GenericType<List<String>>();
  }
}
