package controllers;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import model.Data;
import model.Rss;

import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class MainController implements Initializable {

    @FXML
    private Text become;

    private static Window mainStage;
    private static FXMLLoader controllerLoader;
    static boolean makeDriver = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controllerLoader = new FXMLLoader(getClass().getResource("/pickDriverPassenger.fxml"));

    }

    public void becomeDriver(){
        makeDriver = true;
        newScene("/createAccount.fxml");

    }

    public void becomePassenger(){
        makeDriver = false;
        newScene("/createAccount.fxml");
    }

    private void newScene(String fxml){
        try {
            mainStage = become.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) become.getScene().getWindow();
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
