package java8.by.winterbe._02_java8_stream_tutorial._01_how_streams_work;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
  public static void main(String[] args) {
    basic();
    create();
    create2();
    intStream();
    intStream2();
    convert2IntStream();
    convert2ObjectStream();
    convert2Int2ObjectStream();
    streamClosed();
    streamSupplier();
  }

  private static void basic() {
    System.out.println("[basic]");
    // 数据流操作要么是衔接操作，要么是终止操作。
    // 当一个函数不修改数据流的底层数据源，它就是无干扰的。
    // 当一个函数的操作的执行是确定性的，它就是无状态的。
    List<String> data = Arrays.asList("a1", "a2", "b1", "c2", "c1");
    data.stream()
        .filter(s -> s.startsWith("c"))
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);
    // C1
    // C2
  }

  private static void create() {
    System.out.println("[create]");
    Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1
  }

  private static void create2() {
    System.out.println("[create2]");
    // 无需建立数组
    Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println); // a1
  }

  private static void intStream() {
    System.out.println("[intStream]");
    // 除了普通的对象数据流，Java8还自带了特殊种类的流，
    // 用于处理基本数据类型int、long 和 double。
    // 你可能已经猜到了它是IntStream、LongStream 和 DoubleStream。
    IntStream.range(1, 4).forEach(System.out::println);
    // 1
    // 2
    // 3
  }

  private static void intStream2() {
    System.out.println("[intStream2]");
    // 基本的数据流使用特殊的lambda表达式，例如，IntFunction而不是Function，IntPredicate而不是Predicate
    Arrays.stream(new int[] {1, 2, 3})
        .map(n -> 2 * n + 1)
        .average()
        .ifPresent(System.out::println); // 5.0
  }

  private static void convert2IntStream() {
    System.out.println("[convert2IntStream]");
    // 有时需要将通常的对象数据流转换为基本数据流，或者相反。
    // 出于这种目的，对象数据流支持特殊的映射操作mapToInt()、mapToLong() 和 mapToDouble()
    Stream.of("a1", "a2", "a3")
        .map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .max()
        .ifPresent(System.out::println); // 3
  }

  private static void convert2ObjectStream() {
    System.out.println("[convert2IntStream]");
    // 基本数据流可以通过mapToObj()转换为对象数据流
    IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
    // a1
    // a2
    // a3
  }

  private static void convert2Int2ObjectStream() {
    System.out.println("[convert2Int2ObjectStream]");
    // 浮点数据流首先映射为整数数据流，之后映射为字符串的对象数据流
    Stream.of(1.0, 2.0, 3.0)
        .mapToInt(Double::intValue)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);
    // a1
    // a2
    // a3
  }

  private static void streamClosed() {
    System.out.println("[streamClosed]");
    // Java8的数据流不能被复用。一旦你调用了任何终止操作，数据流就关闭了
    Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
    boolean b = stream.anyMatch(s -> true); // ok
    System.out.println(b);
    try {
      stream.noneMatch(s -> true); // exception
    } catch (Exception e) {
      // stream has already been operated upon or closed
      System.out.println(e.getMessage());
    }
  }

  private static void streamSupplier() {
    System.out.println("[streamSupplier]");
    Supplier<Stream<String>> streamSupplier =
        () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
    // 每次对get()的调用都构造了一个新的数据流，我们将其保存来调用终止操作。
    boolean b = streamSupplier.get().anyMatch(s -> true); // ok
    System.out.println(b);

    boolean b2 = streamSupplier.get().noneMatch(s -> true); // ok
    System.out.println(b2);
  }
}
