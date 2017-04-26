package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private TextField number;
    @FXML
    private ComboBox<String> type;
    @FXML
    private DatePicker issuedDate;
    @FXML
    private DatePicker expiryDate;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;

    private  Map<String, Object> enteredInformation = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (MainController.makeDriver == true && createTypeAccount != null){
            createTypeAccount.setText("Create Driver Account");
        } else if (createTypeAccount != null) {
            createTypeAccount.setText("Create Passenger Account");
        }
    }


    @FXML
    public void nextStep(){

        Account temp = new Account();
        if (temp.verifyEmail(email.getText()) && temp.verifyPassword(password1.getText(), password2.getText()) && phone.getText().matches("[0-9]+") &&
        uniId.getText().trim().length() > 0 && phone.getText().trim().length() > 6 && address.getText().trim().length() > 0) {
            enteredInformation.put("name", name.getText());
            enteredInformation.put("uniId", uniId.getText());
            enteredInformation.put("email", email.getText());
            enteredInformation.put("phone", Long.parseLong(phone.getText()));
            enteredInformation.put("address", address.getText() + ", " + city.getText());

            if (MainController.makeDriver) {
                goToScreen( "/registerLicense.fxml");
            } else {
                Passenger newAccount = new Passenger();
                newAccount.setDetails(enteredInformation);
                newAccount.storePassword(password1.getText());
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.setTitle("Login");
                    stage.setScene(new Scene(root, 443, 429));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                goToScreen("/passengerMain.fxml");
                Data.passengerUser = newAccount;
                Data.passengers.add(newAccount);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly or wasn't valid");
            alert.setHeaderText("Please complete all boxes make sure passwords are the same");
            alert.setContentText("Fill in all boxes. Only university of canterbury emails are accepted");
            alert.showAndWait();
        }
    }

    public void goToScreen(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) createTypeAccount.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        Stage stage = (Stage) createTypeAccount.getScene().getWindow();
        MainController.mainScene();
    }

    public void registerLicense(){
        GregorianCalendar issued = new GregorianCalendar(issuedDate.getValue().getYear(), issuedDate.getValue().getMonthValue(),
                issuedDate.getValue().getDayOfMonth());
        GregorianCalendar expiry = new GregorianCalendar(expiryDate.getValue().getYear(), expiryDate.getValue().getMonthValue(),
                expiryDate.getValue().getDayOfMonth());
        License license = new License(number.getText(), type.getSelectionModel().getSelectedItem(), issued, expiry);
        if (license.verify()){
            Driver newAccount = new Driver();
            newAccount.setDetails(enteredInformation);
            newAccount.setLicense(license);
            newAccount.storePassword(password1.getText());
            goToScreen("/driverMain.fxml");
            Data.driverUser = newAccount;
            Data.drivers.add(newAccount);
        }

    }


}
