package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _6_InvokeAnyTest {
  public static void main(String[] args) throws Exception {
    invokeAny();
  }

  private static Callable<String> callable(String result, long sleepSeconds) {
    return () -> {
      TimeUnit.SECONDS.sleep(sleepSeconds);
      return result;
    };
  }

  private static void invokeAny() throws Exception {
    System.out.println("[invokeAny]");
    List<Callable<String>> callables =
        Arrays.asList(callable("task1", 2), callable("task2", 1), callable("task3", 3));

    // 这个方法将会阻塞直到第一个callable中止然后返回这一个callable的结果。
    ExecutorService executor = Executors.newWorkStealingPool();
    String result = executor.invokeAny(callables); // 只有1个最快的
    System.out.println(result); // task2
  }
}
