package java5.newfeatures._7_generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;

// 它的泛型父类的类型信息String不会被擦除
public class _5_TypeErasure extends ArrayList<String> // 和C++的模板特化有些类似
{
  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
    // 可以使用下面的代码获得泛型父类的真实参数类型
    ParameterizedType type = (ParameterizedType) new _5_TypeErasure().getClass().getGenericSuperclass();
    System.out.println(Arrays.asList(type.getActualTypeArguments()));
    assert (type.getActualTypeArguments()[0] == String.class);
  }
}
