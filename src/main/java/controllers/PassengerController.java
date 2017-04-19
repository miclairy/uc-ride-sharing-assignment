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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.ResourceBundle;


public class PassengerController implements Initializable{

    @FXML
    private ListView<StopPoint> stopPoints;
    @FXML
    private ListView<Ride> sharedRides;
    @FXML
    private TextField stopPointSearch;
    @FXML
    private VBox rideDetails;
    @FXML
    private ComboBox<String> toFromUniCombo;

    private Ride viewingRide;
    private Passenger passenger;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toFromUniCombo.getItems().add("To university");
        toFromUniCombo.getItems().add("From university");
        toFromUniCombo.getItems().add("All");
        toFromUniCombo.setValue("All");
        stopPoints.setItems(Data.stopPointsList.sorted());
        sharedRides.setItems(Data.getSharedRides().sorted());
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
        passenger = new Passenger();
        Data.passengers.add(passenger);

    }

    public void searchStopPoints(){
        stopPoints.setItems(Data.stopPointsSearch(stopPointSearch.getText()));
    }

    private void populateRoutes(StopPoint stopPoint){

        sharedRides.setItems(Data.ridesForStopPoint(stopPoint));
    }

    private void setRideDetails(Ride ride){
        viewingRide = ride;
        if (ride != null) {
            Trip trip = ride.getTrip();
            rideDetails.getChildren().clear();

            rideDetails.getChildren().add(new Label(ride.getDetails()));
            rideDetails.getChildren().add(new Label("Date: " + ride.getDate().getTime().toString()));
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

    public void bookRide(){
        viewingRide.bookPassenger(passenger);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Booked Ride");
        alert.setHeaderText("You have successfully booked a ride");
        alert.setContentText("You can only book the ride once");
        alert.showAndWait();
        if (viewingRide.getAvailableSeats() == 0){
            rideDetails.getChildren().clear();
        } else {
            setRideDetails(viewingRide);
        }
    }

    @FXML
    public void filterByToFromUni(){
        ObservableList<Ride> obResult = FXCollections.observableArrayList();
        Collection<Ride> result = new HashSet<>();
        if (!toFromUniCombo.getValue().equals("All")) {
            result = Data.filterRides(toFromUniCombo.getValue());
            obResult.addAll(result);
            sharedRides.setItems(obResult.sorted());
        } else {
            sharedRides.setItems(Data.getSharedRides().sorted());
        }



    }

}
