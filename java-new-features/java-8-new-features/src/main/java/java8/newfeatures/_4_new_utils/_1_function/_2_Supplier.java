package java8.newfeatures._4_new_utils._1_function;

import java.util.function.Supplier;
import java8.newfeatures.Person;

public class _2_Supplier {
  // Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
  public static void main(String[] args) {
    Supplier<Person> personSupplier = Person::new;
    System.out.println(personSupplier.get()); // 等同于new Person
  }
}
