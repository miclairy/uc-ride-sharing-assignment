package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.util.*;

/**
 * Created by clbmi on 26/03/2017.
 */
public class MakeTripController implements Initializable {

    @FXML
    private ComboBox<String> daysCombo;
    @FXML
    private ChoiceBox<Car> carCombo;
    @FXML
    private ListView<StopPoint> stopPointsList;
    @FXML
    private Spinner<Integer> hoursSpinner;
    @FXML
    private Spinner<Integer> minutesSpinner;
    @FXML
    private ChoiceBox<String> driectionPicker;
    @FXML
    private ChoiceBox<String> amPm;
    @FXML
    private ChoiceBox<Route> routeCombo;
    @FXML
    private Button setTime;
    @FXML
    private ListView<StopPoint> doneStopPoints;
    @FXML
    private ListView<LocalTime> times;
    @FXML
    private CheckBox recurrency;
    @FXML
    private Label textDay;
    @FXML
    private Label daysSelected;
    @FXML
    private Label txtExpiration;
    @FXML
    private DatePicker expiration;
    @FXML
    private TextField nameTxt;

    private HashMap<String, LocalTime> stopTimes = new HashMap<>();
    private Driver driver;
    private Set<String> days = new HashSet<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        driver = DriverController.driverUser;

        routeCombo.getItems().addAll(driver.getRoutes());
        hoursSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12));
        minutesSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 5, 5));
        amPm.getItems().add("AM");
        amPm.getItems().add("PM");
        driectionPicker.getItems().add("To University");
        driectionPicker.getItems().add("From University");
        List<String> daysList = Arrays.asList("Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        daysCombo.getItems().setAll(daysList);
        carCombo.getItems().addAll(driver.getCars());
        carCombo.setValue(driver.getCars().get(0));
        routeCombo.setValue(driver.getRoutes().get(0));
        driectionPicker.setValue("To University");
    }

    public void selectedRoute(){
        stopTimes.clear();
        doneStopPoints.getItems().clear();
        times.getItems().clear();
        Route routeForTrip = routeCombo.getValue();
        stopPointsList.setItems(FXCollections.observableArrayList(routeForTrip.getStops()));
        stopPointsList.setDisable(false);
        amPm.setDisable(false);
        amPm.getSelectionModel().select(0);
        setTime.setDisable(false);
    }

    public void setTime(){
        StopPoint stop = stopPointsList.getSelectionModel().getSelectedItem();
        if (stop != null) {
            int minutes = minutesSpinner.getValue();
            int hours = hoursSpinner.getValue();
            if (amPm.getValue().equals("PM")){
                hours += 12;
            }
            boolean valid = true;
            LocalTime time = LocalTime.of(hours, minutes);
            for (LocalTime storedTime : stopTimes.values()){
                if (time.equals(storedTime)){
                    valid = false;
                    Alert sameTimeAlert = new Alert(Alert.AlertType.ERROR);
                    sameTimeAlert.setHeaderText("Can't have a stop time at the same time as another stop");
                    sameTimeAlert.setContentText("Are you a magician? Can you be in two places at once? I thought not.");
                }
            }
            if (valid) {
                stopTimes.put(stop.toString(), time);
                stopPointsList.getItems().remove(stop);
                doneStopPoints.getItems().add(stop);
                times.getItems().add(LocalTime.of(hours, minutes));
            }
        }
    }

    public void recurrent(){
        if (recurrency.isSelected()){
            textDay.setDisable(false);
            txtExpiration.setDisable(false);
            daysCombo.setDisable(false);
            expiration.setDisable(false);
        } else {
            textDay.setDisable(true);
            txtExpiration.setDisable(true);
            daysCombo.setDisable(true);
            expiration.setDisable(true);
        }
    }

    @FXML
    private void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/driverMain.fxml");
    }

    @FXML
    private void createTrip() throws IOException {
        if (nameTxt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Enter Name for trip");
            alert.setHeaderText("Please enter a name for the trip");
            alert.setContentText("Fill in all boxes.");
            alert.showAndWait();
        } else if (stopPointsList.getItems().size() > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Some stops have no times");
            alert.setHeaderText("Please add times to remaining stops");
            alert.setContentText("Select the remaining stop points and give them stop times");
            alert.showAndWait();
        } else {
            Trip trip = new Trip(routeCombo.getValue(), driectionPicker.getValue(), recurrency.isSelected(), carCombo.getValue());

            if (trip.getRecurrent()) {

                if (days.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("No recurring day");
                    alert.setHeaderText("You have not chosen a day of the week that this re-occurs on");
                    alert.setContentText("In order for the tip to be recurrent then a recurring day must be chosen");
                    alert.showAndWait();
                } else {
                    for (String day : days) {
                        trip.getDays().add(DayOfWeek.valueOf(day.toUpperCase()));
                    }
                    try {
                        trip.validateExpirationDate(expiration.getValue());
                        finishMakingTrip(trip);
                    } catch (InvalidDataException e){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("No expiration date");
                        alert.setHeaderText("You have not chosen a valid expiration date");
                        alert.setContentText("In order for the tip to be recurrent then a \n expiration date must be chosen");
                        alert.showAndWait();
                    }


                }
            } else {
                finishMakingTrip(trip);
            }
        }

    }

    private void finishMakingTrip(Trip trip) throws IOException {
        trip.setStopTimes(stopTimes);
        trip.setName(nameTxt.getText());
        driver.addTrip(trip);

        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/driverMain.fxml");
    }


    public void addToDaysSelected(){
        days.add(daysCombo.getValue());
        daysSelected.setText(days.toString());
    }

}
