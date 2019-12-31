package com.deliveroo.crontab;

public class DayOfMonthParser extends CronParser {

    public String returnDisplayString(String input) throws InvalidRangeException {
        if(!validate(input)) {
            throw new InvalidRangeException("invalid data passed in dom field");
        }
        return returnDisplayString(input,31,1);
    }
}
