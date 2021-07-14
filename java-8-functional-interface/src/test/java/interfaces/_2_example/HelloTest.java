package interfaces._2_example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class HelloTest {

  @Test
  public void hello() {
    // https://blog.csdn.net/blueheart20/article/details/80403735
    Hello hello = m -> m + "world!"; // Convert Class defination to statement
    assertEquals("hello world!", hello.message("hello "));
  }

  @Test
  public void helloNull() {
    Hello hello = m -> null;
    assertEquals(null, hello.message("hello "));
  }

  @Test
  public void methodReference() {
    Hello hello = m -> m + "world!";
    assertEquals("hello world!", Stream.of("hello ").map(hello::message).findAny().orElse(null));
  }

  @Test
  public void instance_of_function() {
    Hello hello = m -> m + "world!";
    Function<String, String> hello2 = m -> m + "world!";
    assertTrue(hello instanceof Hello);
    assertFalse(hello instanceof Function); // Not a Function
    assertFalse(hello2 instanceof Hello);
    assertTrue(hello2 instanceof Function);
    assertEquals(hello.message("hello "), hello2.apply("hello "));
  }

  @Test
  public void decoration() {
    Hello hello = m -> m + "world!";
    class HelloWorld {
      public String helloWorld(Hello hello) {
        return hello.message("hello ");
      }
    }
    assertEquals("hello world!", new HelloWorld().helloWorld(hello));
  }
}
