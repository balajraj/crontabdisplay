package com.deliveroo.crontab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourCronParserTest {


    private HourParser hvalidator;

    @BeforeEach
    public void initialize() {
        this.hvalidator = new HourParser();
    }

    @Test
    public void testCorrectHour() {
        boolean val = hvalidator.validate("1,12");
        assertEquals(true,val);

        val = hvalidator.validate("1-12");
        assertEquals(true,val);

        val = hvalidator.validate("*");
        assertEquals(true,val);

    }

    @Test
    public void testInCorrectHour() {
        boolean val = hvalidator.validate("1*abc");
        assertEquals(false,val);
    }
}
