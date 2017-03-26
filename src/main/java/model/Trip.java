package model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by clbmi on 26/03/2017.
 */
public class Trip {

    Route route;
    String direction;
    Boolean recurrent;
    ArrayList<DayOfWeek> days;
    Car car;
    HashMap<StopPoint, Integer> stopTimes = new HashMap<>();
    GregorianCalendar expirationDate;

    public Trip(Route route, String direction, Boolean recurrent, Car car) {
        this.route = route;
        this.direction = direction;
        this.recurrent = recurrent;
        this.car = car;
    }

    public void setDays(ArrayList<DayOfWeek> days) {
        if (recurrent) {
            this.days = days;
        }
    }

    public void setTimeForStopPoint(StopPoint stopPoint, int time) {
        stopTimes.put(stopPoint, time);
    }

    public void setExpirationDate(GregorianCalendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Route getRoute() {
        return route;
    }

    public ArrayList<DayOfWeek> getDays() {
        return days;
    }

    public HashMap<StopPoint, Integer> getStopTimes() {
        return stopTimes;
    }

    public GregorianCalendar getExpirationDate() {
        return expirationDate;
    }
}
