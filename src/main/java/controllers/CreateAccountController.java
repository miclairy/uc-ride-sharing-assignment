package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (MainController.makeDriver == true && createTypeAccount != null){
            createTypeAccount.setText("Create Driver Account");
        } else if (createTypeAccount != null) {
            createTypeAccount.setText("Create Passenger Account");
        }
        if (type != null){
            ObservableList<String> licenseTypes = FXCollections.observableArrayList();
            licenseTypes.add("Full");
            licenseTypes.add("Restricted");
            licenseTypes.add("Learner");
            licenseTypes.add("Full for 2 years");
            type.setItems(licenseTypes);
            type.getSelectionModel().select(0);
        }
    }


    @FXML
    public void storeBasicDetails() throws IOException {

        Account temp = new Account();

        if (temp.verifyEmail(email.getText()) && temp.verifyPassword(password1.getText(), password2.getText()) && phone.getText().matches("[0-9]+") &&
        uniId.getText().trim().length() > 0 && phone.getText().trim().length() > 6 && address.getText().trim().length() > 0) {
            Map<String, Object> enteredInformation = new HashMap<>();
            enteredInformation.put("name", name.getText());
            enteredInformation.put("ucId", uniId.getText());
            enteredInformation.put("email", email.getText());
            enteredInformation.put("phone", Long.parseLong(phone.getText()));
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

    private void setNewPassenger(Map<String, Object> enteredInformation) throws IOException {
        Passenger newAccount = new Passenger();
        newAccount.setDetails(enteredInformation);
        newAccount.storePassword(password1.getText());
        goToScreen("/login.fxml");
        Data.addPassenger(newAccount);
    }

    private void setNewDriver(Map<String, Object> enteredInformation) throws IOException {
        Driver newAccount = new Driver();
        newAccount.setDetails(enteredInformation);
        newAccount.storePassword(password1.getText());
        goToScreen( "/registerLicense.fxml");
        Data.setDriverUser(newAccount);
        Data.addDriver(newAccount);
    }

    public void goToScreen(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage;
            if (createTypeAccount != null) {
                stage = (Stage) createTypeAccount.getScene().getWindow();
            } else {
                stage = (Stage) number.getScene().getWindow();
            }
            stage.setResizable(true);
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        if (createTypeAccount != null) {
            Stage stage = (Stage) createTypeAccount.getScene().getWindow();
        } else {
            Stage stage = (Stage) number.getScene().getWindow();
        }
        MainController.mainScene();
    }

    public void registerLicense(){
        GregorianCalendar issued = new GregorianCalendar(issuedDate.getValue().getYear(), issuedDate.getValue().getMonthValue(),
                issuedDate.getValue().getDayOfMonth());
        GregorianCalendar expiry = new GregorianCalendar(expiryDate.getValue().getYear(), expiryDate.getValue().getMonthValue(),
                expiryDate.getValue().getDayOfMonth());
        if (number.getText().length() > 0) {
            License license = new License(type.getSelectionModel().getSelectedItem(), number.getText(), issued, expiry);
            if (license.verify()) {
                Data.getDriverUser().setLicense(license);
                Data.setDriverUser(null);
                goToScreen("/login.fxml");

            }
        }

    }


}
