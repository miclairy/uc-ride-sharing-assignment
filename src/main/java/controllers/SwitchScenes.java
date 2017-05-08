package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by cba62 on 8/05/17.
 */
public class SwitchScenes {

    private Stage stage;

    public SwitchScenes() {
        this.stage = LoginController.mainStage;
    }

    void goToScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stage.setResizable(true);
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }


}
