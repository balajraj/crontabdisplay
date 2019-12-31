package com.deliveroo.crontab;

public class DayOfWeekParser extends CronParser {
    public String returnDisplayString(String input) throws InvalidRangeException {
        if(!validate(input)) {
            throw new InvalidRangeException("invalid data passed in dow field");
        }
        return returnDisplayString(input,7,1);
    }
}
