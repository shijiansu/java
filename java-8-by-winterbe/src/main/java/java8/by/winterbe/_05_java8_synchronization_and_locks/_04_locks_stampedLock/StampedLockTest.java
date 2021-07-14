package java8.by.winterbe._05_java8_synchronization_and_locks._04_locks_stampedLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class StampedLockTest {
  // Java 8 自带了一种新的锁，叫做StampedLock，它同样支持读写锁，
  // 就像上面的例子那样。与ReadWriteLock不同的是，
  // StampedLock的锁方法会返回表示为long的标记。
  // 你可以使用这些标记来释放锁，或者检查锁是否有效。
  // 此外，StampedLock支持另一种叫做乐观锁（optimistic locking）的模式。
  Map<String, String> map = new HashMap<>();
  StampedLock lock = new StampedLock();
  ExecutorService executor = Executors.newFixedThreadPool(2);

  void start() {
    executor.submit(
        () -> {
          long stamp = lock.writeLock();
          try {
            ConcurrentUtils.sleep(1);
          } finally {
            lock.unlockWrite(stamp);
          }
        });
    Runnable readTask =
        () -> {
          long stamp = lock.readLock();
          try {
            System.out.println(map.get("foo"));
            ConcurrentUtils.sleep(1);
          } finally {
            lock.unlockRead(stamp);
            // 要记住StampedLock并没有实现重入特性。每次调用加锁都会返回一个新的标记，
            // 并且在没有可用的锁时阻塞，即使相同线程已经拿锁了。
            // 所以你需要额外注意不要出现死锁。
          }
        };
    executor.submit(readTask);
    executor.submit(readTask);
    ConcurrentUtils.stop(executor);
  }

  public static void main(String[] args) {
    StampedLockTest test = new StampedLockTest();
    test.start();
    // 你会注意到两个读任务需要等待写任务完成。
    // 在释放了写锁之后，两个读任务会同时执行，并同时打印结果。
  }
}
