package java8.by.winterbe._05_java8_synchronization_and_locks._02_locks_reentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _2_ReentrantLockTest {
  public static void main(String[] args) {
    _2_ReentrantLockTest test = new _2_ReentrantLockTest();
    test.safe(); // 10000
    test.locked();
  }

  private ReentrantLock lock = new ReentrantLock();
  private int count = 0;

  // ReentrantLock类是互斥锁，
  // 与通过synchronized访问的隐式监视器具有相同行为，
  // 但是具有扩展功能。就像它的名称一样，
  // 这个锁实现了重入特性，就像隐式监视器一样。
  private void increment() {
    lock.lock(); // 锁可以通过lock()来获取，通过unlock()来释放。
    try {
      count++;
    } finally {
      lock.unlock();
      // 这个方法是线程安全的，就像同步副本那样。如果另一个线程已经拿到锁了，
      // 再次调用lock()会阻塞当前线程，直到锁被释放。
      // 在任意给定的时间内，只有一个线程可以拿到锁。
    }
  }

  private void safe() {
    System.out.println("[safe]");
    ExecutorService executor = Executors.newFixedThreadPool(10);
    IntStream.range(0, 10000).forEach(i -> executor.submit(this::increment));
    ConcurrentUtils.stop(executor);
    System.out.println(count);
  }

  void locked() {
    ExecutorService executor = Executors.newFixedThreadPool(10);
    executor.submit(
        () -> {
          lock.lock();
          try {
            ConcurrentUtils.sleep(1);
          } finally {
            lock.unlock();
          }
        });
    executor.submit(
        () -> {
          System.out.println("Locked: " + lock.isLocked()); // true
          System.out.println("Held by me: " + lock.isHeldByCurrentThread()); // false
          boolean locked = lock.tryLock(); // tryLock()方法是lock()方法的替代，它尝试拿锁而不阻塞当前线程。
          // 在访问任何共享可变变量之前，必须使用布尔值结果来检查锁是否已经被获取。
          System.out.println("Lock acquired: " + locked); // false
        });
    ConcurrentUtils.stop(executor);
  }
}
