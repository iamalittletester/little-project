package com.imalittletester.atd2020;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class UsefulDatesTest {

    @Test
    void generateDates() {
        //current date in default format. e.g.: 2020-09-05
        LocalDate nowAsDate = LocalDate.now();
        System.out.println("nowAsDate = " + nowAsDate);
        //current date and time in default format. e.g.: 2020-09-05T16:49:12.820573200
        LocalDateTime nowAsDateTime = LocalDateTime.now();
        System.out.println("nowAsDateTime = " + nowAsDateTime);

        //format current date to display 2 digits for day, 2 digits for
        // month, 4 digits for year, separated by /. e.g.: 05/09/2020
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String now2DigitsForMonth = formatter.format(nowAsDate);
        System.out.println("now2DigitsForMonth = " + now2DigitsForMonth);

        //format current date to display 2 digits for day, shorthand for
        // month, 4 digits for year, separated by -. e.g.: 05-Sep-2020
        formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String nowMonthShorthand = formatter.format(nowAsDate);
        System.out.println("nowMonthShorthand = " + nowMonthShorthand);

        //format current date to display 2 digits for day, entire name of
        //month, 4 digits for year, separated by space.
        // e.g.: 05 September 2020
        formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String nowFullMonthName = formatter.format(nowAsDate);
        System.out.println("nowFullMonthName = " + nowFullMonthName);

        //now in a different timezone. e.g.: 06:49 05-09-2020
        System.out.println(ZoneId.getAvailableZoneIds());
        formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        String nowInDiffTimezone = formatter.format(LocalDateTime.now(ZoneId.of("US/Pacific")));
        System.out.println("nowInDiffTimezone = " + nowInDiffTimezone);

        //current day of the month as number. e.g.: 5
        int dayOfMonth = nowAsDate.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        //name of the current day of the week in upper case. e.g.: SATURDAY
        DayOfWeek dayOfWeek = nowAsDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        //day of the year as number. e.g.: 249
        int dayOfYear = nowAsDate.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);

        //name of month of the year in upper case. e.g.: SEPTEMBER
        Month month = nowAsDate.getMonth();
        System.out.println("month = " + month);

        //month as number. e.g.: 9
        int monthValue = nowAsDate.getMonthValue();
        System.out.println("monthValue = " + monthValue);

        //tomorrow as date. e.g.: 2020-09-06
        LocalDate tomorrow = nowAsDate.plusDays(1);
        System.out.println("tomorrow = " + tomorrow);

        //24 hours from today (tomorrow at this time). e.g.: 2020-09-06T20:30:34.117929100
        LocalDateTime _24HoursFromNow = nowAsDateTime.plusDays(1);
        System.out.println("_24HoursFromNow = " + _24HoursFromNow);

        //yesterday as date. e.g.: 2020-09-04
        LocalDate yesterday = nowAsDate.minusDays(1);
        System.out.println("yesterday = " + yesterday);

        //24 hours ago as date time. e.g.: 2020-09-04T20:30:34.117929100
        LocalDateTime _24HoursAgo = nowAsDateTime.minusDays(1);
        System.out.println("_24HoursAgo = " + _24HoursAgo);

        //3 months from now. e.g.: 2020-12-05
        LocalDate _3MonthsFromNow = nowAsDate.plusMonths(3);
        System.out.println("_3MonthsFromNow = " + _3MonthsFromNow);

        //2 years ago. e.g.: 2018-09-05
        LocalDate _2YearsAgo = nowAsDate.minusYears(2);
        System.out.println("_2YearsAgo = " + _2YearsAgo);

        //2 years ago date time. e.g.: 2018-09-05T20:30:34.117929100
        LocalDateTime _2YearsAgoDateTime = nowAsDateTime.minusYears(2);
        System.out.println("_2YearsAgoDateTime = " + _2YearsAgoDateTime);

        //tomorrow at 00:00. e.g.: 06-09-2020 00:00:00
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tomorrowStartOfDay = formatter.format(nowAsDate.plusDays(1).atStartOfDay());
        System.out.println("tomorrowStartOfDay = " + tomorrowStartOfDay);

        //yesterday at 23:00. e.g.: 04-09-2020 23:20:00
        LocalDateTime tomorrowAt23 = nowAsDateTime.plusDays(1).withHour(23).withMinute(20).withSecond(0);
        System.out.println("formatter.format(tomorrowAt23) = " + formatter.format(tomorrowAt23));

        //number of days in the current month. e.g.: 30
        int lengthOf = nowAsDate.lengthOfMonth();
        System.out.println("lengthOf = " + lengthOf);

        //date of the last day of the month. e.g.: 2020-09-30
        LocalDate lastDayOfMonth = nowAsDate.withDayOfMonth(lengthOf);
        System.out.println("lastDayOfMonth = " + lastDayOfMonth);

        //date of the previous Monday (excluding today if today is also
        // Monday). e.g.: 2020-08-31
        LocalDate previousTue = nowAsDate.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));
        System.out.println("previousTue = " + previousTue);

        //date of next or same Saturday. e.g.: 2020-09-05
        LocalDate nextSameTue = nowAsDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println("nextSameTue = " + nextSameTue);

        //day of first day of the year. e.g.: FRIDAY
        LocalDate firstDayOfNextYear = nowAsDate.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("firstDayOfNextYear = " + firstDayOfNextYear.getDayOfWeek());

        //is date1 after date2 as boolean
        boolean after = previousTue.isAfter(nextSameTue);
        System.out.println("after = " + after);

        //is date1 before date2 as boolean
        boolean before = previousTue.isBefore(nextSameTue);
        System.out.println("before = " + before);

        //are date1 and date2 equal
        boolean equal = previousTue.isEqual(nextSameTue);
        System.out.println("equal = " + equal);

        //are datetime1 and datetime2 equal

    }
}
