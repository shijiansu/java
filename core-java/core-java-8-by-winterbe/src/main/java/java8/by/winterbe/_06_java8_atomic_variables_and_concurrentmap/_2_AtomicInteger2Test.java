package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _2_AtomicInteger2Test {
  public static void main(String[] args) {
    start();
  }

  private static void start() {
    AtomicInteger atomicInt = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    IntStream.range(0, 1000)
        .forEach(
            i -> {
              Runnable task = () -> atomicInt.updateAndGet(n -> n + 2);
              executor.submit(task);
            });
    IntStream.range(0, 1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));
    ConcurrentUtils.stop(executor);
    System.out.println(atomicInt.get()); // => 3000
  }
}
