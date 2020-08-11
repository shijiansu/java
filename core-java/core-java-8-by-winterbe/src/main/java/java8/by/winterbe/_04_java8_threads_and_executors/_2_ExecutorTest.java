package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _2_ExecutorTest {
  public static void main(String[] args) throws Exception {
    executor();
    executorShutdown();
  }

  private static void executor() throws Exception {
    System.out.println("[executor]");
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(
        () -> {
          String threadName = Thread.currentThread().getName();
          System.out.println("Hello " + threadName);
        });
    executor.shutdown(); // 必须关闭, Hello pool-1-thread-1
    // ExecutorService提供了两个方法来达到这个目的:
    // shutdwon()会等待正在执行的任务执行完而
    // shutdownNow()会终止所有正在执行的任务并立即关闭executor。
  }

  private static void executorShutdown() throws Exception {
    System.out.println("[executorShutdown]");
    // 关闭的写法
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      System.out.println("attempt to shutdown executor");
      executor.shutdown();
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      System.err.println("tasks interrupted");
    } finally {
      if (!executor.isTerminated()) {
        System.err.println("cancel non-finished tasks");
      }
      executor.shutdownNow();
      System.out.println("shutdown finished");
    }
  }
}
