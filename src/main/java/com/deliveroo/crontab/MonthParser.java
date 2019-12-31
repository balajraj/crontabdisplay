package com.deliveroo.crontab;

public class MonthParser extends CronParser{
    public String returnDisplayString(String input) throws InvalidRangeException {
        if(!validate(input)) {
            throw new InvalidRangeException("invalid data passed in month field");
        }
        return returnDisplayString(input,12,1);
    }
}
