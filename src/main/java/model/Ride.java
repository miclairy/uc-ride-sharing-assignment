package model;

import com.google.maps.errors.ApiException;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class Ride implements Comparable<Ride> {

    public enum RideState{
        Done, Cancelled, Running, Full
    }

    private Trip trip;
    private int availableSeats;
    private Set<Passenger> passengers = new HashSet<>();
    private LocalDate date;
    private RideState state;
    private LocalTime time;
    private HashMap<String, String> passengerCancellationReasons = new HashMap<>();
    private String cancelationReason;
    private Set<Passenger> cancelationUnnotifiedPassengers = new HashSet<>();
    private Set<Passenger> newCancellations;

    private SimpleStringProperty name;
    private SimpleStringProperty startDate;
    private SimpleStringProperty startTime;
    private SimpleStringProperty rideState;


    public Ride(Trip trip, int availableSeats, LocalDate date) {
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
        this.date = date;
        newCancellations = new HashSet<>();

        changeRideState(RideState.Running);
        name = trip.getNameProperty();
        startDate = new SimpleStringProperty(date.toString());
        if (!trip.getStopTimes().isEmpty()) {
            List<LocalTime> times = new ArrayList<>(trip.getStopTimes().values());
            Collections.sort(times);
            time = times.get(0);
            String earliest = times.get(0).toString();
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

    public boolean bookPassenger(Driver driver, Passenger passenger){
        if (availableSeats > 0) {
            if (passengers.add(passenger)){
                availableSeats--;
            }
        }
        if (availableSeats == 0){
            changeRideState(RideState.Full);
            return false;
        }
        return true;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public String getDetails() throws InterruptedException, ApiException, IOException {
        return "\nCar: " + trip.getCar().toString() + "\nDirection: " + trip.getDirection() +
                "\nNumber of Stops: " + trip.getStopTimes().size() + "\nAvailable Seats: " + availableSeats
                 + "\nCost: $" + String.format( "%.2f", trip.calculateCostPerPassenger());
    }


    @Override
    public int compareTo(Ride o) {
        int compare = date.compareTo(o.getDate());
        if (compare == 0){
            compare = time.compareTo(o.time);
        }
        return compare;
    }

    public LocalDate getDate() {
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

    public LocalTime getTime() {
        return time;
    }

    public String getRideState() {
        if (Data.passengerUser != null &&
                passengerCancellationReasons.keySet().contains((String) Data.passengerUser.getDetails().get("email"))){
            return "Booking Cancelled";
        }
        return rideState.get();
    }

    private void changeRideState(RideState newState) {
        state = newState;
        rideState = new SimpleStringProperty(state.name());
    }

    public void cancelRide(String reason) {
        rideState = new SimpleStringProperty(RideState.Cancelled.name());
        cancelationReason = reason;
        cancelationUnnotifiedPassengers.addAll(passengers);
    }

    public String getCancelationReason() {
        return cancelationReason;
    }

    public Set<Passenger> getCancelationUnnotifiedPassengers() {
        return cancelationUnnotifiedPassengers;
    }

    public void notifiedPassenger(Passenger passenger){
        cancelationUnnotifiedPassengers.remove(passenger);
    }

    public void cancelPassenger(Passenger passenger, String reason){
        passengers.remove(passenger);
        availableSeats += 1;
        changeRideState(RideState.Running);
        newCancellations.add(passenger);
        passengerCancellationReasons.put((String) passenger.getDetails().get("email"), reason);
    }

    public HashMap<Passenger, String> notifyDriver() {

        if (!newCancellations.isEmpty()) {
            HashMap<Passenger, String> cancelled = new HashMap<>();
            for (Passenger passenger : newCancellations) {
                cancelled.put(passenger, passengerCancellationReasons.get((String) passenger.getDetails().get("email")));
            }
            newCancellations.clear();
            return cancelled;
        }
        return new HashMap<>();
    }

    public HashMap<String, String> getPassengerCancellationReasons() {
        return passengerCancellationReasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (availableSeats != ride.availableSeats) return false;
        if (!trip.equals(ride.trip)) return false;
        if (passengers != null ? !passengers.equals(ride.passengers) : ride.passengers != null) return false;
        if (!date.equals(ride.date)) return false;
        if (!time.equals(ride.time)) return false;
        if (startDate != null ? !startDate.getValue().equals(ride.startDate.getValue()) : ride.startDate != null) return false;
        return startTime != null ? startTime.getValue().equals(ride.startTime.getValue()) : ride.startTime == null;
    }

    @Override
    public int hashCode() {
        int result = trip.hashCode();
        result = 31 * result + availableSeats;
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
