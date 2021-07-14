package java8.by.winterbe._02_java8_stream_tutorial._04_advanced_operations_collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamCollectorTest {
  public static void main(String[] args) {
    collect();
    group();
    average();
    summerize();
    join();
    customized();
  }

  private static List<Person> persons() {
    List<Person> persons =
        Arrays.asList(
            new Person("Max", 18),
            new Person("Peter", 23),
            new Person("Pamela", 23),
            new Person("David", 12));
    return persons;
  }

  private static void collect() {
    System.out.println("[collect]");
    // collect是非常有用的终止操作，将流中的元素存放在不同类型的结果中，例如List、Set或者Map。
    // 它由四个不同的操作组成：
    // 供应器（supplier）、累加器（accumulator）、组合器（combiner）和终止器（finisher）。
    List<Person> filtered =
        persons()
            .stream()
            .filter(p -> p.name.startsWith("P"))
            .collect(Collectors.toList()); // Collectors.toSet()
    System.out.println(filtered); // [Peter, Pamela]
  }

  private static void group() {
    System.out.println("[group]");
    // 下面的例子按照年龄对所有人进行分组
    Map<Integer, List<Person>> personsByAge =
        persons().stream().collect(Collectors.groupingBy(p -> p.age));
    personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    // age 18: [Max]
    // age 23: [Peter, Pamela]
    // age 12: [David]
  }

  private static void average() {
    System.out.println("[average]");
    // 收集器十分灵活。你也可以在流的元素上执行聚合
    Double averageAge = persons().stream().collect(Collectors.averagingInt(p -> p.age));
    System.out.println(averageAge); // 19.0
  }

  private static void summerize() {
    System.out.println("[summerize]");
    // 我们可以简单计算最小年龄、最大年龄、算术平均年龄、总和和数量。
    IntSummaryStatistics ageSummary =
        persons().stream().collect(Collectors.summarizingInt(p -> p.age));
    System.out.println(ageSummary);
    // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
  }

  private static void join() {
    System.out.println("[join]");
    // 将所有人连接为一个字符串。连接收集器接受分隔符，以及可选的前缀和后缀。
    String phrase =
        persons()
            .stream()
            .filter(p -> p.age >= 18)
            .map(p -> p.name)
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
    System.out.println(phrase);
    // In Germany Max and Peter and Pamela are of legal age.
  }

  private static void customized() {
    System.out.println("[customized]");
    // 构建自己的特殊收集器
    Collector<Person, StringJoiner, String> personNames =
        Collector.of(
            () -> new StringJoiner(" | "), // supplier
            (j, p) -> j.add(p.name.toUpperCase()), // accumulator
            (j1, j2) -> j1.merge(j2), // combiner
            StringJoiner::toString); // finisher
    String names = persons().stream().collect(personNames);
    System.out.println(names); // MAX | PETER | PAMELA | DAVID
  }
}
