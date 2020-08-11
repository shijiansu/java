package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _4_LongAdderTest {
  public static void main(String[] args) {
    start();
  }

  private static void start() {
    LongAdder adder = new LongAdder();
    ExecutorService executor = Executors.newFixedThreadPool(2);
    IntStream.range(0, 1000).forEach(i -> executor.submit(adder::increment));
    ConcurrentUtils.stop(executor);
    System.out.println(adder.sumThenReset()); // => 1000
  }
}
