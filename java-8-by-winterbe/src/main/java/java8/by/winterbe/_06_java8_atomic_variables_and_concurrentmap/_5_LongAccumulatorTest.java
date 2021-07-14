package java8.by.winterbe._06_java8_atomic_variables_and_concurrentmap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;
import java8.by.winterbe._04_java8_threads_and_executors.ConcurrentUtils;

public class _5_LongAccumulatorTest {
  public static void main(String[] args) {
    start();
  }

  // LongAccumulator是LongAdder的更通用的版本。
  // LongAccumulator以类型为LongBinaryOperatorlambda表达式构建，而不是仅仅执行加法操作
  private static void start() {
    LongBinaryOperator op = (x, y) -> 2 * x + y; // 调用这个方法
    LongAccumulator accumulator = new LongAccumulator(op, 1L);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    IntStream.range(0, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));
    ConcurrentUtils.stop(executor);
    System.out.println(accumulator.getThenReset()); // => 2539
  }
}
