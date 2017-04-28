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
public class LoginController implements Initializable{

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Label incorrect;

    private static Window mainStage;
    private static FXMLLoader controllerLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controllerLoader = new FXMLLoader(getClass().getResource("/login.fxml"));

    }


    public void submit() throws IOException, DecoderException {
       boolean valid = PasswordUtils.login(email.getText(), password.getText());
       if (valid){
           Data.openAccount(email.getText());
           incorrect.setVisible(false);
       } else {
           incorrect.setVisible(true);
       }
       if (Data.driverUser != null){
           try {
               Parent root = FXMLLoader.load(getClass().getResource("/driverMain.fxml"));
               Stage stage = (Stage) email.getScene().getWindow();
               stage.setResizable(true);
               stage.setScene(new Scene(root, 1000, 700));
               stage.show();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
        if (Data.passengerUser != null){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/passengerMain.fxml"));
                Stage stage = (Stage) email.getScene().getWindow();
                stage.setResizable(true);
                stage.setScene(new Scene(root, 1000, 700));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void signUp(){
        mainStage = email.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/pickDriverPassenger.fxml"));
            Stage stage = (Stage) email.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void mainScene() {
        Stage stage = (Stage) mainStage;
        stage.setResizable(false);
        Parent root = null;
        try {
            root = controllerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root, 1000, 700));

        stage.show();

    }

}
