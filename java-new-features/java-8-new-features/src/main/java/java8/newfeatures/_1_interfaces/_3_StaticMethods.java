package java8.newfeatures._1_interfaces;

public class _3_StaticMethods {

  interface StaticFunInterface {
    static int find() {
      System.out.println(1);
      return 1;
    }
  }

  public static void main(String[] args) {
    // 接口中定义了静态方法 find 直接被调用
    StaticFunInterface.find();
  }
}
