package java8.newfeatures._2_lambda._5_examples;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class _4_ExampleCache {
  static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

  static int fibonacci(int i) {
    if (i == 0) {
      return i;
    }

    if (i == 1) {
      return 1;
    }

    return cache.computeIfAbsent(
        i,
        (key) -> {
          // 缺失的时候被调用这个函数, 进行运算后返回到Map里面
          System.out.println("Slow calculation of " + key);
          return fibonacci(i - 2) + fibonacci(i - 1);
        });
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println("f(" + i + ") = " + fibonacci(i));
    }
  }
}
