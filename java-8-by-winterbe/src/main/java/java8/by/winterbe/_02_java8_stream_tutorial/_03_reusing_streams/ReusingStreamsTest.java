package java8.by.winterbe._02_java8_stream_tutorial._03_reusing_streams;

import static java.lang.System.out;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReusingStreamsTest {
  public static void main(String[] args) {
    try {
      terminalOperationStreamIsClosed();
    } catch (Exception e) {
      out.println(e.getMessage());
    }
    overcomeAboveLimitation();
  }

  private static void terminalOperationStreamIsClosed() {
    System.out.println("[terminalOperationStreamIsClosed]");
    Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

    out.println(stream.anyMatch(s -> true)); // ok
    out.println(stream.noneMatch(s -> true)); // exception
    //    java.lang.IllegalStateException: stream has already been operated upon or closed
    //    at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
    //    at java.util.stream.ReferencePipeline.noneMatch(ReferencePipeline.java:459)
    //    at com.winterbe.java8.Streams5.test7(Streams5.java:38)
    //    at com.winterbe.java8.Streams5.main(Streams5.java:28)
  }

  private static void overcomeAboveLimitation() {
    System.out.println("[overcomeAboveLimitation]");

    Supplier<Stream<String>> streamSupplier =
        () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

    out.println(streamSupplier.get().anyMatch(s -> true)); // ok
    out.println(streamSupplier.get().noneMatch(s -> true)); // ok
  }
}
