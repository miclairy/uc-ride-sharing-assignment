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


}
