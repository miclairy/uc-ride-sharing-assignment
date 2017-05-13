package controllers;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.*;

import java.net.URL;
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
    private TableView<Ride> bookedRidesTable;
    @FXML
    private TableColumn<Ride, String> ridesCol;
    @FXML
    private TableColumn<Ride, String> rideStateCol;
    @FXML
    private Button cancelBooking;
    @FXML
    private Button book;

    private Ride viewingRide;
    private Passenger passenger;
    private ObservableList<Ride> rides = FXCollections.observableArrayList();
    private Map<Ride, Driver> driverRide = new HashMap<>();
    private ObservableList<Ride> bookedRides = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toFromUniCombo.getItems().add("To university");
        toFromUniCombo.getItems().add("From university");
        toFromUniCombo.getItems().add("All");
        toFromUniCombo.setValue("All");
        stopPoints.setItems(Data.stopPointsList.sorted());

        updateAvailableRides();
        sharedRides.setItems(rides.sorted());
        setUpRideTable();
        setSelectionListeners();
        notifyCancelledRide();

    }

    private void updateAvailableRides() {
        rides.clear();
        driverRide.clear();
        for (Driver driver : Data.drivers){
            for (Ride ride : driver.getRides()) {
                driverRide.put(ride, driver);
                if (ride.getRideState().equals(Ride.RideState.Running.name())) {
                    rides.add(ride);

                }
            }
        }
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
                Platform.runLater(() -> bookedRidesTable.getSelectionModel().clearSelection());
                setRideDetails(newValue);
                book.setVisible(true);
                cancelBooking.setVisible(false);
            }
        });

        bookedRidesTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ride>() {
            @Override
            public void changed(ObservableValue<? extends Ride> observable, Ride oldValue, Ride newValue) {
                Platform.runLater(() -> sharedRides.getSelectionModel().clearSelection());
                setRideDetails(newValue);
                book.setVisible(false);
                cancelBooking.setVisible(true);
            }
        });
    }

    private void setUpRideTable() {
        ridesCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("name")
        );
        rideStateCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("rideState")
        );

        updateBookedRides();
    }

    private void updateBookedRides() {
        bookedRides.clear();
        for (Driver driver : Data.drivers){
            for (Ride ride : driver.getRides()){
                if (ride.getPassengers().contains(Data.passengerUser)){
                    bookedRides.add(ride);
                }
            }
        }

        bookedRidesTable.setItems(bookedRides.sorted());
    }


    public void searchStopPoints(){
        stopPoints.setItems(Search.stopPointsSearch(stopPointSearch.getText()));
    }


    private void setRideDetails(Ride ride){
        viewingRide = ride;
        if (ride != null) {
            Trip trip = ride.getTrip();
            rideDetails.getChildren().clear();
            rideDetails.getChildren().add(new Label(driverRide.get(ride).toString() + ride.getDetails()));
            rideDetails.getChildren().add(new Label("Date: " + ride.getDate().toString()));
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

    public void bookRide(){
        if (viewingRide != null) {
            viewingRide.bookPassenger(driverRide.get(viewingRide), Data.passengerUser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Booked Ride");
            alert.setHeaderText("You have successfully booked a ride");
            alert.setContentText("You can only book the ride once");
            alert.showAndWait();
            if (viewingRide.getAvailableSeats() == 0) {
                rideDetails.getChildren().clear();
            } else {
                setRideDetails(viewingRide);
            }
            updateBookedRides();
            bookedRidesTable.setItems(bookedRides.sorted());
            updateAvailableRides();
        }
    }

    @FXML
    private void cancelBooking(){
        viewingRide.cancelPassenger(Data.passengerUser, "");
    }

    private void notifyCancelledRide(){
        for (Ride ride : bookedRides){
            if (ride.getRideState().equals(Ride.RideState.Cancelled.name()) &&
                    ride.getCancelationUnnotifiedPassengers().contains(Data.passengerUser)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cancellation");
                alert.setHeaderText("Driver Cancelled Ride");
                alert.setContentText("Driver cancelled ride " + ride.toString() + " because " + ride.getCancelationReason());
                alert.showAndWait();
                ride.notifiedPassenger(Data.passengerUser);
            }
        }
    }

    @FXML
    public void filterByToFromUni(){
        ObservableList<Ride> obResult = FXCollections.observableArrayList();
        Collection<Ride> filtered = new HashSet<>();
        if (!toFromUniCombo.getValue().equals("All")) {
            filtered = Search.filterRides(rides, toFromUniCombo.getValue());
        } else {
            filtered = rides.sorted();
        }
        ObservableList<Ride> onlyStopPointSelected = Search.ridesForStopPoint(rides, stopPoints.getSelectionModel().getSelectedItem());
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
