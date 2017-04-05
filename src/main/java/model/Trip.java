package model;

import javafx.beans.property.SimpleStringProperty;

import java.util.*;


public class Trip {

    private Route route;
    private String direction;
    private Boolean recurrent;
    private Set<Integer> days = new HashSet<>();
    private Car car;
    private HashMap<StopPoint, Time> stopTimes = new HashMap<>();
    private GregorianCalendar expirationDate;
    private SimpleStringProperty name;
    private boolean shared = false;

    public Trip(Route route, String direction, Boolean recurrent, Car car) {
        this.route = route;
        this.direction = direction;
        this.recurrent = recurrent;
        this.car = car;
    }

    public void setDays(Set<Integer> days) {
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

    public Set<Integer> getDays() {
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
        this.name = new SimpleStringProperty(name);
    }

    public SimpleStringProperty getName() {
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
        return  name.getValue();
    }

    public void share(int seats, Driver driver, GregorianCalendar date) {
        int count = 0;
        if (recurrent) {
            for (Integer day : days) {
                date.add(GregorianCalendar.WEEK_OF_YEAR, -count);
                while (date.getTime().before(expirationDate.getTime())) {

                    while (date.get(Calendar.DAY_OF_WEEK) != day){
                        date.add(Calendar.DAY_OF_WEEK, 1);
                    }
                    GregorianCalendar tripDate = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                                                date.get(Calendar.DAY_OF_MONTH));
                    Ride ride = new Ride(this, seats, driver, tripDate);
                    shared = true;
                    Data.getSharedRides().add(ride);
                    date.add(GregorianCalendar.WEEK_OF_YEAR, 1);
                    count++;
                }
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
        Collections.sort(times);
        for (Time time : times) {
            length += Math.abs(length - time.getTotalSeconds());
        }
        int hours = length / 3600;
        int remainder = length - hours * 3600;
        int minutes = remainder / 60;
        Time timeLen = new Time(hours - times.get(0).getHours(), minutes - times.get(0).getMinutes(), "");
        return timeLen;
    }
}
