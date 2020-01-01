package com.deliveroo.crontab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourCronParserTest {

    @Test
    public void testCorrectHour() {
        HourParser hvalidator = new HourParser();
        boolean val = hvalidator.validate("1,12");
        assertEquals(true,val);

        val = hvalidator.validate("1-12");
        assertEquals(true,val);

        val = hvalidator.validate("*");
        assertEquals(true,val);

    }

    @Test
    public void testInCorrectHour() {
        HourParser hvalidator = new HourParser();
        boolean val = hvalidator.validate("1*abc");
        assertEquals(false,val);
    }
}
