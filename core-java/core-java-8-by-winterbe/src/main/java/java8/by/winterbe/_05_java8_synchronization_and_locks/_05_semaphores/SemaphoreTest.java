package java8.by.winterbe._05_java8_synchronization_and_locks._05_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class SemaphoreTest {
  // 演示了如何限制对通过sleep(5)模拟的长时间运行任务的访问
  ExecutorService executor = Executors.newFixedThreadPool(10);
  Semaphore semaphore = new Semaphore(5);

  void start() {
    Runnable longRunningTask =
        () -> {
          boolean permit = false;
          try {
            permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            if (permit) {
              System.out.println("Semaphore acquired");
              ConcurrentUtils.sleep(5);
            } else {
              System.out.println("Could not acquire semaphore");
            }
          } catch (InterruptedException e) {
            throw new IllegalStateException(e);
          } finally {
            if (permit) {
              semaphore.release();
            }
          }
        };
    // 执行器可能同时运行10个任务，但是我们使用了大小为5的信号量，
    // 所以将并发访问限制为5。
    // 使用try-finally代码块在异常情况中合理释放信号量十分重要。
    IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));
    ConcurrentUtils.stop(executor);
  }

  public static void main(String[] args) {
    SemaphoreTest test = new SemaphoreTest();
    test.start();
    // Semaphore acquired
    // Semaphore acquired
    // Semaphore acquired
    // Semaphore acquired
    // Semaphore acquired
    // Could not acquire semaphore
    // Could not acquire semaphore
    // Could not acquire semaphore
    // Could not acquire semaphore
    // Could not acquire semaphore
  }
}
