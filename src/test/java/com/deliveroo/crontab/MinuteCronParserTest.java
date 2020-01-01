package com.deliveroo.crontab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinuteCronParserTest {


    @Test
    public void testCorrectMin() {
        MinParser minParser = new MinParser();
        boolean val = minParser.validate("*/10");
        assertEquals(true,val);
    }

    @Test
    public void testDisplayString() throws Exception {
        MinParser minParser = new MinParser();
        String val = minParser.returnDisplayString("*/12");
        assertEquals("0 12 24 36 48",val);
    }
}
