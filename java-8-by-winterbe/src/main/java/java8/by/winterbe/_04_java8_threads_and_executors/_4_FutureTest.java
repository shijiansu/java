package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class _4_FutureTest {
  public static void main(String[] args) throws Exception {
    future();
    futureTimeout();
    futureException();
  }

  //    Callbale也可以像runnbales一样提交给 executor services。
  //    但是callables的结果怎么办？
  //    因为submit()不会等待任务完成，executor service不能直接返回callable的结果。
  //    不过，executor 可以返回一个Future类型的结果，它可以用来在稍后某个时间取出实际的结果。
  private static Callable<Integer> getTask() {
    Callable<Integer> task =
        () -> {
          try {
            TimeUnit.SECONDS.sleep(2);
            return 123;
          } catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
          }
        };
    return task;
  }

  private static void future() throws Exception {
    System.out.println("[future]");
    Callable<Integer> task = getTask();
    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(task);

    System.out.println("future done? " + future.isDone());
    Integer result = future.get(); // 当前线程会阻塞等待

    System.out.println("future done? " + future.isDone());
    System.out.println("result: " + result);
  }

  private static void futureTimeout() throws Exception {
    System.out.println("[futureTimeout]");
    Callable<Integer> task = getTask();
    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(task);

    // 不永久等待下去, 如果处理不成功, 超时异常
    try {
      future.get(1, TimeUnit.SECONDS);
    } catch (TimeoutException e) {
      e.printStackTrace();
    }
  }

  private static void futureException() throws Exception {
    System.out.println("[futureException]");
    Callable<Integer> task = getTask();
    ExecutorService executor = Executors.newFixedThreadPool(1);
    Future<Integer> future = executor.submit(task);

    // 如果你关闭executor，所有的未中止的future都会抛出异常。
    try {
      executor.shutdownNow();
      future.get();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
