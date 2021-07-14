package java8.by.winterbe._01_modern_java_a_guide_to_java8._04_method_and_constructor_references;

public interface PersonFactory<P extends Person> {
  P create(String firstName, String lastName);
}
