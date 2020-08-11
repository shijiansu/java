package java8.newfeatures._1_interfaces;

@FunctionalInterface
public interface _1_FunctionalInterface {
  // 哪怕有很多默认方法，只要接口只定义了一个抽象方法，它就仍然是一个函数式接口。
  public abstract void run();
}
