package com.deliveroo.crontab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HourDisplayStringTest {


    @Test
    public void testCorrectHourString() throws Exception {
        HourParser hvalidator =  new HourParser();
        String val = hvalidator.returnDisplayString("1,12");
        assertEquals("1 12",val);

        val = hvalidator.returnDisplayString("1-12");
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12",val);

        val = hvalidator.returnDisplayString("*");
        assertEquals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23",val);
    }

    @Test
    public void testInvalidHours() {
        HourParser hvalidator =  new HourParser();
        Exception exception = assertThrows(InvalidRangeException.class, () -> {
            hvalidator.returnDisplayString("1,33");
        });

        String actualMessage = exception.getMessage();

        assertEquals(true,actualMessage.contains(CronParser.highrange));

        exception = assertThrows(InvalidRangeException.class, () -> {
            hvalidator.returnDisplayString("-1,5");
        });
        actualMessage = exception.getMessage();

        assertEquals(true,actualMessage.contains(HourParser.hourErrMessage));

    }
}
