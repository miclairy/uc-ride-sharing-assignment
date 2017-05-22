package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Data;
import model.License;

import java.io.IOException;
import java.net.URL;
import java.time.chrono.Chronology;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 19/05/2017.
 */
public class RegisterLicenseController implements Initializable{

    @FXML private DatePicker issuedDate;
    @FXML private DatePicker expiryDate;
    @FXML private TextField number;
    @FXML private ComboBox<String> type;
    @FXML private Text title;
    private  License license;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> licenseTypes = FXCollections.observableArrayList();
        licenseTypes.add("Full");
        licenseTypes.add("Restricted");
        licenseTypes.add("Learner");
        licenseTypes.add("Full for 2 years");
        type.setItems(licenseTypes);
        type.getSelectionModel().select(0);

        license = Data.getDriverUser().getLicense();
        if (license != null){
            title.setText("Edit License");
            issuedDate.setValue(license.getIssued());
            expiryDate.setValue(license.getExpiry());
            number.setText(license.getNumber());
            type.getSelectionModel().select(license.getType());
        }

    }

    @FXML
    private void saveLicense() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        if (license == null){
            registerLicense();
            Data.setDriverUser(null);
            if (registerLicense()) {
                switchScenes.goToScene("/login.fxml");
            }
        } else {
            Data.getDriverUser().setLicense(null);
            if (registerLicense()) {
                switchScenes.goToScene("/driverMain.fxml");
            }
        }
    }


    private boolean registerLicense(){

        if (number.getText().length() > 0) {
            License license = new License(type.getSelectionModel().getSelectedItem(), number.getText(),
                    issuedDate.getValue(), expiryDate.getValue());
            if (license.verify()) {
                Data.getDriverUser().setLicense(license);
                return true;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Must have a full license");
        alert.setContentText("You must have a full license to carry passengers");
        alert.showAndWait();
        return false;

    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        if (license == null && Data.passengerUser == null) {
            switchScenes.goToScene("/pickDriverPassenger.fxml");
        } else if (Data.passengerUser != null){
            switchScenes.goToScene("/passengerMain.fxml");
        } else {
            switchScenes.goToScene("/driverMain.fxml");
        }
    }

}
