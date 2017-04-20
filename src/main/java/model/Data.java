package model;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.io.*;
import java.util.*;
import java.util.List;


public class Data {

    public static ObservableSet<StopPoint> stopPoints = FXCollections.observableSet();
    public static ObservableList<StopPoint> stopPointsList = FXCollections.observableArrayList(stopPoints);
    private static ObservableList<Ride> sharedRides = FXCollections.observableArrayList();
    public static List<Driver> drivers = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    public static Gson gson = gsonBuilder.setPrettyPrinting().create();

    public static void setDataListeners() {
        SetChangeListener<StopPoint> listner = change -> {
            stopPointsList.clear();
            stopPointsList.addAll(stopPoints);
        };
        stopPoints.addListener(listner);
    }

    public static ObservableList<Ride> getSharedRides() {
        return sharedRides;
    }

    public ArrayList<StopPoint> getStopPoints() {
        return new ArrayList<>();
    }

    public static ObservableList<StopPoint> stopPointsSearch(String searchString) {
        Set<StopPoint> searchResult = new HashSet<>();
        if (searchString.isEmpty()) {
            return Data.stopPointsList.sorted();
        } else {
            for (StopPoint stopPoint : Data.stopPointsList.sorted()) {
                if (stopPoint.toString().toLowerCase().contains(searchString.toLowerCase())) {
                    searchResult.add(stopPoint);
                }
            }
            ObservableList<StopPoint> stops = FXCollections.observableArrayList();
            stops.addAll(searchResult);
            return stops.sorted();
        }
    }

    public static ObservableList<Ride> ridesForStopPoint(StopPoint stopPoint) {
        ObservableList<Ride> result = FXCollections.observableArrayList();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getRoute().getStops().contains(stopPoint)) {
                result.add(ride);
            }
        }
        return result;
    }


    public static Collection<Ride> filterRides(String filter) {
        Collection<Ride> result = new ArrayList<>();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getDirection().toLowerCase().equals(filter.toLowerCase())) {
                result.add(ride);
            }
        }
        return result;
    }

    public static void save(Object toSave) throws IOException {
        Writer writer = new OutputStreamWriter(new FileOutputStream("src/main/resources/data.json"), "UTF-8");
        gson.toJson(toSave, writer);
        writer.close();

    }

    public static void load() throws UnsupportedEncodingException {
        gsonBuilder.registerTypeAdapter(ObservableList.class, new DeserializeObservable());
        gson = gsonBuilder.setPrettyPrinting().create();
        Reader reader = new InputStreamReader(Data.class.getResourceAsStream("/data.json"), "UTF-8");
        Rss loaded = gson.fromJson(reader, Rss.class);
        drivers.clear();
        passengers.clear();
        stopPointsList.clear();
        drivers = loaded.getDrivers();
        passengers = loaded.getPassengers();
        stopPointsList.addAll(loaded.getStopPoints());
    }

}
