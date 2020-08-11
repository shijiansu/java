package java5.newfeatures._7_generics;

import java.util.List;

public class _4_Wildcard<T> {
  private T t;

  public _4_Wildcard(T t) {
    this.t = t;
  }

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public static void addNumbers(List<? super Integer> list) {
    // list的实参可以是Integer，或者Number，或者Object，但是必然能容纳int类型
    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }
  }

  public static void process(List<? extends Number> list) {
    // list的实参可以是Integer，或者Number，或者Double，但是都可以针对其调用Number的接口
    for (Number n : list) {
      n.intValue();
    }
  }

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    // 1.
    _4_Wildcard<?> value = new _4_Wildcard<Integer>(1);
    Object o = value.get(); // 可以通过编译，你不知道是什么类型，所以我们给你一个根类型
    // value.set( 1 ); //无法通过编译，不是我们不限制类型，而是你不知道是什么类型
    // 2.
    _4_Wildcard<? extends Number> valueExtend = new _4_Wildcard<Integer>(1);
    // 有了这个变量声明，我知道类型参数必然是Number的子类型：
    Number num = valueExtend.get();
    // 但是，具体是Integer，还是Double，我不知道，因此我无法提供参数类型的实例
    // valueExtend.set( 1 ); //无法编译
    // 3.
    _4_Wildcard<? super Number> valueSuper = new _4_Wildcard<Number>(1);
    // 有了这个变量声明，我知道类型参数必然是Number的超类型：
    valueSuper.set(new Integer(1)); // 那么，我当然可以提供Number的子类型给你
    // 但是，我却不知道类型参数的真实类型
    Object obj = valueSuper.get(); // 所以此变量提供的参数类型未知
  }
}
