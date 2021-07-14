package sneakythrows;

import static com.pivovarit.function.ThrowingFunction.unchecked;
import static org.jooq.lambda.Unchecked.function;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static sneakythrows._1_pivovarit.SimpleThrowingFunction.simpleSneakyThrow;
import static sneakythrows._1_pivovarit.SimpleThrowingFunction.simpleUnchecked;

import com.lambdista.util.Try;
import com.pivovarit.function.exception.WrappedException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Optional;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class SneakyThrowsTest {

  static String ioException(Integer i) throws IOException {
    throw new IOException("whoopsie." + i);
  }

  @SneakyThrows
  static String ioException2(Integer i) {
    throw new IOException("whoopsie." + i);
  }

  @Test
  void simple_sneaky_throw() {
    assertThrows(IOException.class, () -> simpleSneakyThrow(new IOException()));
  }

  @Test
  void simple_unchecked() {
    assertThrows(
        IOException.class,
        () -> Optional.of(42).map(simpleUnchecked(SneakyThrowsTest::ioException)));
  }

  @Test
  void privovarit_unchecked() {
    assertThrows(
        WrappedException.class,
        () -> Optional.of(42).map(unchecked(SneakyThrowsTest::ioException)));
  }

  @Test
  void lambok_sneaky_throws() {
    assertThrows(IOException.class, () -> Optional.of(42).map(SneakyThrowsTest::ioException2));
  }

  @Test
  void jool_unchecked() {
    assertThrows(
        UncheckedIOException.class,
        () -> Optional.of(42).map(function(SneakyThrowsTest::ioException)));
  }

  // not a very nice solution because of
  // Try is to handle String as default return value,
  // but not deal with Exception directly
  @Test
  void lambdista_try_catch_no_action() {
    Optional.of(42).map(i -> Try.apply(() -> ioException(i)));
  }
}
