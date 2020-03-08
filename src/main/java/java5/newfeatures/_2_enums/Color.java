package java5.newfeatures._2_enums;

public enum Color {
  RED("FF0000"),
  GREEN("00FF00"),
  BLUE("0000FF") {
    // 每个枚举值可以覆盖方法
    public String toString() {
      return "00F";
    }
  };
  // 和普通类一样，枚举可以具有字段、方法、构造器
  private String code;

  private Color(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return code;
  }
}
