package sneakythrows._1_pivovarit;

import java.util.function.Function;

@FunctionalInterface
// https://github.com/pivovarit/articles/tree/master/java-sneaky-throws-lambda
public interface SimpleThrowingFunction<T, R> { // T -> Type, R -> Return

  // 这里代表了函数签名
  R apply(T t) throws Exception;

  // 使再抛出的异常T为原函数签名的异常
  // Which simply means that every T in "<T extends Throwable>"
  // is generously inferred to be a RuntimeException.
  @SuppressWarnings("unchecked")
  static <E extends Exception, R> R simpleSneakyThrow(Exception t) throws E {
    throw (E) t; // 不知道为什么, 使用(E)以后就不需要trycatch
  }

  // 包装后的方法
  static <T, R> Function<T, R> simpleUnchecked(SimpleThrowingFunction<T, R> f) {
    return t -> {
      try {
        return f.apply(t);
      } catch (Exception e) {
        return simpleSneakyThrow(e);
      }
    };
  }
}
