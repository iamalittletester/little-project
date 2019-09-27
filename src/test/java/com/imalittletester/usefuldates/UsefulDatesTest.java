package com.imalittletester.usefuldates;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class UsefulDatesTest {


    @Test
    void getVariousDates() {
        //get current date; e.g. 2019-09-22
        LocalDate currentDate = LocalDate.now();
        System.out.println("CurrentDate = " + currentDate);
        //get current day of month; e.g. 22
        System.out.println("Current day of month = " + currentDate.getDayOfMonth());
        //get name of current day of the week in upper case; e.g. SUNDAY
        System.out.println("Name of current day of week = " + currentDate.getDayOfWeek());
        //get name of current month in upper case; e.g. SEPTEMBER
        System.out.println("Name of current month = " + currentDate.getMonth());
        //get current month as number; e.g. 9 (September is the 9th month of the year)
        System.out.println("Index of current month = " + currentDate.getMonthValue());

        //get tomorrow as date; e.g. if today is 2019-09-22 then return 2019-09-23
        System.out.println("Tomorrow = " + currentDate.plusDays(1));
        //get yesterday as date; e.g. if today is 2019-09-22 then return 2019-09-21
        System.out.println("Yesterday = " + currentDate.minusDays(1));
        //get the date three months from now; e.g. if today is 2019-09-22 then return 2019-12-22
        System.out.println("Three months from today = " + currentDate.plusMonths(3));
        //get the date three months ago; e.g. if today is 2019-09-22 then return 2019-06-22
        System.out.println("Three months ago = " + currentDate.minusMonths(3));
        //get this date a year from now; e.g. if today is 2019-09-22 then return 2020-09-22
        System.out.println("A year from today = " + currentDate.plusYears(1));
        //get this date a year ago; e.g. if today is 2019-09-22 then return 2018-09-22
        System.out.println("A year ago = " + currentDate.minusYears(1));

        //get how many days the current month has; e.g. for September returns 30
        System.out.println("How many days there are in the current month = " + currentDate.lengthOfMonth());
        //set date to the 3rd of the current month; e.g. if today is 2019-09-22 then return 2019-09-03
        System.out.println("The third day of the current month = " + currentDate.withDayOfMonth(3));
        //set the date to the last day of the current month; e.g. if today is 2019-09-22 then return 2019-09-30
        System.out.println("The last day of the current month = " + currentDate.withDayOfMonth(currentDate.lengthOfMonth()));
    }

    @Test
    void formatDates() {
        LocalDate currentDate = LocalDate.now().withDayOfMonth(22).minusWeeks(1);
        System.out.println("currentDate = " + currentDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedCurrentDate = currentDate.format(formatter);
        System.out.println("Formatted current date = " + formattedCurrentDate);
    }

}
