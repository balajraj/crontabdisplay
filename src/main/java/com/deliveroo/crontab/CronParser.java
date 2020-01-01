package com.deliveroo.crontab;

public abstract class CronParser {


    String commonRegex = "(\\*)?(\\d+)?(\\d+[,|-]\\d+)?";

    public static final String highrange = "greater than allowed limit,higher limit is:";
    public static final String lowrange = "lesser than allowed limit,lower limit is:";
    public static final String multiple = "invalid multiple in minute";
    public boolean validate(String input) {
        if(input.matches(commonRegex) ){
            return true;
        }
        return false;
    }

    public String returnDisplayString(String input, int highNumber, int lowNumber) throws InvalidRangeException {
        StringBuffer result = new StringBuffer();
        if(input.equals("*")) {
            for(int i=lowNumber; i <=highNumber; ++i) {
                result.append(i).append(" ");
            }
        }
        else {
            if(input.contains(",")) {
                String[] parts = input.split(",");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                throwException(start,lowNumber,highNumber);
                throwException(end,lowNumber,highNumber);
                result.append(start).append(" ").append(end);
            }
            else if( input.contains("-")) {
                String[] parts = input.split("-");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                throwException(start,lowNumber,highNumber);
                throwException(end,lowNumber,highNumber);
                for(int i=1; i <=end; ++i) {
                    result.append(i).append(" ");
                }
            }
            else {
                int quanity = Integer.parseInt(input);
                throwException(quanity,lowNumber,highNumber);
                result.append(quanity);
            }

        }
        return result.toString().trim();
    }

    public void throwException(int type, int lowNumber, int highNumber) throws InvalidRangeException {
        if( type < 0) {
            throw new InvalidRangeException(lowrange + " "+lowNumber);
        }
        if( type > 23) {
            throw new InvalidRangeException(highrange+" "+ highNumber);
        }

    }

}
