# crontabdisplay
The project parses the command line and generates output string for a crontab.

The project contains a mvn pom file, hence this is can be conviniently imported to IDE like intellij or eclipse. The automated test cases can be run with mvn test command also. 

To run the program manually edit the run configurations in ide and run the com.deliveroo.crontab.App class which has the main method. The argument to be passed are */15 0 1,15 * 1-5 /usr/bin/find.  If there is less than 6 args then the message printed will be "missing command options min hour dom month dow cmd". 

There is pattern matching implemented to catch any unallowed pattern to avoid parsing data which is incorrect. The minute parser has exclusive pattern matching since it allowes multiples of minutes. The multiples is not supported for the other classes such as hour, day of week, day of month, and month, and they use common pattern. The classes are designed in such a way if any customisation required can be easily extended in future. 

There is also other range validation to check (min hour, max hour), (min minute, max minute) , (min day of week, max day of week), (min day of month, max day of month) and (min month, max month). Any number passed outside the valid range will be rejected with proper error message. 

# functionality not implemented
There are some corner cases for validation is not implemented and can be improved. Currently there is no check for the leap year, and febuary can have 28 days or 29 days accordingly. Also depending on the month days can vary from 30 or 31. The test coverage can be improved as well. 
