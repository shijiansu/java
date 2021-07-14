package java8.by.winterbe._05_java8_synchronization_and_locks._03_locks_readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _3_ReadWriteLockTest {
  public static void main(String[] args) {
    _3_ReadWriteLockTest test = new _3_ReadWriteLockTest();
    test.start();
    // 你会注意到两个读任务需要等待写任务完成。
    // 在释放了写锁之后，两个读任务会同时执行，并同时打印结果。
  }

  // ReadWriteLock接口规定了锁的另一种类型，包含用于读写访问的一对锁。读写锁的理念是，
  // 只要没有任何线程写入变量，并发读取可变变量通常是安全的。
  // 所以读锁可以同时被多个线程持有，只要没有线程持有写锁。
  // 这样可以提升性能和吞吐量，因为读取比写入更加频繁。
  private Map<String, String> map = new HashMap<>();
  private ReadWriteLock lock = new ReentrantReadWriteLock();

  private void start() {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(
        () -> {
          lock.writeLock().lock();
          try {
            // 写锁, 两个读任务需要等待写任务完成
            ConcurrentUtils.sleep(10);
            map.put("foo", "bar");
          } finally {
            lock.writeLock().unlock();
          }
        });
    Runnable readTask =
        () -> {
          lock.readLock().lock();
          try {
            // 读锁, 这里可以同时拿WriteLock的值
            System.out.println(System.currentTimeMillis() + ":" + map.get("foo"));
            ConcurrentUtils.sleep(1);
          } finally {
            lock.readLock().unlock();
          }
        };
    executor.submit(readTask);
    executor.submit(readTask);
    ConcurrentUtils.stop(executor);
  }
}
