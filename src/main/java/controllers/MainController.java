package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Car;
import model.Driver;

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
    private Text registeredCars;

    public static Driver driverUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void becomeDriver(){
        driverUser = new Driver("");
        registerCar.setVisible(true);
        userTypeText.setText("You are a Driver");
        driver.setVisible(false);
        String cars = "";
        for (Car car : driverUser.getCars()) {
            cars += car.toString();
        }
        registeredCars.setText(cars);
    }

    public void registerCar(){

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/registerCar.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root, 443, 429));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
