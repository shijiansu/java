package java5.newfeatures._6_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class _2_Retention {
  @Retention(RetentionPolicy.SOURCE)
  // Annotation会被编译期丢弃
  @interface TODO1 {}

  @Retention(RetentionPolicy.CLASS)
  // Annotation保留在class文件中，但会被JVM忽略
  @interface TODO2 {}

  @Retention(RetentionPolicy.RUNTIME)
  // Annotation保留在class文件中且会被JVM读取
  @interface TODO3 {}
}
