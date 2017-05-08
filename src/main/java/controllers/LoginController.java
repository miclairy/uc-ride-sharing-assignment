package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Data;
import model.PasswordUtils;
import org.apache.commons.codec.DecoderException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by clbmi on 26/04/2017.
 */
public class LoginController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrect;

    public static Stage mainStage;


    public void submit() throws IOException, DecoderException {
        mainStage = (Stage) email.getScene().getWindow();
       boolean valid = PasswordUtils.login(email.getText(), password.getText());
       if (valid){
           Data.openAccount(email.getText());
           incorrect.setVisible(false);
       } else {
           incorrect.setVisible(true);
       }
       if (Data.getDriverUser() != null){
           SwitchScenes switchScenes = new SwitchScenes();
           switchScenes.goToScene("/driverMain.fxml");
       }
        if (Data.passengerUser != null){
            SwitchScenes switchScenes = new SwitchScenes();
            switchScenes.goToScene("/passengerMain.fxml");
        }
    }

    @FXML
    public void signUp() throws IOException {
        mainStage = (Stage) email.getScene().getWindow();
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/pickDriverPassenger.fxml");
    }


}
