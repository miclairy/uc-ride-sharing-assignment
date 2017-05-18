package controllers;

import com.google.maps.errors.ApiException;
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
import javafx.stage.Window;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class DriverController implements Initializable {


    @FXML private ListView<Car> registeredCars;
    @FXML private ListView<StopPoint> stopPoints;
    @FXML private Accordion routesHolder;
    @FXML private Accordion tripsHolder;
    @FXML private TextField stopPointSearch;
    @FXML private TableView<Ride> ridesTable;
    @FXML private TableColumn<Ride, String> rideNameCol;
    @FXML private TableColumn<Ride, String> rideDateCol;
    @FXML private TableColumn<Ride, String> rideTimeCol;
    @FXML private TableColumn<Ride, String> rideStateCol;
    @FXML private Button cancelRide;
    @FXML private Text userDetails;

    static Driver driverUser;
    static boolean noftifed = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        driverUser = Data.getDriverUser();
        userDetails.setText(driverUser.toString());
        stopPoints.setItems(Data.stopPointsList.sorted());
        stopPoints.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        String cars = "";
        for (Car car : driverUser.getCars()) {
            cars += car.toString();
        }
        registeredCars.setItems(driverUser.getCars());
        setUpRideTable();

        Set<ExpiryNotifactions.Expired> notify = ExpiryNotifactions.checkNotifyUser(driverUser);
        notifyUser(notify);
        populateRoutes();
        try {
            populateTrips();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setUpRideTable() {
        rideNameCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("name")
        );
        rideStateCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("rideState")
        );
        rideTimeCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("startTime")
        );
        rideDateCol.setCellValueFactory(
                new PropertyValueFactory<Ride,String>("startDate")
        );

        ridesTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Ride>() {
            @Override
            public void changed(ObservableValue<? extends Ride> observable, Ride oldValue, Ride newValue) {
                cancelRide.setVisible(true);
            }
        });

        ridesTable.setItems(Data.getDriverUser().getRides().sorted());
    }


    private void notifyUser(Set<ExpiryNotifactions.Expired> notify) {

        if (!notify.isEmpty() && !noftifed) {
            StringBuilder items = new StringBuilder();
            for (ExpiryNotifactions.Expired notification : notify) {
                items.append(notification.name().toLowerCase()).append(", ");
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Details are going to expire");
            alert.setHeaderText("Your " + items + "are going to expire");
            alert.setContentText("Please update and renew your " + items + "so you can still carry passengers");
            alert.showAndWait();
            noftifed = true;
        }

        for (Ride ride : Data.getDriverUser().getRides()){
            HashMap<Passenger, String> cancelledPassengers = ride.notifyDriver();
            if (!cancelledPassengers.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Passengers have cancelled");
                alert.setHeaderText("Passengers have cancelled on " + ride);
                String reasons = "";
                for (Passenger passenger : cancelledPassengers.keySet()){
                    reasons += passenger.getName() + " " + cancelledPassengers.get(passenger) + ", ";
                }
                alert.setContentText(reasons);
                alert.showAndWait();
            }
        }

    }

    public void registerCar(){
        SwitchScenes switchScenes = new SwitchScenes();
        try {
            switchScenes.goToScene("/registerCar.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createStopPoint(){
        SwitchScenes switchScenes = new SwitchScenes();
        try {
            switchScenes.goToScene("/createStopPoint.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeTrip() throws IOException {
        if (driverUser.getCars().size() <= 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You need a car to make a trip");
            alert.setHeaderText("You must register a car to make a trip");
            alert.setContentText("Click register car then make a route so you can make a trip");
            alert.showAndWait();
        } else if (driverUser.getRoutes().size() <= 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You need a route to make a trip");
            alert.setHeaderText("You must make a route to make a trip");
            alert.setContentText("Click create route to make a route so you can make a trip");
            alert.showAndWait();
        } else {
            SwitchScenes switchScenes = new SwitchScenes();
            switchScenes.goToScene("/createTrip.fxml");
        }
    }

    public void createRoute(){
        ObservableList<StopPoint> selectedStops = stopPoints.getSelectionModel().getSelectedItems();
        if (selectedStops.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Select 1 or more stop point");
            alert.setHeaderText("You have not selected any stop points");
            alert.setContentText("Please select one or more stop points from the list");
            alert.showAndWait();
        } else {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Name Route");
            dialog.setHeaderText("Enter Name for Route");
            dialog.setContentText("Please enter a name for new route:");
            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()){
                TitledPane routePane = new TitledPane();
                String value = result.get();
                routePane.setText(value);
                driverUser.createRoute(selectedStops, value);
                ListView<StopPoint> routeStops = new ListView<>();
                routeStops.setItems(selectedStops);
                routePane.setContent(routeStops);
                routesHolder.getPanes().add(routePane);
            }
        }
    }

    public void clearSelection(){
        stopPoints.getSelectionModel().clearSelection();
    }

    private void populateRoutes(){

        if (driverUser != null) {
            for (Route route : driverUser.getRoutes()) {
                TitledPane routePane = new TitledPane();
                routePane.setText(route.getName());
                ListView<StopPoint> routeStops = new ListView<>();
                ObservableList<StopPoint> stopPoints = FXCollections.observableArrayList();
                stopPoints.addAll(route.getStops());
                routeStops.setItems(stopPoints);
                routePane.setContent(routeStops);
                routesHolder.getPanes().add(routePane);
            }
        }
    }

    private void populateTrips() throws InterruptedException, ApiException, IOException {
        if (driverUser != null){
            for (Trip trip : driverUser.getTrips()){
                TitledPane tripPane = new TitledPane();
                tripPane.setText(trip.getName());

                VBox infoHolder = new VBox();
                infoHolder.getChildren().add(new Label("Car: " + trip.getCar()));
                infoHolder.getChildren().add(new Label("Direction: " + trip.getDirection()));
                infoHolder.getChildren().add(new Label("Cost: $" + trip.calculateCostPerPassenger()));
                if (trip.getRecurrent()) {
                    SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");
                    String days = "";
                    for (DayOfWeek day : trip.getDays()){
                        days += day.getDisplayName(TextStyle.FULL, Locale.ENGLISH) + ", ";
                    }
                    infoHolder.getChildren().add(new Label("Occurs every: " + days));
                    infoHolder.getChildren().add(new Label("Expires: " + trip.getExpirationDate()));
                }

                tripPane.setContent(infoHolder);

                Button share = new Button("Share");
                infoHolder.getChildren().add(share);
                share.setOnAction(event -> {
                    shareRide(trip);
                });

                TitledPane routePane = new TitledPane();
                routePane.setText(trip.getRoute().getName());
                ListView<String> routeStops = new ListView<>();
                ObservableList<String> stopPoints = FXCollections.observableArrayList();
                for (StopPoint stop : trip.getRoute().getStops()){
                    stopPoints.add(stop + " " + trip.getStopTimes().get(stop.toString()));
                }
                routeStops.setItems(stopPoints);
                routePane.setContent(routeStops);

                infoHolder.getChildren().add(routePane);
                tripsHolder.getPanes().add(tripPane);
            }
        }
    }

    private void shareRide(Trip trip){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Share Trip");
        dialog.setHeaderText("Enter number of available seats");
        dialog.setContentText("Please enter the number of available seats:");
        Optional<String> seats = dialog.showAndWait();
        if (seats.isPresent()) {
            trip.share(Integer.parseInt(seats.get()), driverUser, LocalDate.now());
        }
    }

    @FXML
    private void cancelRide(){
        Ride ride = ridesTable.getSelectionModel().getSelectedItem();
        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("Cancel Ride");
        alert.setHeaderText("Are you sure you want to cancel the ride " + ride.toString());
        alert.setContentText("Why are you cancelling?");
        Optional<String> reason = alert.showAndWait();
        reason.ifPresent(name -> ride.cancelRide(reason.get()));
        ridesTable.setItems(Data.getDriverUser().getRides());

        if (ChronoUnit.DAYS.between(LocalDate.now(), ride.getDate()) <= 0 &&
                ChronoUnit.HOURS.between(LocalTime.now(), ride.getTime()) <= 2){
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("You may not be well reviewed");
            warningAlert.setHeaderText(null);
            warningAlert.setContentText("Passengers may not review you well as you cancelled your ride close " +
                    "to the time of the ride");
            warningAlert.showAndWait();
        }
    }

    public void stopPointsSearch(){
        stopPoints.setItems(Search.stopPointsSearch(stopPointSearch.getText()));
    }

    public void editAccount() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/editAccount.fxml");
    }

    public void updateLicense() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/registerLicense");
    }

}
