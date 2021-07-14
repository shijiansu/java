package interfaces._1_definition;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;

// https://blog.csdn.net/ZYC88888/article/details/86649994
public class FunctionTest {

  @Test
  public void greet() {
    GreetingService greetService = message -> "hello " + message;
    assertEquals("hello world!", greetService.message("world!"));
  }

  @Test
  public void instance_of_greetingService() {
    GreetingService f1 = m -> "good idea!";
    class f2 implements GreetingService {
      @Override
      public String message(String message) {
        return "no idea!";
      }
    }
    // Function is a object!
    assertTrue(f1 instanceof GreetingService);
    // Before Java8, need to initiate Object because the definition is a Class
    assertTrue(new f2() instanceof GreetingService);
    assertEquals(3, f1.maxNumber(3, 1)); // able use default method
    assertFalse(f1 instanceof GreetingService2); // be careful! had matched to GreetingService1
  }

  @Test
  public void examples() {
    Function<String, String> function1 = item -> item + " return";
    Consumer<String> function2 = System.out::println;
    Predicate<String> function3 = ""::equals;
    Supplier<String> function4 = () -> "";

    assertEquals("var return", function1.apply("var"));
    function2.accept("var");
    assertTrue(function3.test(""));
    assertEquals("", function4.get());
  }

  @Test
  public void list() {
    List<String> list = asList("zhangsan", "lisi", "wangwu", "xiaoming", "zhaoliu");
    list.stream()
        .map(value -> value + "-1")
        .filter(value -> value.length() > 2)
        .forEach(System.out::println);
  }

  @Test
  public void bi_function() {
    BiFunction<String, String, Integer> biFunction = (str1, str2) -> str1.length() + str2.length();
    BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + str2);
    BiPredicate<String, String> biPredicate = (str1, str2) -> str1.length() > str2.length();

    assertEquals(10, biFunction.apply("hello", "world"));
    biConsumer.accept("hello", "world");
    assertFalse(biPredicate.test("hello", "world"));
  }

  @Test
  public void andThen_compose() {
    Function<String, String> function1 = s -> s + " hello";
    Function<String, String> function2 = s -> s + " world!";

    assertEquals("a hello world!", function1.andThen(function2).apply("a"));
    assertEquals("a world! hello", function1.compose(function2).apply("a"));

    assertEquals(function2.compose(function1).apply("a"), function1.andThen(function2).apply("a"));

    assertEquals(7, function1.andThen(String::length).apply("a"));

    UnaryOperator<Integer> plus3 = i -> i + 3;
    assertEquals(4, plus3.compose(String::length).apply("a"));
  }
}
