package shijian.se05.new_util_Concurrent.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// 这里是一个实际的情况，大家排队上厕所，厕所只有两个位置，来了10个人需要排队。
public class MySemaphore extends Thread {
  private Semaphore position;
  private int id;

  public MySemaphore(int id, Semaphore s) {
    this.id = id;
    this.position = s;
  }

  @Override
  public void run() {
    try {
      if (position.availablePermits() > 0) {
        System.out.println("顾客[" + this.id + "]进入厕所，有空位");
      } else {
        System.out.println("顾客[" + this.id + "]进入厕所，没空位，排队");
      }
      // 这里看起来会在等待...
      // 占据
      position.acquire();
      System.out.println("顾客[" + this.id + "]获得坑位");
      Thread.sleep((int) (Math.random() * 10000));
      System.out.println("顾客[" + this.id + "]使用完毕");
      // 释放
      position.release();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    ExecutorService list = Executors.newCachedThreadPool();
    // 只有2个位置
    Semaphore position = new Semaphore(2);
    for (int i = 0; i < 10; i++) {
      list.submit(new MySemaphore(i + 1, position));
    }
    list.shutdown();
    position.acquireUninterruptibly(2);
    // 使用完毕
    System.out.println("程序全部执行完毕后才打印这里");
    System.out.println("使用完毕，需要清扫了");
    position.release(2);
  }
}
