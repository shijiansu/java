package java5.newfeatures._3_var_args;

public class _1_VarArgs {
  public static void main(String[] args) {
    varargsMethod(1, 2, "1", "2", "3");
    varargsMethod0("1", "2", "3");
  }

  private static void varargsMethod0(String... strs) {}

  private static void varargsMethod(int i, int j, String... strs) {}
}
