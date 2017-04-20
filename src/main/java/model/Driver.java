package model;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Driver user class that can register cars and driver passengers around
 */
public class Driver {

    private String name;
    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Route> routes = FXCollections.observableArrayList();
    private ObservableList<Trip> trips = FXCollections.observableArrayList();
    private String grade;

    public Driver(String name) {
        this.name = name;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public ObservableList<Car> getCars() {
        return cars;
    }

    public void createStopPoint(int number, String address){
        StopPoint stopPoint = new StopPoint(number, address);
        Data.stopPoints.add(stopPoint);
    }

    public void createStopPoint(int number, String address, String suburb){
        StopPoint stopPoint = new StopPoint(number, address, suburb);
        Data.stopPoints.add(stopPoint);
    }

    public void createRoute(ObservableList<StopPoint> stopPoints, String name) {
        ArrayList<StopPoint> stops = new ArrayList<>();
        stops.addAll(stopPoints);
        Route route = new Route(stops, name);
        if (!routes.contains(route)) {
            routes.add(route);
        } else {
            return;
        }
    }

    public ObservableList<Route> getRoutes() {
        return routes;
    }

    public ObservableList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ObservableList<Trip> trips) {
        this.trips = trips;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (name != null ? !name.equals(driver.name) : driver.name != null) return false;
        if (cars != null ? !cars.equals(driver.cars) : driver.cars != null) return false;
        if (routes != null ? !routes.equals(driver.routes) : driver.routes != null) return false;
        if (trips != null ? !trips.equals(driver.trips) : driver.trips != null) return false;
        return grade != null ? grade.equals(driver.grade) : driver.grade == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        result = 31 * result + (trips != null ? trips.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }
}
