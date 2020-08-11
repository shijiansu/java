package java8.by.winterbe._07_java8_api_strings_numbers_math_and_files;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3_FileTest {
  public static void main(String[] args) throws IOException {
    list();
    find();
    walk();
    readAllLines();
    lines();
    bufferedReader();
    bufferedReaderStream();
  }

  private static void list() {
    out.println("[list]");
    // 数据流的创建包装在try-with语句中。数据流实现了AutoCloseable
    try (Stream<Path> stream = Files.list(Paths.get(""))) {
      String joined =
          stream
              .map(String::valueOf)
              .filter(path -> !path.startsWith("."))
              .sorted()
              .collect(Collectors.joining("; "));
      out.println("List: " + joined);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void find() {
    out.println("[find]");
    Path start = Paths.get(".");
    int maxDepth = 5;
    // 提前filter
    try (Stream<Path> stream =
        Files.find(start, maxDepth, (path, attr) -> String.valueOf(path).endsWith(".xml"))) {
      String joined =
          stream
              .map(String::valueOf) // 这里是Path对象
              .sorted()
              .collect(Collectors.joining("; "));
      out.println("Found: " + joined);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void walk() {
    out.println("[walk]");
    Path start = Paths.get(".");
    int maxDepth = 5;
    try (Stream<Path> stream = Files.walk(start, maxDepth)) {
      String joined =
          stream
              .map(String::valueOf)
              .filter(path -> path.endsWith(".xml"))
              .sorted()
              .collect(Collectors.joining("; "));
      out.println("walk(): " + joined);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readAllLines() throws IOException {
    out.println("[readAllLines]");
    // 这些方法对内readAllLines存并不十分高效，因为整个文件都会读进内存。
    // 自己手动创建以下文件.
    List<String> lines = Files.readAllLines(Paths.get("d:/nashorn.js"));
    lines.add("print('foobar');");
    Files.write(Paths.get("d:/nashorn-modified.js"), lines);
  }

  private static void lines() throws IOException {
    out.println("[lines]");
    // 使用Files.lines方法来作为内存高效的替代。
    // 这个方法读取每一行，并使用函数式数据流来对其流式处理，而不是一次性把所有行都读进内存。
    try (Stream<String> stream = Files.lines(Paths.get("d:/nashorn.js"))) {
      stream.filter(line -> line.contains("print")).map(String::trim).forEach(out::println);
    }
  }

  private static void bufferedReader() throws IOException {
    out.println("[bufferedReader]");
    // 更多的精细控制，你需要构造一个新的BufferedReader来代替
    // 不幸的是你需要显式使用try-with语句来关闭文件流，这会使示例代码有些凌乱。
    Path path = Paths.get("d:/nashorn.js");
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      out.println(reader.readLine());
    }
    path = Paths.get("d:/nashorn-modified2.js");
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      writer.write("print('Hello World');");
    }
  }

  private static void bufferedReaderStream() throws IOException {
    out.println("[bufferedReader]");
    // BufferedReader也可以访问函数式数据流。lines方法在它所有行上面构建数据流
    Path path = Paths.get("d:/nashorn.js");
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      long countPrints = reader.lines().filter(line -> line.contains("print")).count();
      out.println(countPrints);
    }
  }
}
