package com.deliveroo.crontab;

public class MinParser extends CronParser {


    public String returnDisplayString(String input) throws InvalidRangeException {
        if(!validate(input)) {
            throw new InvalidRangeException("invalid data passed in minute field");
        }
        return returnDisplayString(input,59,0);
    }



}
