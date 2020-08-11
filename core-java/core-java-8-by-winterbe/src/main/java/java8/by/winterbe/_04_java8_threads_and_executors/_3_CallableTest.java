package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class _3_CallableTest {
  public static void main(String[] args) throws Exception {
    callable();
  }

  // Callables也是类似于runnables的函数接口，不同之处在于，Callable返回一个值。
  private static void callable() throws Exception {
    System.out.println("[callable]");
    Callable<Integer> task =
        () -> {
          try {
            TimeUnit.SECONDS.sleep(2);
            return 123;
          } catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
          }
        };

    Integer result = task.call();
    System.out.println("callable done? ");
    System.out.println("result: " + result);
  }
}
