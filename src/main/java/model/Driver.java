package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Driver user class that can register cars and driver users around
 */
public class Driver extends Passenger{

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Route> routes = FXCollections.observableArrayList();
    private ObservableList<Trip> trips = FXCollections.observableArrayList();
    private ObservableList<Ride> rides = FXCollections.observableArrayList();
    private String grade;
    private License license;

    public Driver(String name) {
        this.setName(name);
    }

    public Driver() {
    }

    public void addCar(Car car){
        if (!cars.contains(car)) {
            cars.add(car);
        }
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

    public void createRoute(ObservableList<StopPoint> stopPoints, String name) throws InvalidDataException {
        if (!stopPoints.isEmpty()) {
            ArrayList<StopPoint> stops = new ArrayList<>();
            stops.addAll(stopPoints);
            Route route = new Route(stops, name);
            if (!routes.contains(route)) {
                routes.add(route);
            } else {
                return;
            }
        } else {
            throw new InvalidDataException();
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

    public String getGrade() {
        return grade;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (cars != null ? !cars.equals(driver.cars) : driver.cars != null) return false;
        if (routes != null ? !routes.equals(driver.routes) : driver.routes != null) return false;
        if (grade != null ? !grade.equals(driver.grade) : driver.grade != null) return false;
        return license != null ? license.equals(driver.license) : driver.license == null;
    }

    @Override
    public int hashCode() {
        int result = cars != null ? cars.hashCode() : 0;
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        return result;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public License getLicense() {
        return license;
    }

    public ObservableList<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }
}
