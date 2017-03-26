package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import model.Driver;
import model.Route;
import model.StopPoint;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 26/03/2017.
 */
public class MakeTripController implements Initializable {

    @FXML
    private Accordion routesAnchor;
    @FXML
    private ComboBox<Integer> timesCombo;
    @FXML
    private ListView<StopPoint> stopPointsList;

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
    }


}
