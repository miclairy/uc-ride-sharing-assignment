import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import model.Data;
import model.Rss;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by samschofield on 7/03/17.
 */
public class Main extends Application {

    private final String saveLocation = "src/main/resources/data.json";

    public void start(Stage stage) throws Exception {

        Data.load("/data.json");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("UC RSS");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop(){
        try {
            Data.save(new Rss(), saveLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        Data.setDataListeners();
        launch(args);

    }



}
