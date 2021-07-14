package java8.by.winterbe._02_java8_stream_tutorial._06_advanced_operations_reduce;

import java.util.Arrays;
import java.util.List;

class Person {
  String name;
  int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name;
  }
}

public class StreamReduceTest {
  public static void main(String[] args) {
    reduce1();
    reduce2();
    reduce3();
    debugForReduce3();
    debugForReduce3InParallel();
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

  private static void reduce1() {
    System.out.println("[reduce1]");
    // Java8支持三种不同类型的reduce方法。
    // 第一种将流中的元素归约为流中的一个元素。
    // 让我们看看我们如何使用这个方法来计算出最老的人
    persons()
        .stream()
        .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
        .ifPresent(System.out::println); // Pamela
    // reduce方法接受BinaryOperator积累函数。
    // 它实际上是两个操作数类型相同的BiFunction。
    // BiFunction就像是Function，但是接受两个参数。
    // 示例中的函数比较两个人的年龄，来返回年龄较大的人。
  }

  private static void reduce2() {
    System.out.println("[reduce2]");
    // 第二个reduce方法接受一个初始值，和一个BinaryOperator累加器。
    // 这个方法可以用于从流中的其它Person对象中构造带有聚合后名称和年龄的新Person对象。
    Person result =
        persons()
            .stream()
            .reduce(
                new Person("", 0),
                (p1, p2) -> {
                  p1.age += p2.age;
                  p1.name += p2.name;
                  return p1;
                });
    System.out.format("name=%s; age=%s", result.name, result.age);
    // name=MaxPeterPamelaDavid; age=76
  }

  private static void reduce3() {
    System.out.println("[reduce3]");
    // reduce对象接受三个参数：初始值，BiFunction累加器和BinaryOperator类型的组合器函数。
    // 由于初始值的类型不一定为Person，我们可以使用这个归约函数来计算所有人的年龄总和。
    Integer ageSum =
        persons().stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
    System.out.println(ageSum); // 76
  }

  private static void debugForReduce3() {
    System.out.println("[debugForReduce3]");
    // 让我们通过添加一些调试输出来扩展上面的代码
    Integer ageSum =
        persons()
            .stream()
            .reduce(
                0,
                (sum, p) -> {
                  System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                  return sum += p.age;
                },
                (sum1, sum2) -> {
                  System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                  return sum1 + sum2;
                });
    System.out.println(ageSum); // 76
    // accumulator: sum=0; person=Max
    // accumulator: sum=18; person=Peter
    // accumulator: sum=41; person=Pamela
    // accumulator: sum=64; person=David
    // 76
    // 累加器函数做了所有工作
    // 好像组合器从来没有调用过？以并行方式执行相同的流会揭开这个秘密
  }

  private static void debugForReduce3InParallel() {
    System.out.println("[debug]");
    Integer ageSum =
        persons()
            .parallelStream()
            .reduce(
                0,
                (sum, p) -> {
                  System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                  return sum += p.age;
                },
                (sum1, sum2) -> {
                  System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                  return sum1 + sum2;
                });
    System.out.println(ageSum); // 76
    // accumulator: sum=0; person=Pamela
    // accumulator: sum=0; person=David
    // accumulator: sum=0; person=Max
    // accumulator: sum=0; person=Peter
    // combiner: sum1=18; sum2=23
    // combiner: sum1=23; sum2=12
    // combiner: sum1=41; sum2=35
    // 76
    // 这个流的并行执行行为会完全不同。现在实际上调用了组合器。
    // 由于累加器被并行调用，组合器需要用于计算部分累加值的总和。
  }
}
