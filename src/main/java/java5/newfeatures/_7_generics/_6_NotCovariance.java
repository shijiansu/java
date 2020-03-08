package java5.newfeatures._7_generics;

import java.util.ArrayList;
import java.util.List;

public class _6_NotCovariance {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    // 数组是协变的
    Object oa[] = new Integer[] {};
    // 泛型不是，尽管泛型实参Object和Number具有父子类关系。但是List<Object>、List<Number>之类不存在父子类关系
    // List<Object> ol = new ArrayList<Number>(); //无法编译
    // 使用上限通配符，可以解决非协变特性导致的无法赋值问题：
    List<? extends Object> ol = new ArrayList<Number>();
  }
}
