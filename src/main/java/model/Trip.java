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
    ArrayList<String> days;
    Car car;
    HashMap<StopPoint, Time> stopTimes = new HashMap<>();
    GregorianCalendar expirationDate;
    String name;

    public Trip(Route route, String direction, Boolean recurrent, Car car) {
        this.route = route;
        this.direction = direction;
        this.recurrent = recurrent;
        this.car = car;
    }

    public void setDays(ArrayList<String> days) {
        if (recurrent) {
            this.days = days;
        }
    }

    public void setTimeForStopPoint(StopPoint stopPoint, Time time) {
        stopTimes.put(stopPoint, time);
    }

    public void setExpirationDate(GregorianCalendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Route getRoute() {
        return route;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public HashMap<StopPoint, Time> getStopTimes() {
        return stopTimes;
    }

    public GregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    public void setStopTimes(HashMap<StopPoint, Time> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
