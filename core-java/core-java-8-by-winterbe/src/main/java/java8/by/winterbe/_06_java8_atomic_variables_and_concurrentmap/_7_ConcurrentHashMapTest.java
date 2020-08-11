package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

// ConcurrentHashMap has been further enhanced with a couple of new methods
// to perform parallel operations upon the map
public class _7_ConcurrentHashMapTest {
  public static void main(String[] args) {
    getParallelism();
    forEach();
    search();
    searchValues();
    reduce();
  }

  private static ConcurrentHashMap<String, String> getConcurrentHashMap() {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    map.put("foo", "bar");
    map.put("han", "solo");
    map.put("r2", "d2");
    map.put("c3", "p0");
    return map;
  }

  // 这个值可以通过设置下列JVM参数来增减
  // -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
  private static void getParallelism() {
    System.out.println("[concurrentHashMapPool]");
    System.out.println(ForkJoinPool.getCommonPoolParallelism()); // 3
    // Java8引入了三种类型的并行操作：
    // forEach、search 和 reduce。这些操作中每个都以四种形式提供，
    // 接受以键、值、元素或键值对为参数的函数。
    // 所有这些方法的第一个参数是通用的parallelismThreshold。
    // 这一阈值表示操作并行执行时的最小集合大小。
  }

  private static void forEach() {
    System.out.println("[concurrentHashMapForEach]");
    ConcurrentHashMap<String, String> map = getConcurrentHashMap();
    map.forEach(
        1,
        (key, value) ->
            System.out.printf(
                "key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));
    // key: r2; value: d2; thread: main
    // key: foo; value: bar; thread: ForkJoinPool.commonPool-worker-1
    // key: han; value: solo; thread: ForkJoinPool.commonPool-worker-2
    // key: c3; value: p0; thread: main
  }

  private static void search() {
    System.out.println("[concurrentHashMapSearch]");
    ConcurrentHashMap<String, String> map = getConcurrentHashMap();
    // 要记住ConcurrentHashMap是无序的。搜索函数应该不依赖于映射实际的处理顺序。
    // 如果映射的多个元素都满足指定搜索函数，结果是非确定的。
    String result =
        map.search(
            1,
            (key, value) -> {
              System.out.println(Thread.currentThread().getName());
              if ("foo".equals(key)) {
                return value;
              }
              return null;
            });
    System.out.println("Result: " + result);
    // ForkJoinPool.commonPool-worker-2
    // main
    // ForkJoinPool.commonPool-worker-3
    // Result: bar
  }

  private static void searchValues() {
    System.out.println("[concurrentHashMapSearchValues]");
    ConcurrentHashMap<String, String> map = getConcurrentHashMap();
    // 下面是另一个例子，仅仅搜索映射中的值
    String result =
        map.searchValues(
            1,
            value -> {
              System.out.println(Thread.currentThread().getName());
              if (value.length() > 3) {
                return value;
              }
              return null;
            });
    System.out.println("Result: " + result);
    // ForkJoinPool.commonPool-worker-2
    // main
    // main
    // ForkJoinPool.commonPool-worker-1
    // Result: solo
  }

  private static void reduce() {
    System.out.println("[concurrentHashMapForEach]");
    ConcurrentHashMap<String, String> map = getConcurrentHashMap();
    // 第一个函数将每个键值对转换为任意类型的单一值。
    // 第二个函数将所有这些转换后的值组合为单一结果，并忽略所有可能的null值。
    String result =
        map.reduce(
            1,
            (key, value) -> {
              System.out.println("Transform: " + Thread.currentThread().getName());
              return key + "=" + value;
            },
            (s1, s2) -> {
              System.out.println("Reduce: " + Thread.currentThread().getName());
              return s1 + ", " + s2;
            });
    System.out.println("Result: " + result);
    // Transform: ForkJoinPool.commonPool-worker-2
    // Transform: main
    // Transform: ForkJoinPool.commonPool-worker-3
    // Reduce: ForkJoinPool.commonPool-worker-3
    // Transform: main
    // Reduce: main
    // Reduce: main
    // Result: r2=d2, c3=p0, han=solo, foo=bar
  }
}
