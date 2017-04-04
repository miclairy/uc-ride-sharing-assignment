package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

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
}
