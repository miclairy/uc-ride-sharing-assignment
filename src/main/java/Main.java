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

    private static Gson gson = new GsonBuilder().create();

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

    public static void save(Object toSave) throws IOException {
        Writer writer = new OutputStreamWriter(new FileOutputStream("src/main/resources/data.json"), "UTF-8");
        gson.toJson(toSave, writer);
        writer.close();

    }
}
