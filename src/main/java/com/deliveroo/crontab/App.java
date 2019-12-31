package com.deliveroo.crontab;

import org.apache.commons.cli.*;



public class App {

    private HourParser hourParser = new HourParser();
    private MinParser minParser = new MinParser();
    private DayOfMonthParser domParser = new DayOfMonthParser();
    private DayOfWeekParser dowParser = new DayOfWeekParser();
    private MonthParser monthParser = new MonthParser();

    public void parseAndDisplay (String min,String hour,String dayOfMonth,
                                 String month,String dayOfWeek,String command) throws Exception{

       StringBuffer display = new StringBuffer();
       String minDisplay =  "minute          "+minParser.returnDisplayString(min);
       display.append(minDisplay).append("\n");
       String hourDisplay = "hour            "+hourParser.returnDisplayString(hour);
       display.append(hourDisplay).append("\n");
       String domDisplay =  "day of month    "+domParser.returnDisplayString(dayOfMonth);
       display.append(domDisplay).append("\n");
       String monthDisp =   "month           "+monthParser.returnDisplayString(month);
       display.append(monthDisp).append("\n");
       String dowWeek =     "day of week     "+dowParser.returnDisplayString(dayOfWeek);
       display.append(dowWeek).append("\n");
       String cmdDisp =     "command         "+command;
       display.append(cmdDisp).append("\n");
       System.out.println(display);
    }

    public static void main(String[] args) {

        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse( options, args);
            String [] array = cmd.getArgs();
            if(array.length != 6) {
                System.out.println("missing command options min hour dom month dow cmd");
                System.exit(1);
            }
            App cronparser = new App();
            cronparser.parseAndDisplay(array[0],array[1],array[2],array[3],array[4],array[5]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
