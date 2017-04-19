package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clbmi on 19/04/2017.
 */
public class Rss {
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Trip> trips = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<StopPoint> stopPoints = new ArrayList<>();

    public Rss(){
        stopPoints = Data.stopPointsList;
        drivers = Data.drivers;
        passengers = Data.passengers;

        for (Driver driver : drivers){
            cars.addAll(driver.getCars());
            routes.addAll(driver.getRoutes());
            trips.addAll(driver.getTrips());

        }
    }


}
