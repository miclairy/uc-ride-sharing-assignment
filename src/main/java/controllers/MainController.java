package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Car;
import model.Data;
import model.Driver;
import model.StopPoint;

import java.io.IOException;
import java.net.URL;
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
    //@FXML
    //private ListView<Route> routes;

    public static Driver driverUser;

    private static Window mainStage;
    private static FXMLLoader controllerLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        controllerLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
        if (driverUser != null) {
            registerCar.setVisible(true);
            userTypeText.setText("You are a Driver");
            driver.setVisible(false);
            createStopPoint.setVisible(true);
            String cars = "";
            for (Car car : driverUser.getCars()) {
                cars += car.toString();
            }
            registeredCars.setItems(driverUser.getCars());
        }
        stopPoints.setItems(Data.stopPointsList);

    }

    public void becomeDriver(){
        driverUser = new Driver("");
        registerCar.setVisible(true);
        userTypeText.setText("You are a Driver");
        driver.setVisible(false);
        createStopPoint.setVisible(true);
    }

    public void registerCar(){

        try {
            mainStage = registerCar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/registerCar.fxml"));
            Stage stage = (Stage) registerCar.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 500, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createStopPoint(){
        try {
            mainStage = registerCar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/createStopPoint.fxml"));
            Stage stage = (Stage) registerCar.getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(new Scene(root, 500, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
}
