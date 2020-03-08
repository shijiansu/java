package java5.newfeatures._7_generics;

public class _2_GenericMethod {
  // 泛型方法，泛型形参列表必须在返回值之前声明：
  public static <RET, ARG0, ARG1> RET plus(ARG0 arg0, ARG1 arg1) {
    return (RET) null;
  }

  Integer result = _2_GenericMethod.<Integer, Double, Double>plus(1.1, 1.2);
}
