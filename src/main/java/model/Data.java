package model;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import controllers.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.*;
import java.util.List;


public class Data extends Observable {

    public static ObservableSet<StopPoint> stopPoints = FXCollections.observableSet();
    public static ObservableList<StopPoint> stopPointsList = FXCollections.observableArrayList(stopPoints);
    public static List<Driver> drivers = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();
    private static Map<String, Driver> driverEmails = new HashMap<>();
    private static Map<String, Passenger> passengerEmails = new HashMap<>();
    private static GsonBuilder gsonBuilder = new GsonBuilder();
    public static Gson gson = gsonBuilder.setPrettyPrinting().create();

    private static Driver driverUser;
    public static Passenger passengerUser;

    public static void setDataListeners() {
        SetChangeListener<StopPoint> listener = change -> {
            stopPointsList.clear();
            stopPointsList.addAll(stopPoints);
        };
        stopPoints.addListener(listener);
    }

    public ArrayList<StopPoint> getStopPoints() {
        return new ArrayList<>();
    }

    public static void save(Object toSave, String fileName) throws IOException {
        gsonBuilder.registerTypeAdapter(ObservableList.class, new DeserializeObservable());
        gson = gsonBuilder.setPrettyPrinting().create();
        Writer writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
        gson.toJson(toSave, writer);
        writer.close();

    }

    public static void load(String fileName) throws UnsupportedEncodingException {
        gsonBuilder.registerTypeAdapter(ObservableList.class, new DeserializeObservable());
        gson = gsonBuilder.setPrettyPrinting().create();
        Reader reader = new InputStreamReader(Data.class.getResourceAsStream(fileName), "UTF-8");
        Rss loaded = gson.fromJson(reader, Rss.class);
        drivers.clear();
        passengers.clear();
        stopPointsList.clear();
        stopPoints.clear();
        for (Driver driver :loaded.getDrivers()){
            addDriver(driver);
        }
        for (Passenger passenger :loaded.getPassengers()){
            addPassenger(passenger);
        }
        stopPoints.addAll(loaded.getStopPoints());
    }

    public static void addPassenger(Passenger passenger){
        passengers.add(passenger);
        passengerEmails.put((String) passenger.getDetails().get("email"), passenger);
    }

    public static void addDriver(Driver driver){
        drivers.add(driver);
        driverEmails.put((String) driver.getDetails().get("email"), driver);
    }


    public static void openAccount(String email) {
        if (driverEmails.get(email) != null){
            driverUser = driverEmails.get(email);
        }
        if (passengerEmails.get(email) != null){
            passengerUser = passengerEmails.get(email);
        }
    }

    public static Driver getDriverUser() {
        return driverUser;
    }

    public static void setDriverUser(Driver driverUser) {
        Data.driverUser = driverUser;

    }
}
