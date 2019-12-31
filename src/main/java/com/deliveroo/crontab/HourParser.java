package com.deliveroo.crontab;


public class HourParser extends CronParser {

    public static final String hourErrMessage = "invalid data passed in hour field";
    public HourParser() {

    }


    public String returnDisplayString(String input) throws InvalidRangeException {
       if(!validate(input)) {
           throw new InvalidRangeException(hourErrMessage);
       }
       return returnDisplayString(input,23,0);
    }

}
