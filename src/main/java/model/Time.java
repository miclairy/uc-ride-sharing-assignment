package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by clbmi on 26/03/2017.
 */
public class Time {

    int hours;
    int minutes;
    String amPM;

    public Time(int hours, int minutes, String amPm) {
        this.hours = hours;
        this.minutes = minutes;
        this.amPM = amPm;
    }

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

    @Override
    public String toString() {
        String minuteStr = Integer.toString(minutes);
        String hourStr = Integer.toString(hours);
        if (minutes < 10){
            minuteStr = "0" + minutes;
        }
        if (hours < 10){
            hourStr = "0" + hours;
        }
        return hourStr + ":" + minuteStr + " " + amPM ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (hours != time.hours) return false;
        if (minutes != time.minutes) return false;
        return amPM != null ? amPM.equals(time.amPM) : time.amPM == null;

    }

    @Override
    public int hashCode() {
        int result = hours;
        result = 31 * result + minutes;
        result = 31 * result + (amPM != null ? amPM.hashCode() : 0);
        return result;
    }
}
