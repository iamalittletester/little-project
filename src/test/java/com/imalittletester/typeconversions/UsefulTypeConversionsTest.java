package com.imalittletester.typeconversions;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsefulTypeConversionsTest {

    @Test
    void stringToInt() {
        int resultingInt = Integer.parseInt("6");
        assertEquals(10, resultingInt + 4);
    }

    @Test
    void intToString() {
        String resultingString = String.valueOf(200);
        assertEquals("2004", resultingString + 4);
    }

    @Test
    void stringToDouble() {
        double resultingDouble = Double.parseDouble("333.55");
        assertEquals(333.66, resultingDouble + 0.11);
    }

    @Test
    void doubleToString() {
        String resultingString = String.valueOf(333.55);
        assertEquals("333.550.11", resultingString + 0.11);
    }

    @Test
    void currentDateFormatted() {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("formattedDate = " + formattedDate);
        String formattedWithoutHour = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("formattedWithoutHour = " + formattedWithoutHour);
        String formattedFromMillis = new SimpleDateFormat("dd-MM-yy HH:mm").format(System.currentTimeMillis());
        System.out.println("formattedFromMillis = " + formattedFromMillis);
    }
}
