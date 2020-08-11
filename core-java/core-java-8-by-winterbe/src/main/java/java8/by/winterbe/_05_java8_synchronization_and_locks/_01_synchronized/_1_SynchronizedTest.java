package java8.by.winterbe._05_java8_synchronization_and_locks._01_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _1_SynchronizedTest {
  public static void main(String[] args) {
    _1_SynchronizedTest test = new _1_SynchronizedTest();
    test.unsafe();
    test.safe(); // 10000
    test.safe2(); // 10000
  }

  private int count = 0;
  private int count2 = 0;
  private int count3 = 0;

  private void increment() {
    count = count + 1;
  }

  private synchronized void incrementSync() {
    count2 = count2 + 1;
  }

  private void incrementSync2() {
    synchronized (this) {
      count3 = count3 + 1;
    }
  }

  private void unsafe() {
    System.out.println("[unsafe]");
    ExecutorService executor = Executors.newFixedThreadPool(10);
    IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
    ConcurrentUtils.stop(executor);
    // 我们没有看到count为10000的结果，上面代码的实际结果在每次执行时都不同。
    // 原因是我们在不同的线程上共享可变变量，并且变量访问没有同步机制，这会产生竞争条件。
    System.out.println(count);
  }

  private void safe() {
    System.out.println("[safe]");
    ExecutorService executor = Executors.newFixedThreadPool(10);
    IntStream.range(0, 10000).forEach(i -> executor.submit(this::incrementSync));
    ConcurrentUtils.stop(executor);
    System.out.println(count2);
  }

  private void safe2() {
    System.out.println("[safe2]");
    ExecutorService executor = Executors.newFixedThreadPool(10);
    IntStream.range(0, 10000).forEach(i -> executor.submit(this::incrementSync2));
    ConcurrentUtils.stop(executor);
    System.out.println(count3);
  }
}
