package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;

import java.net.URL;
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
    private ListView<Time> times;
    @FXML
    private CheckBox recurrency;
    @FXML
    private Label textDay;
    @FXML
    private Label txtExpiration;
    @FXML
    private DatePicker expiration;
    @FXML
    private TextField nameTxt;

    private HashMap<StopPoint, Time> stopTimes = new HashMap<StopPoint, Time>();
    private Driver driver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        driver = MainController.driverUser;

        routeCombo.getItems().addAll(driver.getRoutes());
        hoursSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12));
        minutesSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));
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
        Route routeForTrip = routeCombo.getValue();
        stopPointsList.setItems(FXCollections.observableArrayList(routeForTrip.getStops()));
        stopPointsList.setDisable(false);
        amPm.setDisable(false);
        amPm.getSelectionModel().select(0);
        setTime.setDisable(false);
    }

    public void setTime(){
        int minutes = minutesSpinner.getValue();
        int hours = hoursSpinner.getValue();
        Time time = new Time(hours, minutes, amPm.getValue());
        StopPoint stop = stopPointsList.getSelectionModel().getSelectedItem();
        stopTimes.put(stop, time);
        stopPointsList.getItems().remove(stop);
        doneStopPoints.getItems().add(stop);
        times.getItems().add(time);
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
    private void cancel(){
        MainController.mainScene();
    }

    @FXML
    private void createTrip(){
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
            ArrayList<String> days = new ArrayList<>();
            if (trip.getRecurrent()) {
                days.add(daysCombo.getValue());
                trip.setDays(days);
                trip.setExpirationDate(new GregorianCalendar(expiration.getValue().getYear(), expiration.getValue().getMonthValue(),
                        expiration.getValue().getDayOfMonth()));
            }
            trip.setStopTimes(stopTimes);
            trip.setName(nameTxt.getText());
            driver.getTrips().add(trip);

            MainController.mainScene();
        }

    }

}