package java8.by.winterbe._02_java8_stream_tutorial._02_processing_order;

import java.util.stream.Stream;

public class ProcessingOrderTest {
  public static void main(String[] args) {
    case1();
    case2();
  }

  private static void case1() {
    System.out.println("[case1]");
    // 衔接操作的一个重要特性就是延迟性
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(
            s -> {
              // 不被执行, 这是因为衔接操作只在终止操作调用时被执行
              System.out.println("filter: " + s);
              return true;
            })
        .forEach( // 触发执行
            s -> System.out.println("forEach: " + s));
    // filter: d2
    // forEach: d2
    // filter: a2
    // forEach: a2
    // filter: b1
    // forEach: b1
    // filter: b3
    // forEach: b3
    // filter: c
    // forEach: c
    // 第一个字符串"d2"首先经过filter然后是forEach, 执行完后才开始处理第二个字符串"a2".
  }

  private static void case2() {
    System.out.println("[case2]");
    boolean b =
        Stream.of("d2", "a2", "b1", "b3", "c")
            .map(
                s -> {
                  System.out.println("map: " + s);
                  return s.toUpperCase();
                })
            .anyMatch(
                s -> {
                  System.out.println("anyMatch: " + s);
                  return s.startsWith("A"); // 遇到A开头返回true就终止
                });
    System.out.println(b);
    // map: d2
    // anyMatch: D2
    // map: a2
    // anyMatch: A2
  }
}
