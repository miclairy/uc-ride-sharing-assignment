package model;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.Distance;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static java.util.Collections.min;


public class Trip {

    private static final double FUEL_PRICE = 2.15;

    private Route route;
    private String direction;
    private Boolean recurrent;
    private Set<DayOfWeek> days = new HashSet<>();
    private Car car;
    private Map<String, LocalTime> stopTimes = new HashMap<>();
    private LocalDate expirationDate;
    private SimpleStringProperty name;
    private boolean shared = false;
    private static final String apiKey = "AIzaSyAUC7URAPnPNNPhcsCLLZgAJ4KpB9SFXvQ";
    private static GeoApiContext context = new GeoApiContext();

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

    public Map<String, LocalTime> getStopTimes() {
        return stopTimes;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setStopTimes(Map<String, LocalTime> stopTimes) {
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
        return  name.getValue().toString();
    }

    public boolean share(int seats, Driver driver, LocalDate date) {
        LocalTime startTime = min(stopTimes.values());
        int count = 0;
        int dayCount = 0;
        if (recurrent) {
            for (DayOfWeek day : days) {
                date = date.minusWeeks(count);
                date = date.minusDays(dayCount);
                while (date.isBefore(expirationDate)) {
                    if (startTime.isBefore(LocalTime.now().plusHours(1)) && date.equals(LocalDate.now())) {
                        date = date.plusWeeks(1);
                        count += 1;
                    }
                    while (date.getDayOfWeek().getValue() != day.getValue()) {
                        date = date.plusDays(1);
                        dayCount++;
                    }
                    Ride ride = new Ride(this, seats, date);
                    driver.addRide(ride);
                    shared = true;
                    date = date.plusWeeks(1);
                    count++;
                }
            }
        } else {
            if (!startTime.isBefore(LocalTime.now().plusHours(1))) {
                Ride ride = new Ride(this, seats, date);
                driver.addRide(ride);
                shared = true;
            } else {
                return false;
            }
        }
        return true;
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

        if (shared != trip.isShared()) return false;
        if (!route.equals(trip.route)) return false;
        if (!direction.equals(trip.direction)) return false;
        if (recurrent != null ? !recurrent.equals(trip.recurrent) : trip.recurrent != null) return false;
        if (days != null ? !days.equals(trip.days) : trip.days != null) return false;
        if (!car.equals(trip.car)) return false;
        if (stopTimes != null ? !stopTimes.equals(trip.stopTimes) : trip.stopTimes != null) return false;
        return expirationDate != null ? expirationDate.equals(trip.expirationDate) : trip.expirationDate == null;
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
        result = 31 * result + (shared ? 1 : 0);
        return result;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }


    public double calculateCostPerPassenger() throws InterruptedException, ApiException, IOException {
        double totalm = 0;
        context.setApiKey(apiKey);
        String[] waypoints = new String[route.getStops().size() - 1];

        for (int i = 0; i < route.getStops().size() - 1; i ++){
            waypoints[i] = route.getStops().get(i + 1).getAddress();
        }
        DirectionsApiRequest distanceRequest = DirectionsApi.newRequest(context);
        DirectionsResult directionsResult = distanceRequest.destination("University Of Canterbury")
                .origin(route.getStops().get(0).getAddress())
                .waypoints(waypoints)
                .mode(TravelMode.DRIVING)
                .await();

        for (int i = 0; i < route.getStops().size(); i ++){

            Distance distance = directionsResult.routes[0].legs[i].distance;
            totalm += distance.inMeters;
        }

        double efficiencyPerKm = car.getEfficiency() / 100;
        return efficiencyPerKm * (totalm / 1000) * FUEL_PRICE;

    }



}
