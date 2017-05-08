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
import java.util.*;


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
    @FXML
    private ListView<Ride> bookedRides;

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
        bookedRides.setItems(Data.passengerUser.getBookedRides());
        setSelectionListeners();
        passenger = new Passenger(); //so I can switch
        Data.addPassenger(passenger);

    }

    private void setSelectionListeners() {
        stopPoints.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StopPoint>() {
            @Override
            public void changed(ObservableValue<? extends StopPoint> observable, StopPoint oldValue, StopPoint newValue) {
                filterByToFromUni();

            }
        });

        sharedRides.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ride>() {
            @Override
            public void changed(ObservableValue<? extends Ride> observable, Ride oldValue, Ride newValue) {
                changeRideShown(newValue);
            }
        });

        bookedRides.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ride>() {
            @Override
            public void changed(ObservableValue<? extends Ride> observable, Ride oldValue, Ride newValue) {
                setRideDetails(newValue);
                sharedRides.getSelectionModel().clearSelection();

            }
        });
    }

    private void changeRideShown(Ride newValue) {
        setRideDetails(newValue);
        bookedRides.getSelectionModel().clearSelection();

    }

    public void searchStopPoints(){
        stopPoints.setItems(Search.stopPointsSearch(stopPointSearch.getText()));
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
                stopPoints.add(stop + " " + trip.getStopTimes().get(stop.toString()).toString());
            }
            routeStops.setItems(stopPoints);
            routePane.setContent(routeStops);

            rideDetails.getChildren().add(routePane);
        }
    }

    public void becomeDriver() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/driverMain.fxml");
    }


    public void bookRide(){
        viewingRide.bookPassenger(Data.passengerUser);
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
        bookedRides.setItems(Data.passengerUser.getBookedRides());
    }

    @FXML
    public void filterByToFromUni(){
        ObservableList<Ride> obResult = FXCollections.observableArrayList();
        Collection<Ride> filtered = new HashSet<>();
        if (!toFromUniCombo.getValue().equals("All")) {
            filtered = Search.filterRides(toFromUniCombo.getValue());
        } else {
            filtered = Data.getSharedRides().sorted();
        }
        ObservableList<Ride> onlyStopPointSelected = Search.ridesForStopPoint(stopPoints.getSelectionModel().getSelectedItem());
        if (!onlyStopPointSelected.isEmpty()){
            for (int i = 0; i < onlyStopPointSelected.size(); i++) {
                if (filtered.contains(onlyStopPointSelected.get(i))){
                    obResult.add(onlyStopPointSelected.get(i));
                }
            }
        } else {
            obResult.addAll(filtered);
        }

        sharedRides.setItems(obResult.sorted());

    }

}
