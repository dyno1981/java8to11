package me.whiteship.java8to11;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AppDate {
    public static void main(String[] args) {
        Instant instant = Instant.now();
//        System.out.println(instant); // 기준시 UTC, GMT
//        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
//        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
//        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1981, Month.JULY, 7, 0, 0, 0);
//        System.out.println(birthday);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
//        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2023, Month.JULY, 7);

        Period period = Period.between(today, thisYearBirthday);
//        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
//        System.out.println(until.getDays());
//        System.out.println(period.get(ChronoUnit.DAYS));
//        System.out.println(until.get(ChronoUnit.DAYS));

        Instant plus = instant.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(instant, plus);
//        System.out.println(between.getSeconds());

        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("07/07/1981", MMddyyyy);
        System.out.println(parse);
    }
}
