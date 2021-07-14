package java8.by.winterbe._02_java8_stream_tutorial._05_advanced_operations_flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Foo {
  String name;
  List<Bar> bars = new ArrayList<>();

  Foo(String name) {
    this.name = name;
  }
}

class Bar {
  String name;

  Bar(String name) {
    this.name = name;
  }
}

public class StreamFlatMapTest {
  public static void main(String[] args) {
    full();
    express();
  }

  private static void full() {
    System.out.println("[full]");
    // 希望将一个对象转换为多个或零个其他对象呢
    // flatMap将流中的每个元素，转换为其它对象的流。所以每个对象会被转换为零个、一个或多个其它对象，
    // 以流的形式返回。这些流的内容之后会放进flatMap所返回的流中。
    List<Foo> foos = new ArrayList<>();
    // create foos
    IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));
    // create bars
    foos.forEach(
        f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
    // 现在我们拥有了含有三个foo的列表，每个都含有三个bar。
    foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));
    // Bar1 <- Foo1
    // Bar2 <- Foo1
    // Bar3 <- Foo1
    // Bar1 <- Foo2
    // Bar2 <- Foo2
    // Bar3 <- Foo2
    // Bar1 <- Foo3
    // Bar2 <- Foo3
    // Bar3 <- Foo3
    // 像你看到的那样，我们成功地将含有三个foo对象中的流转换为含有九个bar对象的流。
  }

  private static void express() {
    System.out.println("[express]");
    // 考虑简化版
    IntStream.range(1, 4)
        .mapToObj(i -> new Foo("Foo" + i))
        .peek(
            f ->
                IntStream.range(1, 4)
                    .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                    .forEach(f.bars::add))
        .flatMap(f -> f.bars.stream())
        .forEach(b -> System.out.println(b.name));
  }
}
