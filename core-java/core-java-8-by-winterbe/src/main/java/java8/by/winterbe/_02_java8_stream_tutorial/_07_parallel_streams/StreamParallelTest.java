package java8.by.winterbe._02_java8_stream_tutorial._07_parallel_streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java8.by.winterbe._02_java8_stream_tutorial._04_advanced_operations_collect.Person;

public class StreamParallelTest {
  public static void main(String[] args) {
    pool();
    filter();
    sort();
    reduce();
  }

  private static void pool() {
    System.out.println("[pool]");
    // 流可以并行执行，在大量输入元素上可以提升运行时的性能。
    // 并行流使用公共的ForkJoinPool，由ForkJoinPool.commonPool()方法提供。
    // 底层线程池的大小最大为五个线程 - 取决于CPU的物理核数。
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    System.out.println(commonPool.getParallelism()); // 7
    // 公共池默认初始化为7。
    // 这个值可以通过设置下列JVM参数来增减
    // -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
  }

  private static void filter() {
    System.out.println("[filter]");
    // 集合支持parallelStream()方法来创建元素的并行流。
    // 或者你可以在已存在的数据流上调用衔接方法parallel()，将串行流转换为并行流。
    // 下面的例子向sout打印了当前线程的信息
    Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .parallelStream()
        .filter(
            s -> {
              System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
              return true;
            })
        .map(
            s -> {
              System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
              return s.toUpperCase();
            })
        .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    // filter: b1 [main]
    // filter: c2 [ForkJoinPool.commonPool-worker-4]
    // filter: a2 [ForkJoinPool.commonPool-worker-1]
    // map: a2 [ForkJoinPool.commonPool-worker-1]
    // filter: a1 [ForkJoinPool.commonPool-worker-3]
    // filter: c1 [ForkJoinPool.commonPool-worker-2]
    // map: c1 [ForkJoinPool.commonPool-worker-2]
    // map: a1 [ForkJoinPool.commonPool-worker-3]
    // forEach: A2 [ForkJoinPool.commonPool-worker-1]
    // map: c2 [ForkJoinPool.commonPool-worker-4]
    // map: b1 [main]
    // forEach: C2 [ForkJoinPool.commonPool-worker-4]
    // forEach: A1 [ForkJoinPool.commonPool-worker-3]
    // forEach: C1 [ForkJoinPool.commonPool-worker-2]
    // forEach: B1 [main]
  }

  private static void sort() {
    System.out.println("[sort]");
    Arrays.asList("a1", "a2", "b1", "c2", "c1")
        .parallelStream()
        .filter(
            s -> {
              System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
              return true;
            })
        .map(
            s -> {
              System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
              return s.toUpperCase();
            })
        .sorted(
            (s1, s2) -> {
              System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
              return s1.compareTo(s2);
            })
        .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    // filter: c2 [ForkJoinPool.commonPool-worker-3]
    // filter: c1 [ForkJoinPool.commonPool-worker-2]
    // map: c1 [ForkJoinPool.commonPool-worker-2]
    // filter: a2 [ForkJoinPool.commonPool-worker-1]
    // map: a2 [ForkJoinPool.commonPool-worker-1]
    // filter: b1 [main]
    // map: b1 [main]
    // filter: a1 [ForkJoinPool.commonPool-worker-2]
    // map: a1 [ForkJoinPool.commonPool-worker-2]
    // map: c2 [ForkJoinPool.commonPool-worker-3]
    // sort: A2 <> A1 [main]
    // sort: B1 <> A2 [main]
    // sort: C2 <> B1 [main]
    // sort: C1 <> C2 [main]
    // sort: C1 <> B1 [main]
    // sort: C1 <> C2 [main]
    // forEach: A1 [ForkJoinPool.commonPool-worker-1]
    // forEach: C2 [ForkJoinPool.commonPool-worker-3]
    // forEach: B1 [main]
    // forEach: A2 [ForkJoinPool.commonPool-worker-2]
    // forEach: C1 [ForkJoinPool.commonPool-worker-1]

    // sort看起来只在主线程上串行执行。
    // 实际上，并行流上的sort在背后使用了Java8中新的方法Arrays.parallelSort()。
    // 如JavaDoc所说，这个方法会参照数据长度来决定以串行或并行来执行。
    // 如果指定数据的长度小于最小粒度，它使用相应的Arrays.sort方法来排序。
  }

  private static void reduce() {
    System.out.println("[parallel4]");
    List<Person> persons =
        Arrays.asList(
            new Person("Max", 18),
            new Person("Peter", 23),
            new Person("Pamela", 23),
            new Person("David", 12));

    persons
        .parallelStream()
        .reduce(
            0,
            (sum, p) -> {
              System.out.format(
                  "accumulator: sum=%s; person=%s [%s]\n",
                  sum, p, Thread.currentThread().getName());
              return sum += p.age;
            },
            (sum1, sum2) -> {
              System.out.format(
                  "combiner: sum1=%s; sum2=%s [%s]\n",
                  sum1, sum2, Thread.currentThread().getName());
              return sum1 + sum2;
            });
    // 控制台的输出表明，累加器和组合器都在所有可用的线程上并行执行
    // accumulator: sum=0; person=Max [ForkJoinPool.commonPool-worker-3]
    // accumulator: sum=0; person=David [ForkJoinPool.commonPool-worker-2]
    // accumulator: sum=0; person=Peter [ForkJoinPool.commonPool-worker-1]
    // accumulator: sum=0; person=Pamela [main]
    // combiner: sum1=18; sum2=23 [ForkJoinPool.commonPool-worker-1]
    // combiner: sum1=23; sum2=12 [main]
    // combiner: sum1=41; sum2=35 [main]

    // 总之，并行流对拥有大量输入元素的数据流具有极大的性能提升。
    // 但是要记住一些并行流的操作，例如reduce和collect需要额外的计算（组合操作），
    // 这在串行执行时并不需要。
    // 此外我们已经了解，所有并行流操作都共享相同的JVM相关的公共ForkJoinPool。
    // 所以你可能需要避免实现又慢又卡的流式操作，
    // 因为它可能会拖慢你应用中严重依赖并行流的其它部分。
  }
}
