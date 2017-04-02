package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Car;

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


    public void registerCar(){

        Stage stage = (Stage) register.getScene().getWindow();
        try {
            Car newCar = new Car(type.getText(), colour.getText(), model.getText(), plate.getText(),
                    Integer.parseInt(year.getText()), Integer.parseInt(numSeats.getText()));
            DriverController.driverUser.addCar(newCar);
            DriverController.mainScene();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly");
            alert.setHeaderText("Please complete all the information");
            alert.setContentText("Fill in all boxes. Year and number of plates have to be numbers");
            alert.showAndWait();
        }

    }

    public void cancel(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        DriverController.mainScene();
    }
}
