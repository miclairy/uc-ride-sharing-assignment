package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clbmi on 19/04/2017.
 */
public class Rss {
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<StopPoint> stopPoints = new ArrayList<>();

    public Rss(){
        stopPoints = Data.stopPointsList;
        drivers = Data.drivers;
        passengers = Data.passengers;

    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }
}
