package java8.by.winterbe._05_java8_synchronization_and_locks._04_locks_stampedLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class StampedLock2Test {
  // 展示了乐观锁
  Map<String, String> map = new HashMap<>();
  StampedLock lock = new StampedLock();
  ExecutorService executor = Executors.newFixedThreadPool(2);

  void start() {
    executor.submit(
        () -> {
          long stamp = lock.tryOptimisticRead();
          try {
            // 乐观的读锁通过调用tryOptimisticRead()获取，
            // 它总是返回一个标记而不阻塞当前线程，无论锁是否真正可用。
            // 如果已经有写锁被拿到，返回的标记等于0。
            // 你需要总是通过lock.validate(stamp)检查标记是否有效。
            System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            ConcurrentUtils.sleep(1);
            // 所以在使用乐观锁时，你需要每次在访问任何共享可变变量之后都要检查锁，来确保读锁仍然有效。
            System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            ConcurrentUtils.sleep(2);
            System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
          } finally {
            lock.unlock(stamp);
          }
        });
    executor.submit(
        () -> {
          long stamp = lock.writeLock();
          try {
            System.out.println("Write Lock acquired");
            ConcurrentUtils.sleep(2);
          } finally {
            lock.unlock(stamp);
            System.out.println("Write done");
          }
        });
    ConcurrentUtils.stop(executor);
  }

  public static void main(String[] args) {
    StampedLock2Test test = new StampedLock2Test();
    test.start();
    // 你会注意到两个读任务需要等待写任务完成。
    // 在释放了写锁之后，两个读任务会同时执行，并同时打印结果。
  }
}
