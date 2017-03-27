package controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by samschofield on 15/03/17.
 */
public class MainController implements Initializable {

    @FXML
    private Button driver;
    @FXML
    private Button registerCar;
    @FXML
    private Text userTypeText;
    @FXML
    private ListView<Car> registeredCars;
    @FXML
    private Button createStopPoint;
    @FXML
    private ListView<StopPoint> stopPoints;
    @FXML
    private Button createRoute;
    @FXML
    private Button clearSelection;
    @FXML
    private Accordion routesHolder;
    @FXML
    private Button makeTrip;

    public static Driver driverUser;

    private static Window mainStage;
    private static FXMLLoader controllerLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        controllerLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
        stopPoints.setItems(Data.stopPointsList);
        stopPoints.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        if (driverUser != null) {
            becomeDriver();
            String cars = "";
            for (Car car : driverUser.getCars()) {
                cars += car.toString();
            }
            registeredCars.setItems(driverUser.getCars());
        }

        populateRoutes();

    }

    public void becomeDriver(){
        if (driverUser == null) {
            driverUser = new Driver("");
        }
        registerCar.setVisible(true);
        userTypeText.setText("You are a Driver");
        driver.setVisible(false);
        createStopPoint.setVisible(true);
        makeTrip.setVisible(true);
        if (Data.stopPointsList.size() > 0) {
            createRoute.setVisible(true);
        }

    }

    private void newScene(String fxml){
        try {
            mainStage = registerCar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) registerCar.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root, 500, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public void registerCar(){
        newScene("/registerCar.fxml");
    }

    public void createStopPoint(){
        newScene("/createStopPoint.fxml");
    }

    public void makeTrip(){
        newScene("/createTrip.fxml");
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

    public static void mainScene() {
        //TODO set state of scene back to what it was
        Stage stage = (Stage) mainStage;
        stage.setResizable(false);
        Parent root = null;
        try {
            root = controllerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 500, 400));

        stage.show();

    }

    public void populateRoutes(){

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
}
