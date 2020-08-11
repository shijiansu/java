package java8.newfeatures._4_new_utils._1_function;

import java.util.function.Consumer;
import java8.newfeatures.Person;

public class _3_Consumer {
  // Consumer 接口表示执行在单个参数上的操作。
  public static void main(String[] args) {
    Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
    greeter.accept(new Person("Luke", "Skywalker"));
  }
}
