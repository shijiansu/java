package shijian.se05.static_import;

import static java.util.Collections.sort;

import java.util.ArrayList;

public class _1_StaticImport {
  public static void main(String[] args) {
    sort(new ArrayList<String>()); // 不需要提供Collections类名
  }
}
