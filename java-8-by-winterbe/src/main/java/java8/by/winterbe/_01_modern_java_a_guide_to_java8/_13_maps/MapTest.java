package java8.by.winterbe._01_modern_java_a_guide_to_java8._13_maps;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
  public static void main(String[] args) {
    forEach();
    computeIfPresent();
    computeIfAbsent();
    remove();
    getDefault();
    merge();
  }

  private static Map<Integer, String> getMap() {
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }
    return map;
  }

  private static void forEach() {
    System.out.println("[forEach]");
    Map<Integer, String> map = getMap();
    map.forEach((id, val) -> System.out.println(id + " : " + val));
  }

  private static void computeIfPresent() {
    System.out.println("[computeIfPresent]");
    // 计算map的编码. 类似结合逻辑和操作
    Map<Integer, String> map = getMap();
    map.computeIfPresent(3, (num, val) -> val + num);
    String value = map.get(3); // val33
    System.out.println(value);

    map.computeIfPresent(9, (num, val) -> null);
    boolean result = map.containsKey(9); // false
    System.out.println(result);
  }

  private static void computeIfAbsent() {
    System.out.println("[computeIfAbsent]");
    Map<Integer, String> map = getMap();

    map.computeIfAbsent(99, num -> "val" + num);
    boolean result = map.containsKey(99); // true
    String value = map.get(99); // val99
    System.out.println(result);
    System.out.println(value);

    map.computeIfAbsent(3, num -> "bam");
    value = map.get(3); // val3
    System.out.println(value);
  }

  private static void remove() {
    System.out.println("[remove]");
    Map<Integer, String> map = getMap();

    // 把一个实例从对应的key中移除. 仅当value匹配时候才remove
    map.remove(3, "val");
    String value = map.get(3); // val3
    System.out.println(value);

    map.remove(3, "val3");
    value = map.get(3); // null
    System.out.println(value);
  }

  private static void getDefault() {
    System.out.println("[getDefault]");
    Map<Integer, String> map = getMap();

    String value = map.getOrDefault(42, "not found"); // not found
    System.out.println(value);
  }

  private static void merge() {
    System.out.println("[merge]");
    Map<Integer, String> map = getMap();

    String value = map.get(99);
    System.out.println(value); // null, 之前移除了

    // 不存在, 则只是放入newValue作为值, 不触发匿名函数
    map.merge(99, "val9", (v, newValue) -> v.concat(newValue));
    value = map.get(99); // val9
    System.out.println(value);

    map.merge(99, "concat", (v, newValue) -> v.concat(newValue));
    value = map.get(99); // val9concat
    System.out.println(value);
  }
}
