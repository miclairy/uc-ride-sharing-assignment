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

public class MainController {

    static boolean makeDriver = false;

    public void becomeDriver() throws IOException {
        makeDriver = true;
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/createAccount.fxml");

    }

    public void becomePassenger() throws IOException {
        makeDriver = false;
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/createAccount.fxml");
    }


    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/login.fxml");
    }


}
