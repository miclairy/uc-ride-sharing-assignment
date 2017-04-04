package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;


public class Trip {

    private Route route;
    private String direction;
    private Boolean recurrent;
    private ArrayList<String> days;
    private Car car;
    private HashMap<StopPoint, Time> stopTimes = new HashMap<>();
    private GregorianCalendar expirationDate;
    private String name;
    private boolean shared = false;

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

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public Boolean getRecurrent() {
        return recurrent;
    }

    public Car getCar() {
        return car;
    }


    @Override
    public String toString() {
        return  name;
    }

    public void share(int seats, Driver driver, GregorianCalendar date) {
        if (recurrent) {
            while (date.getTime().before(expirationDate.getTime())) {

                Ride ride = new Ride(this, seats, driver, date);
                shared = true;
                Data.getSharedRides().add(ride);
                date.add(GregorianCalendar.WEEK_OF_YEAR, 1);
            }
        } else {
            Ride ride = new Ride(this, seats, driver, date);
            shared = true;
            Data.getSharedRides().add(ride);
            date.add(GregorianCalendar.WEEK_OF_YEAR, 1);
        }
    }

    public boolean isShared() {
        return shared;
    }

    public Time getLength() {
        List<Time> times = new ArrayList<>(stopTimes.values());
        int length = 0;

        for (Time time : stopTimes.values()) {
            length += Math.abs(length - time.getTotalSeconds());
        }
        int hours = length / 3600;
        int remainder = length - hours * 3600;
        int minutes = remainder / 60;
        Time timeLen = new Time(hours - times.get(0).getHours(), minutes - times.get(0).getMinutes(), "");
        return timeLen;
    }
}
