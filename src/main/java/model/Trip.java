package model;

import javafx.beans.property.SimpleStringProperty;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class Trip {

    private Route route;
    private String direction;
    private Boolean recurrent;
    private Set<DayOfWeek> days = new HashSet<>();
    private Car car;
    private HashMap<String, LocalTime> stopTimes = new HashMap<>();
    private LocalDate expirationDate;
    private SimpleStringProperty name;
    private boolean shared = false;

    public Trip(Route route, String direction, Boolean recurrent, Car car) {
        this.route = route;
        this.direction = direction;
        this.recurrent = recurrent;
        this.car = car;
    }

    public void setDays(Set<DayOfWeek> days) {
        if (recurrent) {
            this.days = days;
        }
    }

    public void setTimeForStopPoint(StopPoint stopPoint, LocalTime time) {
        stopTimes.put(stopPoint.toString(), time);
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Route getRoute() {
        return route;
    }

    public Set<DayOfWeek> getDays() {
        return days;
    }

    public HashMap<String, LocalTime> getStopTimes() {
        return stopTimes;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setStopTimes(HashMap<String, LocalTime> stopTimes) {
        this.stopTimes = stopTimes;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public SimpleStringProperty getNameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
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

    public void share(int seats, Driver driver, LocalDate date) {
        int count = 0;
        if (recurrent) {
            for (DayOfWeek day : days) {
                date = date.plusWeeks(-count);
                while (date.isBefore(expirationDate)) {

                    while (date.getDayOfWeek().getValue() != day.getValue()){
                        date = date.plusDays(1);
                    }
                    Ride ride = new Ride(this, seats, driver, date);
                    shared = true;
                    Data.getSharedRides().add(ride);
                    date = date.plusWeeks(1);
                    count++;
                }
            }
        } else {
            Ride ride = new Ride(this, seats, driver, date);
            shared = true;
            Data.getSharedRides().add(ride);
            date = date.plusWeeks(1);
        }
    }

    public boolean isShared() {
        return shared;
    }

    public Duration getLength() {
        List<LocalTime> times = new ArrayList<>(stopTimes.values());
        Collections.sort(times);
        LocalTime earliest = times.get(0);
        LocalTime latest = times.get(times.size() - 1);
        return Duration.between(earliest, latest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (!route.equals(trip.route)) return false;
        if (!direction.equals(trip.direction)) return false;
        if (recurrent != null ? !recurrent.equals(trip.recurrent) : trip.recurrent != null) return false;
        if (days != null ? !days.equals(trip.days) : trip.days != null) return false;
        if (!car.equals(trip.car)) return false;
        if (stopTimes != null ? !stopTimes.equals(trip.stopTimes) : trip.stopTimes != null) return false;
        if (expirationDate != null ? !expirationDate.equals(trip.expirationDate) : trip.expirationDate != null)
            return false;
        return name != null ? name.equals(trip.name) : trip.name == null;
    }

    @Override
    public int hashCode() {
        int result = route.hashCode();
        result = 31 * result + direction.hashCode();
        result = 31 * result + (recurrent != null ? recurrent.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + car.hashCode();
        result = 31 * result + (stopTimes != null ? stopTimes.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }


}
