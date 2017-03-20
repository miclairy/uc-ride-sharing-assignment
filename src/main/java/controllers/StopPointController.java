package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.StopPoint;

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
        if (suburb.getText().isEmpty()) {
            MainController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText());
        } else {
            MainController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText(), suburb.getText());
        }
        MainController.mainScene();
    }

    public void cancel(){
        MainController.mainScene();
    }

}
