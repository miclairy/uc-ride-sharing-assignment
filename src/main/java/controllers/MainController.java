package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Driver;

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

    Driver driverUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void becomeDriver(){
        driverUser = new Driver("");

    }

    public void registerCar(){

        //driver.addCar(car);
    }
}
