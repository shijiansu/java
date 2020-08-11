package java8.by.winterbe._01_modern_java_a_guide_to_java8._03_functional_interfaces;

// 一个所谓的函数式接口必须要有且仅有一个抽象方法声明。
// 每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。
// 由于默认方法不是抽象的，因此你可以在你的函数式接口里任意添加默认方法。
// 如果你不写@FunctionalInterface 标注，程序也是正确的。
@FunctionalInterface
public interface Converter<FROM, TO> {
  TO convert(FROM from); // 抽象方法, 但不是默认方法
}
