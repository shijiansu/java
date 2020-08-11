package java5.newfeatures._6_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class _1_Annotation {

  // 某些注解可以用来修饰注解类型本身
  @Retention(RetentionPolicy.RUNTIME)
  // 提示该注解需要在运行期保留
  @Target(ElementType.METHOD)
  // 提示该注解只能作用于方法上
  @interface AutoExtAjaxResult {
    // 注解中可以声明多个“方法”，用来指示注解实例的属性名
    String value(); // value是一个特殊属性，如果注解只有这一个属性，在实例化注解时，可以不指定属性名

    Class<?> type() default _1_Annotation.class; // 注解属性可以提供默认值
  }

  // 要使用（实例化）注解，只需要在目标类/方法/字段的声明前面添加@注解名，并提供必要的参数，所有没有提供默认值的属性都需要提供值：
  @AutoExtAjaxResult("Avalue")
  public String userInfo() {
    return null;
  }

  public static void main(String[] args) {
    try {
      String annotationValue =
          _1_Annotation.class.getMethod("userInfo").getAnnotation(AutoExtAjaxResult.class).value();
      System.out.println(annotationValue);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
