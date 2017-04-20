import javafx.application.Application;
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


    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pickDriverPassenger.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("UC RSS");
        stage.setScene(scene);
        stage.show();

    }

    public static void main( String[] args )
    {
        Data.setDataListeners();
        launch(args);

    }



}
