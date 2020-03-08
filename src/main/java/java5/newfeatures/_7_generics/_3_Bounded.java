package java5.newfeatures._7_generics;

import java.io.Serializable;
import org.w3c.dom.Entity;

public class _3_Bounded {
  // Java泛型支持限制可作为泛型实参的类型的范围。例如上面的plus方法，可能仅仅支持数字类型。要声明受限泛型形参，需要使用extends关键字：
  public static <RET, ARG0 extends Number, ARG1 extends Number> RET plus(ARG0 arg0, ARG1 arg1) {
    return (RET) null;
  }

  // 使用受限形参，方法体可以对形参的类型进行假设，这样就可以执行有意义的方法调用了：
  public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
      // 调用比较方法，因为T必须是Comparable的子类型
      if (e.compareTo(elem) > 0) ++count;
    return count;
  }

  // 多个接口用 & 符号分隔
  public static <T extends Entity & Serializable> void save(T t) {}
}
