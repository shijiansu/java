package java8.newfeatures._4_new_utils._4_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class _1_Example {
  public static void testFilter(List<String> stringCollection) {
    System.out.println("Filter过滤");
    // forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
    stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);
    // "aaa2", "aaa1"
  }

  public static void testSort(List<String> stringCollection) {
    System.out.println("Sort排序");
    // 排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
    stringCollection.stream()
        .sorted()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);
    // "aaa1", "aaa2"
  }

  public static void testMap(List<String> stringCollection) {
    // Map映射
    System.out.println("Map映射");
    stringCollection.stream()
        .map(String::toUpperCase)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);
    // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
  }

  public static void testMatch(List<String> stringCollection) {
    System.out.println("Match匹配");
    // Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。
    boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
    System.out.println(anyStartsWithA); // true
    boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
    System.out.println(allStartsWithA); // false
    boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
    System.out.println(noneStartsWithZ); // true
  }

  public static void testCount(List<String> stringCollection) {
    System.out.println("Count计数");
    long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
    System.out.println(startsWithB); // 3
  }

  public static void testReduce(List<String> stringCollection) {
    System.out.println("Reduce规约");
    Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
    reduced.ifPresent(System.out::println); // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
  }

  public static void main(String[] args) {
    List<String> stringCollection = new ArrayList<>();
    stringCollection.add("ddd2");
    stringCollection.add("aaa2");
    stringCollection.add("bbb1");
    stringCollection.add("aaa1");
    stringCollection.add("bbb3");
    stringCollection.add("ccc");
    stringCollection.add("bbb2");
    stringCollection.add("ddd1");

    _1_Example.testFilter(stringCollection);
    _1_Example.testSort(stringCollection);

    // 需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的：
    System.out.println(stringCollection);

    _1_Example.testMap(stringCollection);
    _1_Example.testMatch(stringCollection);
    _1_Example.testReduce(stringCollection);
  }
}
