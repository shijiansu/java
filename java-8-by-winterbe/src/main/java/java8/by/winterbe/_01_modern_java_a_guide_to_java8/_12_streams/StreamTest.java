package java8.by.winterbe._01_modern_java_a_guide_to_java8._12_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

// Intermediate: 这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
// Intermediate: map (mapToInt, flatMap 等) , filter , distinct , sorted , peek , limit , skip , parallel , sequential , unordered
// Terminal: forEach , forEachOrdered , toArray , reduce , collect , min , max , count , anyMatch , allMatch , noneMatch , findFirst , findAny , iterator
// Short-circuiting: anyMatch , allMatch , noneMatch , findFirst , findAny , limit
public class StreamTest {
    public static void main(String[] args) {
        filter();
        sorted();
        map();
        match();
        count();
        reduce();
        parallelSingle();
        parallelMultiple();
    }

    private static List<String> elements() {
        List<String> collection = new ArrayList<>();
        collection.add("ddd2");
        collection.add("aaa2");
        collection.add("bbb1");
        collection.add("aaa1");
        collection.add("bbb3");
        collection.add("ccc");
        collection.add("bbb2");
        collection.add("ddd1");
        return collection;
    }

    private static List<String> largeData() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }

    private static void filter() {
        System.out.println("[filter]");
        List<String> data = elements();
        // aaa2, aaa1
        data.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
        System.out.println(data);
    }

    private static void sorted() {
        System.out.println("[sorted]");
        // sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序。
        // 原来string集合中的元素顺序是没有改变的。
        List<String> data = elements();
        // aaa1, aaa2, bbb1, bbb2, bbb3, ccc, ddd1, ddd2
        data.stream().sorted().forEach(System.out::println);
        System.out.println(data);
    }

    // 不是HashMap的那类数据结构的map, 而将原来的值映射到其他值
    private static void map() {
        System.out.println("[map]");
        // map是一个对于流对象的中间操作，通过给定的方法，
        // 它能够把流对象中的每一个元素对应到另外一个对象上。
        List<String> data = elements();
        // DDD2, DDD1, CCC, BBB3, BBB2, AAA2, AAA1
        data.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        System.out.println(data);
    }

    private static void match() {
        System.out.println("[origin]");
        // 匹配操作有多种不同的类型，都是用来判断某一种规则是否与流对象相互吻合的。
        // 所有的匹配操作都是终结操作，只返回一个boolean类型的结果。
        boolean anyStartsWithA = elements().stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA); // true

        boolean allStartsWithA = elements().stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA); // false

        boolean noneStartsWithZ = elements().stream().noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartsWithZ); // true
    }

    private static void count() {
        System.out.println("[count]");
        // Count是一个终结操作，它的作用是返回一个数值，用来标识当前流对象中包含的元素数量。
        long startsWithB = elements().stream().filter(s -> s.startsWith("b")).count();
        System.out.println(startsWithB); // 3
    }

    private static void reduce() {
        System.out.println("[reduce]");
        // 该操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。
        // 该操作的结果会放在一个Optional变量里返回。
        Optional<String> reduced = elements().stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }

    // 流操作可以是顺序的，也可以是并行的。顺序操作通过单线程执行，而并行操作则通过多线程执行。
    private static void parallelSingle() {
        System.out.println("[parallelSingle]");
        // 顺序排序
        long t0 = System.nanoTime();
        long count = largeData().stream().sorted().count(); // count只是作为结束操作
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    private static void parallelMultiple() {
        System.out.println("[parallelMultiple]");
        // 并行排序
        long t0 = System.nanoTime();
        long count = largeData().parallelStream().sorted().count();  // count只是作为结束操作
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }
}
