package java8.by.winterbe._02_java8_stream_tutorial._02_processing_order;

import java.util.stream.Stream;

public class ProcessingOrderWhyOrderMattersTest {
  public static void main(String[] args) {
    case3();
    case4();
    case5();
    case6();
  }

  private static void case3() {
    System.out.println("[case3]");
    Stream.of("d2", "a2", "b1", "b3", "c")
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("A");
            })
        .forEach( // 只有filter成功以后才有forEach
            s -> System.out.println("forEach: " + s));
    // map: d2
    // filter: D2
    // map: a2
    // filter: A2
    // forEach: A2
    // map: b1
    // filter: B1
    // map: b3
    // filter: B3
    // map: c
    // filter: C
  }

  private static void case4() {
    System.out.println("[case4]");
    // 优化, 先filter
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("a");
            })
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .forEach(s -> System.out.println("forEach: " + s));
    // filter: d2
    // filter: a2
    // map: a2
    // forEach: A2
    // filter: b1
    // filter: b3
    // filter: c
  }

  private static void case5() {
    System.out.println("[case5]");
    // 排序是一类特殊的衔接操作.
    // 它是有状态的操作，因为你需要在处理中保存状态来对集合中的元素排序.
    Stream.of("d2", "a2", "b1", "b3", "c")
        .sorted(
            (s1, s2) -> {
              System.out.printf("sort: %s; %s\n", s1, s2);
              return s1.compareTo(s2);
            })
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("a");
            })
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .forEach(s -> System.out.println("forEach: " + s));
    // sort: a2; d2
    // sort: b1; a2
    // sort: b1; d2
    // sort: b1; a2
    // sort: b3; b1
    // sort: b3; d2
    // sort: c; b3
    // sort: c; d2
    // filter: a2
    // map: a2
    // forEach: A2
    // filter: b1
    // filter: b3
    // filter: c
    // filter: d2
  }

  private static void case6() {
    System.out.println("[case6]");
    // 首先，排序操作在整个输入集合上执行。也就是说，sorted以水平方式执行.
    // 所以这里sorted对输入集合中每个元素的多种组合调用了八次.
    // 优化, 先filter
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(
            s -> {
              System.out.println("filter: " + s);
              return s.startsWith("a");
            })
        .sorted(
            (s1, s2) -> {
              System.out.printf("sort: %s; %s\n", s1, s2);
              return s1.compareTo(s2);
            })
        .map(
            s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
        .forEach(s -> System.out.println("forEach: " + s));
    // filter: d2
    // filter: a2
    // filter: b1
    // filter: b3
    // filter: c
    // map: a2
    // forEach: A2
    // 这个例子中sorted永远不会调用，因为filter把输入集合减少至只有一个元素。
    // 所以对于更大的输入集合会极大提升性能。
  }
}
