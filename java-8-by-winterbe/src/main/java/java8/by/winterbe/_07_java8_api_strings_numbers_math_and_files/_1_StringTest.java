package java8.by.winterbe._07_java8_api_strings_numbers_math_and_files;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1_StringTest {
  public static void main(String[] args) {
    join();
    chars();
    patternSplit();
    patternFilter();
  }

  private static void join() {
    System.out.println("[join]");
    String s = String.join(":", "foobar", "foo", "bar");
    System.out.println(s); // foobar:foo:bar
  }

  private static void chars() {
    System.out.println("[chars]");
    String s = "foobar:foo:bar";
    s =
        s.chars()
            .distinct() // becomes chars stream
            .mapToObj(c -> String.valueOf((char) c)) // convert char to String
            .sorted()
            .collect(Collectors.joining());
    System.out.println(s); // :abfor
  }

  private static void patternSplit() {
    System.out.println("[patternSplit]");
    String s = "foobar:foo:bar";
    s =
        Pattern.compile(":")
            .splitAsStream(s)
            .filter(ss -> ss.contains("bar"))
            .sorted()
            .collect(Collectors.joining(":"));
    System.out.println(s); // bar:foobar
  }

  private static void patternFilter() {
    System.out.println("[patternFilter]");
    Pattern pattern = Pattern.compile(".*@gmail\\.com");
    long i = Stream.of("bob@gmail.com", "alice@hotmail.com").filter(pattern.asPredicate()).count();
    System.out.println(i); // 1
  }
}
