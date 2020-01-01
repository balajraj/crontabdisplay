package com.deliveroo.crontab;

public class MinParser extends CronParser {


    String minRegex = "(\\*)?(\\d+)?(\\*[\\/]\\d+)?(\\d+[,|-]\\d+)?";

    public String returnDisplayString(String input) throws InvalidRangeException {
        if(!validate(input)) {
            throw new InvalidRangeException("invalid data passed in minute field");
        }
        StringBuffer result = new StringBuffer();
        if(input.contains("/")) {

            String[] parts = input.split("/");
            int multiples = Integer.parseInt(parts[1]);
            int reminder = 60 % multiples;
            if(multiples == 0 || reminder !=0 ) {
                throw new InvalidRangeException(multiple);
            }
            for ( int i=0; i <60; i=i+multiples) {
                result.append(i).append(" ");
            }
        }
        if(result.toString().isEmpty()) {
            result.append(returnDisplayString(input,59,0));
        }
        return result.toString().trim();
    }

    public boolean validate(String input) {
        if(input.matches(minRegex) ){
            return true;
        }
        return false;
    }



}
