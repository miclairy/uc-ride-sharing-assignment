package model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalTime;
import java.util.*;


public class Ride implements Comparable<Ride> {

    public enum RideState{
        Done, Cancelled, Booked, Available
    }

    private Trip trip;
    private int availableSeats;
    private Set<Passenger> passengers = new HashSet<>();
    private Driver driver;
    private GregorianCalendar date;
    private RideState state;

    private SimpleStringProperty name;
    private SimpleStringProperty startDate;
    private SimpleStringProperty startTime;
    private SimpleStringProperty rideState;


    public Ride(Trip trip, int availableSeats, Driver driver, GregorianCalendar date) {
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
        this.driver = driver;
        this.date = date;
        changeRideState(RideState.Available);
        name = trip.getNameProperty();
        startDate = new SimpleStringProperty(date.toString());
        if (!trip.getStopTimes().isEmpty()) {
            List<LocalTime> times = new ArrayList<>(trip.getStopTimes().values());
            Collections.sort(times);
            String earliest = times.get(0).toString(); //TODO fix to string
            startTime = new SimpleStringProperty(earliest);
        } else {
            startTime = new SimpleStringProperty("not known");
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Trip getTrip() {
        return trip;
    }

    public String toString() {
        return trip.getName();
    }

    public void bookPassenger(Passenger passenger){
        if (availableSeats > 0 && !passengers.contains(passenger)) {
            passengers.add(passenger);
            availableSeats--;
            passenger.addRide(this);
        }
        if (availableSeats == 0){
            Data.getSharedRides().remove(this);
        }

    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public String getDetails() {
        String details = "Driver: " + driver + "\nGrade: " + driver.getGrade() + "\nCar: " + trip.getCar().toString() +
                "\n Route Length: " + trip.getLength().toMinutes() + "\nNumber of Stops: " + trip.getStopTimes().size() +
                "\nAvailable Seats: " + availableSeats;
        return details;
    }


    @Override
    public int compareTo(Ride o) {
        if (date.before(o.date)){
            return 1;
        } else if (date.after(o.date)) {
            return -1;
        }
        return 0;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public String getName() {
        return name.get();
    }


    public String getStartDate() {
        return startDate.get();
    }


    public String getStartTime() {
        return startTime.get();
    }


    public String getRideState() {
        return rideState.get();
    }

    public void changeRideState(RideState newState) {
        state = newState;
        rideState = new SimpleStringProperty(state.name());
    }

    public Driver getDriver() {
        return driver;
    }
}
