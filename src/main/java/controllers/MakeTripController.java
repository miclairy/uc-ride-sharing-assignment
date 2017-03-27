package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.Driver;
import model.Route;
import model.StopPoint;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 26/03/2017.
 */
public class MakeTripController implements Initializable {

    @FXML
    private Accordion routesAnchor;
    @FXML
    private ComboBox<String> daysCombo;
    @FXML
    private ComboBox<Car> carsCombo;
    @FXML
    private ListView<StopPoint> stopPointsList;
    @FXML
    private Spinner<Integer> hoursSpinner;
    @FXML
    private Spinner<Integer> minutesSpinner;
    @FXML
    private ChoiceBox<String> amPm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Driver driver = MainController.driverUser;
        TitledPane routePane = new TitledPane();

        for (Route route: driver.getRoutes()) {
            ListView<StopPoint> routeStops = new ListView<>();
            ObservableList<StopPoint> stopPoints = FXCollections.observableArrayList();
            stopPoints.addAll(route.getStops());
            routeStops.setItems(stopPoints);
            routePane.setContent(routeStops);
            routePane.setText(route.getName());
            routesAnchor.getPanes().add(routePane);
        }

        hoursSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12));
        minutesSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59));
        amPm.getItems().add("AM");
        amPm.getItems().add("PM");
        List<String> daysList = Arrays.asList("Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        daysCombo.getItems().setAll(daysList);
        carsCombo.getItems().addAll(driver.getCars());
    }



}
