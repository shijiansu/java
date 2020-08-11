package java8.newfeatures._4_new_utils._3_date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class _1_Clock {
  public static void main(String[] args) {
    Clock clock = Clock.systemDefaultZone();
    long millis = clock.millis();
    Instant instant = clock.instant();
    Date legacyDate = Date.from(instant); // legacy java.util.Date
  }
}
