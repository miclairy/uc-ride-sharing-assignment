package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Data;
import model.Ride;
import model.StopPoint;
import model.Trip;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;


public class PassengerController implements Initializable{

    @FXML
    ListView<StopPoint> stopPoints;
    @FXML
    ListView<Ride> sharedRides;
    @FXML
    TextField stopPointSearch;
    @FXML
    VBox rideDetails;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stopPoints.setItems(Data.stopPointsList.sorted());
        sharedRides.setItems(Data.getSharedRides());
        stopPoints.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StopPoint>() {
            @Override
            public void changed(ObservableValue<? extends StopPoint> observable, StopPoint oldValue, StopPoint newValue) {
                populateRoutes(newValue);
            }
        });

        sharedRides.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ride>() {
            @Override
            public void changed(ObservableValue<? extends Ride> observable, Ride oldValue, Ride newValue) {
                setRideDetails(newValue);
            }
        });
    }

    public void searchStopPoints(){
        stopPoints.setItems(Data.stopPointsSearch(stopPointSearch.getText()));
    }

    private void populateRoutes(StopPoint stopPoint){
        ObservableList<Ride> result = FXCollections.observableArrayList();
        for (Ride ride : Data.getSharedRides()){
            if (ride.getTrip().getRoute().getStops().contains(stopPoint)){
                result.add(ride);
            }
        }
        sharedRides.setItems(result);
    }

    private void setRideDetails(Ride ride){

        if (ride != null) {
            Trip trip = ride.getTrip();
            rideDetails.getChildren().clear();

            rideDetails.getChildren().add(new Label("Car: " + trip.getCar()));
            rideDetails.getChildren().add(new Label("Direction: " + trip.getDirection()));
            if (trip.getRecurrent()) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
                rideDetails.getChildren().add(new Label("Occurs every: " + trip.getDays().toString()));
                rideDetails.getChildren().add(new Label("Expires: " + formatter.format(trip.getExpirationDate().getTime())));
                rideDetails.getChildren().add(new Label("Available Seats: " + ride.getAvailableSeats()));
            }

            TitledPane routePane = new TitledPane();
            routePane.setText(trip.getRoute().getName());
            ListView<String> routeStops = new ListView<>();
            ObservableList<String> stopPoints = FXCollections.observableArrayList();
            for (StopPoint stop : trip.getRoute().getStops()) {
                stopPoints.add(stop + " " + trip.getStopTimes().get(stop).toString());
            }
            routeStops.setItems(stopPoints);
            routePane.setContent(routeStops);

            rideDetails.getChildren().add(routePane);
        }
    }

    public void becomeDriver(){
        newScene("/driverMain.fxml");
    }

    private void newScene(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) stopPoints.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
