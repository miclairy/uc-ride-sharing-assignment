package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Created by clbmi on 26/04/2017.
 */
public class CreateAccountController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField uniId;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private Text createTypeAccount;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (MainController.makeDriver == true && createTypeAccount != null){
            createTypeAccount.setText("Create Driver Account");
        } else if (createTypeAccount != null) {
            createTypeAccount.setText("Create Passenger Account");
        }

    }


    @FXML
    public void storeBasicDetails() throws IOException {

        Passenger temp = new Passenger();

        if (temp.verifyEmail(email.getText()) && temp.verifyPassword(password1.getText(), password2.getText()) && phone.getText().matches("[0-9]+") &&
        uniId.getText().trim().length() > 0 && phone.getText().trim().length() > 6 && address.getText().trim().length() > 0) {
            Map<String, String> enteredInformation = new HashMap<>();
            enteredInformation.put("name", name.getText());
            enteredInformation.put("ucId", uniId.getText());
            enteredInformation.put("email", email.getText());
            enteredInformation.put("phone", phone.getText());
            enteredInformation.put("address", address.getText() + ", " + city.getText());

            if (MainController.makeDriver) {
                setNewDriver(enteredInformation);
            } else {
                setNewPassenger(enteredInformation);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly or wasn't valid");
            alert.setHeaderText("Please complete all boxes make sure passwords are the same");
            alert.setContentText("Fill in all boxes. Only university of canterbury emails are accepted");
            alert.showAndWait();
        }
    }

    private void setNewPassenger(Map<String, String> enteredInformation) throws IOException {
        Passenger newAccount = new Passenger();
        newAccount.setDetails(enteredInformation);
        newAccount.storePassword(password1.getText());
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/login.fxml");
        Data.addPassenger(newAccount);
    }

    private void setNewDriver(Map<String, String> enteredInformation) throws IOException {
        Driver newAccount = new Driver();
        newAccount.setDetails(enteredInformation);
        newAccount.storePassword(password1.getText());
        Data.setDriverUser(newAccount);
        Data.addDriver(newAccount);
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/registerLicense.fxml");

    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/pickDriverPassenger.fxml");
    }



}
