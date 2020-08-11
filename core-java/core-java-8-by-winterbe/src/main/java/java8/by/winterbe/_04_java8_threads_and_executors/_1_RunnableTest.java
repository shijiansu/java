package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.concurrent.TimeUnit;

public class _1_RunnableTest {
  public static void main(String[] args) throws Exception {
    runnable();
  }

  private static void runnable() {
    System.out.println("[runnable]");
    // 旧方法
    Runnable runnable =
        () -> {
          try {
            String name = Thread.currentThread().getName();
            System.out.println("Foo " + name);

            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bar " + name);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        };
    Thread thread = new Thread(runnable);
    thread.start();
  }
}
