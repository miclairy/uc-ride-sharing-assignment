package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Car;
import model.Data;
import model.StopPoint;

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

    void goToScene(String fxml, Car car) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        stage.setResizable(true);
        stage.setScene(new Scene(loader.load()));
        EditCarController controller = loader.getController();
        controller.setCar(car);
        stage.show();
    }

    void goToScene(String fxml, ObservableList<StopPoint> selectedStopPoints) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        stage.setResizable(true);
        stage.setScene(new Scene(loader.load()));
        if (Data.getDriverUser() != null){
            DriverController controller = loader.getController();
            controller.setSelected(selectedStopPoints);
        } else {
            PassengerController controller = loader.getController();
            controller.setSelected(selectedStopPoints);
        }
        stage.show();
    }

    void goToScene(String fxml, Boolean create) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        stage.setResizable(true);
        stage.setScene(new Scene(loader.load()));
        StopPointController controller = loader.getController();
        controller.setMode(create);
        stage.show();
    }
}
