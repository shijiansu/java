package shijian.se05.new_util_Concurrent.Future.CallableAndFuture2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
  public static class TaskRunnable implements Runnable {
    public void run() {
      String now = (new Date()).toString();
      String tid = String.valueOf(Thread.currentThread().getId());
      tid = now + tid;
      System.err.printf("TaskRunnable被调用了: %s\n", tid);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static class TaskCallable implements Callable<String> {
    public String call() {
      String now = (new Date()).toString();
      String tid = String.valueOf(Thread.currentThread().getId());
      tid = now + tid;
      System.out.printf("TaskCallable被调用了: %s\n", tid);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return tid;
    }
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      es.submit(new TaskRunnable());
    }
    es.shutdown();
    // 使用Callable可以带返回结果
    List<Future<String>> results = new ArrayList<Future<String>>();
    ExecutorService es2 = Executors.newCachedThreadPool();
    for (int i = 0; i < 10; i++) {
      results.add(es2.submit(new TaskCallable()));
    }
    es2.shutdown();
    // 这里看起来是所有都有结果后, 同步一次打印出来
    for (Future<String> res : results) {
      System.out.println("打印结果: " + res.get());
    }
  }
}
