package java8.newfeatures._4_new_utils._4_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class _2_ComputingInParallel {
  public static void main(String[] args) {
    // 初始化一个大型的数据
    int max = 1000000;
    List<String> values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }
    // 旧的, 并影响了原来的List
    long ct0 = System.nanoTime();
    values.sort(String::compareTo);
    long ccount = values.size();
    System.out.println(ccount);
    long ct1 = System.nanoTime();
    long cmillis = TimeUnit.NANOSECONDS.toMillis(ct1 - ct0);
    System.out.println(String.format("sequential sort took: %d ms", cmillis)); // 893ms

    values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }
    // 串行运算
    long t0 = System.nanoTime();
    long count = values.stream().sorted().count();
    System.out.println(count);
    long t1 = System.nanoTime();
    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    System.out.println(
        String.format("sequential sort took: %d ms", millis)); // 892ms, 和Collection差不多

    // 并行运算
    long st0 = System.nanoTime();
    long scount = values.parallelStream().sorted().count();
    System.out.println(scount);
    long st1 = System.nanoTime();
    long smillis = TimeUnit.NANOSECONDS.toMillis(st1 - st0);
    System.out.println(String.format("parallel sort took: %d ms", smillis)); // 405ms
  }
}
