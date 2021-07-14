package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _1_AtomicIntegerTest {
  public static void main(String[] args) {
    start();
  }

  private static void start() {
    // java.concurrent.atomic包含了许多实用的类，
    // 用于执行原子操作。如果你能够在多线程中同时且安全地执行某个操作，
    // 而不需要synchronized关键字或锁，那么这个操作就是原子的。
    AtomicInteger atomicInt = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    IntStream.range(0, 1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));
    // updateAndGet()接受lambda表达式，以便在整数上执行任意操作：
    ConcurrentUtils.stop(executor);
    System.out.println(atomicInt.get()); // => 1000
  }
}
