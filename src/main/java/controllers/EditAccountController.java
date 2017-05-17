package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.Data;
import model.Passenger;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 17/05/2017.
 */
public class EditAccountController implements Initializable{

    @FXML private TextField name;
    @FXML private Text uniId;
    @FXML private Text email;
    @FXML private TextField phone;
    @FXML private TextField address;
    @FXML private PasswordField password1;
    @FXML private PasswordField password2;

    private Passenger user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //temp code

        if (Data.getDriverUser() != null){
            user = Data.getDriverUser();
        } else {
            user = Data.passengerUser;
        }
        Map<String, String> userDetails = user.getDetails();
        uniId.setText(userDetails.get("ucId"));
        email.setText(userDetails.get("email"));
        name.setText(userDetails.get("name"));
        phone.setText(userDetails.get("phone"));
        address.setText(userDetails.get("address"));

    }

    public void save() throws IOException {

        if (phone.getText().trim().length() > 6 && address.getText().trim().length() > 0 && !name.getText().isEmpty()) {

            Map<String, String> enteredInformation = new HashMap<>();
            enteredInformation.put("name", name.getText());
            enteredInformation.put("ucId", uniId.getText());
            enteredInformation.put("email", email.getText());
            enteredInformation.put("phone", phone.getText());
            enteredInformation.put("address", address.getText());
            user.setDetails(enteredInformation);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly or wasn't valid");
            alert.setHeaderText("Not inputs are allowed to be empty apart from passwords");
            alert.setContentText("Check passwords match if changing and there is something in each input");
            alert.showAndWait();
        }

        SwitchScenes switchScenes = new SwitchScenes();
        if (Data.getDriverUser() != null) {
            switchScenes.goToScene("/driverMain.fxml");
        } else {
            switchScenes.goToScene("/passengerMain.fxml");
        }

//        if (!password1.getText().isEmpty()){ TODO
//            if (user.verifyPassword(password1.getText(), password2.getText()){
//                user.storePassword(password1.getText());
//            }
//        }
    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        if (Data.getDriverUser() != null) {
            switchScenes.goToScene("/driverMain.fxml");
        } else {
            switchScenes.goToScene("/passengerMain.fxml");
        }
    }

}
