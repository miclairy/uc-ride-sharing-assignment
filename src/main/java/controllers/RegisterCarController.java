package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Car;

import java.io.IOException;

/**
 * Created by clbmi on 17/03/2017.
 */
public class RegisterCarController {

    @FXML
    private TextField type;
    @FXML
    private TextField colour;
    @FXML
    private TextField model;
    @FXML
    private TextField plate;
    @FXML
    private TextField year;
    @FXML
    private TextField numSeats;
    @FXML
    private Button register;
    @FXML
    private Button cancel;
    @FXML
    private DatePicker wofExpiry;
    @FXML
    private DatePicker registrationExpiry;
    @FXML
    private TextField efficiency;



    public void registerCar(){

        try {
            if (Integer.parseInt(year.getText()) > 0 && Integer.parseInt(numSeats.getText()) > 0) {
                Car newCar = new Car(type.getText(), colour.getText(), model.getText(), plate.getText(),
                        Integer.parseInt(year.getText()), Integer.parseInt(numSeats.getText()));
                newCar.setEfficiency(Double.parseDouble(efficiency.getText()));
                newCar.setWofExpiration(wofExpiry.getValue());
                newCar.setRegistrationExpiry(registrationExpiry.getValue());
                DriverController.driverUser.addCar(newCar);
                SwitchScenes switchScenes = new SwitchScenes();
                switchScenes.goToScene("/driverMain.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information was entered incorrectly");
                alert.setHeaderText("Year and number of seats must be greater than 0");
                alert.setContentText("");
                alert.showAndWait();
            }
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly");
            alert.setHeaderText("Please complete all the information");
            alert.setContentText("Fill in all boxes. Year and number of plates have to be numbers");
            alert.showAndWait();
        }

    }

    public void cancel(){
        SwitchScenes switchScenes = new SwitchScenes();
        try {
            switchScenes.goToScene("/driverMain.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
