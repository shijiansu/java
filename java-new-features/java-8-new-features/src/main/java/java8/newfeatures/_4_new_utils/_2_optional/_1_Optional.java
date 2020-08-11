package java8.newfeatures._4_new_utils._2_optional;

import java.util.Optional;

public class _1_Optional {
  public static void main(String[] args) {
    Optional<String> optional = Optional.of("bam");
    optional.isPresent(); // true
    optional.get(); // "bam"
    optional.orElse("fallback"); // "bam"
    optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
  }
}
