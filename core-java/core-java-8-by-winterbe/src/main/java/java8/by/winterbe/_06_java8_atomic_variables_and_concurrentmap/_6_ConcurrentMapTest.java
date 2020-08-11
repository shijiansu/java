package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ConcurrentHashMap;

public class _6_ConcurrentMapTest {
  public static void main(String[] args) {
    concurrentHashMap();
  }

  private static ConcurrentHashMap<String, String> getConcurrentHashMap() {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    map.put("foo", "bar");
    map.put("han", "solo");
    map.put("r2", "d2");
    map.put("c3", "p0");
    return map;
  }

  private static void concurrentHashMap() {
    System.out.println("[concurrentHashMap]");
    ConcurrentHashMap<String, String> map = getConcurrentHashMap();
    map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

    String value = map.putIfAbsent("c3", "p1");
    System.out.println(value); // p0

    value = map.getOrDefault("hi", "there");
    System.out.println(value); // there

    map.replaceAll((key, v) -> "r2".equals(key) ? "d3" : v);
    System.out.println(map.get("r2")); // d3

    map.compute("foo", (key, v) -> v + v);
    System.out.println(map.get("foo")); // barbar

    map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
    System.out.println(map.get("foo")); // boo was foo
  }
}
