package controllers;

import com.google.maps.errors.ApiException;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
    @FXML private Text userDetails;
    @FXML private Button switchToDriver;
    @FXML private ImageView photo;


    private Ride viewingRide;
    private ObservableList<Ride> rides = FXCollections.observableArrayList();
    private Map<Ride, Driver> driverRide = new HashMap<>();
    private ObservableList<Ride> bookedRides = FXCollections.observableArrayList();
    private Passenger passenger;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toFromUniCombo.getItems().add("To university");
        toFromUniCombo.getItems().add("From university");
        toFromUniCombo.getItems().add("All");
        toFromUniCombo.setValue("All");
        stopPoints.setItems(Data.stopPointsList.sorted());
        if (Data.passengerUser != null) {
            passenger = Data.passengerUser;
            switchToDriver.setVisible(false);
        } else {
            passenger = Data.getDriverUser();
            switchToDriver.setVisible(true);
        }
        updateAvailableRides();
        sharedRides.setItems(rides.sorted());
        setUpRideTable();
        setSelectionListeners();
        notifyCancelledRide();

        userDetails.setText(passenger.toString());
        photo.setImage(new Image(passenger.getPhotoUrl()));

    }

    private void updateAvailableRides() {
        rides.clear();
        driverRide.clear();
        for (Driver driver : Data.drivers){
            for (Ride ride : driver.getRides()) {
                driverRide.put(ride, driver);
                if (ride.getRideState().equals(Ride.RideState.Running.name()) ||
                        ride.getRideState().equals("Booking Cancelled")) {
                    rides.add(ride);

                }
            }
        }
    }

    private void setSelectionListeners() {
        stopPoints.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> filterByToFromUni());

        sharedRides.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> bookedRidesTable.getSelectionModel().clearSelection());
            try {
                setRideDetails(newValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            book.setVisible(true);
            cancelBooking.setVisible(false);
        });

        bookedRidesTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> sharedRides.getSelectionModel().clearSelection());
            try {
                setRideDetails(newValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            book.setVisible(false);
            cancelBooking.setVisible(true);
        });
    }

    private void setUpRideTable() {
        ridesCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        rideStateCol.setCellValueFactory(
                new PropertyValueFactory<>("rideState")
        );

        updateBookedRides();
    }

    private void updateBookedRides() {
        bookedRides.clear();
        for (Driver driver : Data.drivers){
            for (Ride ride : driver.getRides()){
                if (ride.getPassengers().contains(passenger)){
                    bookedRides.add(ride);
                }
                if (ride.getPassengerCancellationReasons().containsKey(passenger.getDetails().get("email"))){
                    bookedRides.add(ride);
                }
            }
        }

        bookedRidesTable.setItems(bookedRides.sorted());
    }


    public void searchStopPoints(){
        stopPoints.setItems(Search.stopPointsSearch(stopPointSearch.getText()));
    }


    private void setRideDetails(Ride ride) throws InterruptedException, ApiException, IOException {
        viewingRide = ride;
        if (ride != null) {
            Trip trip = ride.getTrip();
            rideDetails.getChildren().clear();
            AnchorPane detailsHolder = new AnchorPane();
            detailsHolder.autosize();
            detailsHolder.getChildren().add(new Label(driverRide.get(ride).getName() + " " + ride.getDetails() +
                                            "\nDate: " + ride.getDate().toString()));
            TitledPane routePane = new TitledPane();
            routePane.setText(trip.getRoute().getName());
            ListView<String> routeStops = new ListView<>();
            ObservableList<String> stopPoints = FXCollections.observableArrayList();
            for (StopPoint stop : trip.getRoute().getStops()) {
                stopPoints.add(stop + " " + trip.getStopTimes().get(stop.toString()).toString());
            }
            routeStops.setItems(stopPoints);
            routePane.setContent(routeStops);

            rideDetails.getChildren().add(detailsHolder);
            rideDetails.getChildren().add(routePane);
        }
    }

    public void bookRide(){
        if (viewingRide != null) {
            if (!passenger.equals(driverRide.get(viewingRide))) {
                viewingRide.bookPassenger(driverRide.get(viewingRide), passenger);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Booked Ride");
                alert.setHeaderText("You have successfully booked a ride");
                alert.setContentText("You can only book the ride once");
                alert.showAndWait();
                if (viewingRide.getAvailableSeats() == 0) {
                    rideDetails.getChildren().clear();
                } else {
                    try {
                        setRideDetails(viewingRide);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ApiException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                updateBookedRides();
                bookedRidesTable.setItems(bookedRides.sorted());
                updateAvailableRides();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tried to book your own ride");
            alert.setHeaderText("You can't book your own ride");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelBooking(){

        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Cancel Ride");
        alert.setHeaderText("Are you sure you want to cancel the booking on " + viewingRide.toString());
        alert.setContentText("Why are you cancelling?");
        Optional<String> reason = alert.showAndWait();
        reason.ifPresent(name -> viewingRide.cancelPassenger(passenger, reason.get()));

        if (ChronoUnit.DAYS.between(LocalDate.now(), viewingRide.getDate()) <= 0 &&
                ChronoUnit.HOURS.between(LocalTime.now(), viewingRide.getTime()) <= 2){
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("You may not be well reviewed");
            warningAlert.setHeaderText(null);
            warningAlert.setContentText("Drivers may not review you well as you cancelled your ride close " +
                    "to the time of the ride");
            warningAlert.showAndWait();
        }
        updateBookedRides();

    }

    private void notifyCancelledRide(){
        for (Ride ride : bookedRides){
            if (ride.getRideState().equals(Ride.RideState.Cancelled.name()) &&
                    ride.getCancelationUnnotifiedPassengers().contains(passenger)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cancellation");
                alert.setHeaderText("Driver Cancelled Ride");
                alert.setContentText("Driver cancelled ride " + ride.toString() + " because " + ride.getCancelationReason());
                alert.showAndWait();
                ride.notifiedPassenger(passenger);
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

        if (stopPoints.getSelectionModel().getSelectedItem() != null){
            for (Ride anOnlyStopPointSelected : onlyStopPointSelected) {
                if (filtered.contains(anOnlyStopPointSelected)) {
                    obResult.add(anOnlyStopPointSelected);
                }
            }
        } else {
            obResult.addAll(filtered);
        }
        sharedRides.setItems(obResult.sorted());

    }

    @FXML
    private void editAccount() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/editAccount.fxml");
    }

    public void setSelected(ObservableList<StopPoint> selectedStopPoints) {
        stopPoints.getSelectionModel().clearSelection();
        for (StopPoint stop : selectedStopPoints){
            stopPoints.getSelectionModel().select(stop);
        }
        filterByToFromUni();
    }

    public void select() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/createStopPoint.fxml", false);
    }

    @FXML
    private void goToDriver() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        if (Data.getDriverUser() != null){
            switchScenes.goToScene("/driverMain.fxml");
        } else {
            switchScenes.goToScene("/registerLicense.fxml");
        }
    }
}
