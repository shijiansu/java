package java8.by.winterbe._01_modern_java_a_guide_to_java8._14_date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {
        clock();
        clockToDate();
        timeZone();
        localTime();
        localTime2();
        localTimeFormatter();
        localDate();
        localDate2();
        localDateFormatter();
        localDateTime();
        localDateTimeFormatter();
        localDateTimeToDate();
    }

    private static void clock() {
        System.out.println("[clock]");
        // Clock提供了对当前时间和日期的访问功能。
        // 对当前时区敏感的，并可用于替代System.currentTimeMillis()方法来获取当前的毫秒时间。
        // 当前时间线上的时刻可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
    }

    private static void clockToDate() {
        System.out.println("[clockToDate]");
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);
    }

    private static void timeZone() {
        System.out.println("[timeZone]");
        // 时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获取。
        // 时区类还定义了一个偏移量，用来在当前时刻或某时间与目标时区时间之间进行转换。
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules()); // ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules()); // ZoneRules[currentStandardOffset=-03:00]
    }

    private static void localTime() {
        System.out.println("[localTime]");
        // 本地时间类表示一个没有指定时区的时间，例如, 10 p.m.或者17：30:15,
        // 下面的例子会用上面的例子定义的时区创建两个本地时间对象。
        // 然后我们会比较两个时间，并计算它们之间的小时和分钟的不同。
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween); // -3
        System.out.println(minutesBetween); // -239
    }

    private static void localTime2() {
        System.out.println("[localTime2]");
        // LocalTime是由多个工厂方法组成, 其目的是为了简化对时间对象实例的创建和操作，
        // 包括对时间字符串进行解析的操作。
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late); // 23:59:59
    }

    private static void localTimeFormatter() {
        System.out.println("[localTimeFormatter]");
        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
    }

    private static void localDate() {
        System.out.println("[localDate]");
        // 本地时间表示了一个独一无二的时间，例如：2014-03-11。这个时间是不可变的，与LocalTime是同源的。
        // 下面的例子演示了如何通过加减日，月，年等指标来计算新的日期。
        // 记住，每一次操作都会返回一个新的时间对象。
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);
    }

    private static void localDate2() {
        System.out.println("[localDate2]");
        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek); // FRIDAY
    }

    private static void localDateFormatter() {
        System.out.println("[localDateFormatter]");
        // 解析字符串并形成LocalDate对象，这个操作和解析LocalTime一样简单。
        DateTimeFormatter germanFormatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas); // 2014-12-24
    }

    private static void localDateTime() {
        System.out.println("[localDateTime]");
        // LocalDateTime表示的是日期-时间。它将刚才介绍的日期对象和时间对象结合起来，形成了一个对象实例。
        // LocalDateTime是不可变的，与LocalTime和LocalDate的工作原理相同。
        // 我们可以通过调用方法来获取日期时间对象中特定的数据域。
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        Month month = sylvester.getMonth();
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);

        System.out.println(dayOfWeek); // WEDNESDAY
        System.out.println(month); // DECEMBER
        System.out.println(minuteOfDay); // 1439
    }

    private static void localDateTimeFormatter() {
        System.out.println("[localDateTimeFormatter]");
        // 格式化日期-时间对象就和格式化日期对象或者时间对象一样。
        // 除了使用预定义的格式以外，我们还可以创建自定义的格式化对象，然后匹配我们自定义的格式。
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string); // Nov 03, 2014 - 07:13
        // 不同于java.text.NumberFormat，新的DateTimeFormatter类是不可变的，也是线程安全的。
    }

    private static void localDateTimeToDate() {
        System.out.println("[localDateTimeToDate]");
        // 如果再加上的时区信息，LocalDateTime能够被转换成Instance实例。
        // Instance能够被转换成以前的java.util.Date对象。
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date); // Wed Dec 31 23:59:59 CET 2014
    }
}
