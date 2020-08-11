package java8.by.winterbe._01_modern_java_a_guide_to_java8._05_lambda_scopes;

public class LambdaScopeTest {
  public static void main(String[] args) {
    lambdaScope();
  }

  private static void lambdaScope() {
    System.out.println("[lambdaScope]");
    LambdaScope lambdaScope = new LambdaScope();

    System.out.println(LambdaScope.outerStaticNum); // 0
    System.out.println(lambdaScope.outerNum); // 0

    lambdaScope.accessLocalVar(); // 3
    lambdaScope.accessLocalVarNoFinal(); // 3
    lambdaScope.accessLocalVarNotFinal(); // 3
    lambdaScope.accessClassVar(); // 3
    lambdaScope.accessStaticVar(); // 3

    // 可以改变变量的值
    System.out.println(LambdaScope.outerStaticNum); // 1
    System.out.println(lambdaScope.outerNum); // 1
  }
}
