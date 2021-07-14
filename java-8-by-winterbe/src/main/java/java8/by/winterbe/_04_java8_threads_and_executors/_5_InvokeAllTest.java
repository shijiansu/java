package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _5_InvokeAllTest {
  public static void main(String[] args) throws Exception {
    invokeAll();
  }

  //    private static Callable<String> callable(String result, long sleepSeconds) {
  //        return () -> {
  //            TimeUnit.SECONDS.sleep(sleepSeconds);
  //            return result;
  //        };
  //    }

  private static void invokeAll() throws Exception {
    System.out.println("[invokeAll]");
    List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

    // 批量提交
    ExecutorService executor = Executors.newWorkStealingPool();
    executor
        .invokeAll(callables)
        .stream()
        .map(
            future -> {
              try {
                return future.get();
              } catch (Exception e) {
                throw new IllegalStateException(e);
              }
            })
        .forEach(System.out::println);
  }
}
