package java8.by.winterbe._05_java8_synchronization_and_locks._04_locks_stampedLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class StampedLock3Test {
  // 第一个任务获取读锁，并向控制台打印count字段的当前值。
  // 但是如果当前值是零，我们希望将其赋值为23。
  // 我们首先需要将读锁转换为写锁，来避免打破其它线程潜在的并发访问。
  // tryConvertToWriteLock()的调用不会阻塞，但是可能会返回为零的标记，
  // 表示当前没有可用的写锁。这种情况下，我们调用writeLock()来阻塞当前线程，
  // 直到有可用的写锁。
  int count = 0;
  Map<String, String> map = new HashMap<>();
  StampedLock lock = new StampedLock();
  ExecutorService executor = Executors.newFixedThreadPool(2);

  void start() {
    executor.submit(
        () -> {
          long stamp = lock.readLock();
          try {
            if (count == 0) {
              stamp = lock.tryConvertToWriteLock(stamp);
              if (stamp == 0L) {
                System.out.println("Could not convert to write lock");
                stamp = lock.writeLock();
              }
              count = 23;
            }
            System.out.println(count);
          } finally {
            lock.unlock(stamp);
          }
        });
    ConcurrentUtils.stop(executor);
  }

  public static void main(String[] args) {
    StampedLock3Test test = new StampedLock3Test();
    test.start();
  }
}
