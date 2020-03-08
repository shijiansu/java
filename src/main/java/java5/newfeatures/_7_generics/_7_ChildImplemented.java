package java5.newfeatures._7_generics;

import java.util.List;
import java.util.Map;

public class _7_ChildImplemented {
  // 完全特化
  public abstract class StringList implements List<String> {}

  // 部分特化
  abstract class StringKeyMap<V> implements Map<String, V> {}
}
