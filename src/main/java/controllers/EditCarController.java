package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Car;
import model.Data;
import model.Driver;

import java.io.IOException;
import java.net.URL;
import java.time.chrono.Chronology;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 19/05/2017.
 */
public class EditCarController {

    @FXML
    private Text type;
    @FXML
    private Text colour;
    @FXML
    private Text model;
    @FXML
    private Text licensePlate;
    @FXML
    private Text year;
    @FXML
    private Text numSeats;
    @FXML
    private DatePicker wofExpiry;
    @FXML
    private DatePicker registrationExpiry;
    @FXML
    private TextField efficiency;
    private Car car;


    private void inputInformation() {

        type.setText(car.getType());
        colour.setText(car.getColour());
        model.setText(car.getModel());
        licensePlate.setText(car.getPlates());
        year.setText(String.valueOf(car.getYear()));
        numSeats.setText(String.valueOf(car.getNumSeats()));
        wofExpiry.setValue(car.getWofExpiry());
        registrationExpiry.setValue(car.getRegistrationExpiry());
        efficiency.setText(String.valueOf(car.getEfficiency()));
    }

    @FXML
    private void editCar() throws IOException {
        try{
            car.setEfficiency(Double.parseDouble(efficiency.getText()));
            car.setWofExpiration(wofExpiry.getValue());
            car.setRegistrationExpiry(registrationExpiry.getValue());
            SwitchScenes switchScenes = new SwitchScenes();
            switchScenes.goToScene("/driverMain.fxml");
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly");
            alert.setHeaderText("Efficiency can not be empty");
            alert.setContentText("Fill in all boxes.");
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

    public void setCar(Car car) {
        this.car = car;
        inputInformation();
    }
}
