package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPointController {

    @FXML
    private TextField number;
    @FXML
    private TextField street;
    @FXML
    private TextField suburb;

    public void makeStopPoint(){
        try {
            if (suburb.getText().isEmpty()) {
                DriverController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText());
            } else {
                DriverController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText(), suburb.getText());
            }
            SwitchScenes switchScenes = new SwitchScenes();
            switchScenes.goToScene("/driverMain.fxml");
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly");
            alert.setHeaderText("Please complete all the information");
            alert.setContentText("Fill in all boxes. House number must be a number");
            alert.showAndWait();
        }

    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/driverMain.fxml");
    }

}
