package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by clbmi on 26/03/2017.
 */
public class TimeUtils {

    public static int monthToInt(String month){
        Date date = null;
        try {
            date = new SimpleDateFormat("MMMM").parse(month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int weekDayToInt(String day){
        Date date = null;
        try {
            date = new SimpleDateFormat("E").parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String intToDay(int day){
        List<String> weekDays = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
        return weekDays.get(day - 1);

    }

}
