package java8.by.winterbe._04_java8_threads_and_executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class _7_ScheduledExecutorServiceTest {
  public static void main(String[] args) throws Exception {
    delay3seconds();
    scheduleAtFixedRate();
    scheduleAtFixedRate2();
    scheduleWithFixedDelay();
  }

  private static void delay3seconds() throws Exception {
    System.out.println("[delay3seconds]");
    // ScheduledExecutorService支持任务调度，持续执行或者延迟一段时间后执行。
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    Runnable task = () -> System.out.println(String.format("Scheduling: %s", System.nanoTime()));

    // 调度一个任务在延迟3秒(3000微秒)后执行
    ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
    TimeUnit.MILLISECONDS.sleep(1337);

    // 提供了getDelay()方法来获得剩余的延迟。
    long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
    System.out.println(String.format("Remaining Delay: %sms", remainingDelay));
    // 打印出来1662ms, 这个是原来3000微秒, 减去1337微秒的剩余
  }

  private static void scheduleAtFixedRate() throws Exception {
    System.out.println("[scheduleAtFixedRate]");
    // 为了调度任务持续的执行，executors 提供了两个方法scheduleAtFixedRate()和scheduleWithFixedDelay()。
    // 第一个方法用来以固定频率来执行一个任务，每秒钟一次, 不考虑任务的实际用时。
    // 可能会导致同时任务重复执行
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    Runnable task = () -> System.out.println(String.format("Scheduling: %s", System.nanoTime()));
    // 初始化延迟，用来指定这个任务首次被执行等待的时长。
    int initialDelay = 0;
    int period = 1;
    executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    // 触发的间隔一致, 但显示的时间间隔不一致, 因为是定时触发的时候可能前一个任务都没有执行完毕
    // Scheduling:	7040, 639784751
    // Scheduling:	7041, 639513985 差别为: 999729234
    // Scheduling:	7042, 298521321 差别为: 659007336
    // Scheduling:	7042, 639473838 差别为: 340952517
    // Scheduling:	7043, 639507344 差别为: 1000033506
    // Scheduling:	7044, 639630200 差别为: 1000122856
    // Scheduling:	7045, 640600068 差别为: 1000969868
  }

  private static void scheduleAtFixedRate2() throws Exception {
    System.out.println("[scheduleAtFixedRate2]");
    // 如果指定了一个period为1秒钟而任务需要执行2秒钟，那么线程池会更快的执行。
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    Runnable task =
        () -> {
          try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(String.format("Scheduling: %s", System.nanoTime()));
          } catch (InterruptedException e) {
            System.err.println("task interrupted");
          }
        };
    int initialDelay = 0;
    int period = 1;
    executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    // Scheduling: 98862, 5052475042
    // Scheduling: 98862, 7055585976 差别为: 2003110934
    // Scheduling: 98862, 9055593824 差别为: 2000007848
    // Scheduling: 98863, 1055705813 差别为: 2000111989
    // Scheduling: 98863, 3055796370 差别为: 2000090557
    // Scheduling: 98863, 5055884512 差别为: 2000088142
    // Scheduling: 98863, 7055939450 差别为: 2000054938
    // Scheduling: 98863, 9056053249 差别为: 2000113799
  }

  private static void scheduleWithFixedDelay() throws Exception {
    System.out.println("[scheduleWithFixedDelay]");
    // 需要完成任务后等待同等间隔, 应该考虑使用scheduleWithFixedDelay()。
    // 不会准点触发, 但保证同时的单点操作
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    Runnable task =
        () -> {
          try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(String.format("Scheduling: %s", System.nanoTime()));
          } catch (InterruptedException e) {
            System.err.println("task interrupted");
          }
        };
    int initialDelay = 0;
    int period = 1;
    executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);
    // 每个相隔3秒, 因为任务执行了2秒
    // Scheduling:	6645, 352056645
    // Scheduling:	6648, 353021683 差别为: 3000965038
    // Scheduling:	6651, 354182325 差别为: 3001160642
    // Scheduling:	6654, 354320576 差别为: 3000138251
    // Scheduling:	6657, 355474577 差别为: 3001154001
    // Scheduling:	6660, 356631596 差别为: 3001157019
  }
}
