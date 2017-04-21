package controllers;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Data;
import model.Rss;

import java.io.IOException;

public class MainController {

    @FXML
    Text become;

    public void becomeDriver(){
        newScene("/driverMain.fxml");
    }

    public void becomePassenger(){
        newScene("/passengerMain.fxml");
    }

    private void newScene(String fxml){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) become.getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    @FXML
    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    public void stop(){
        Rss toSave = new Rss();
        try {
            Data.save(toSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
