package controllers;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Data;
import model.StopPoint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.lynden.gmapsfx.javascript.object.MapTypeIdEnum.ROADMAP;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPointController implements Initializable, MapComponentInitializedListener {

    @FXML private TextField number;
    @FXML private TextField street;
    @FXML private TextField suburb;
    @FXML private GoogleMapView mapView;
    @FXML private GoogleMap map;
    @FXML private ListView stopPointsList;
    @FXML private Text numberLabel;
    @FXML private Text addressLabel;
    @FXML private Text streetLabel;
    @FXML private Text suburbLabel;
    @FXML private Text createAddress;
    @FXML private Label searchLabel;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
    }

    public void makeOrSelectStopPoint(){
        makeStopPoint();
    }

    private void makeStopPoint(){
        try {
            if (suburb.getText().isEmpty()) {
                DriverController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText());
            } else {
                DriverController.driverUser.createStopPoint(Integer.parseInt(number.getText()), street.getText(), suburb.getText());
            }
            SwitchScenes switchScenes = new SwitchScenes();
            switchScenes.goToScene("/driverMain.fxml");
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information was entered incorrectly");
            alert.setHeaderText("Please complete all the information");
            alert.setContentText("Fill in all boxes. House number must be a number");
            alert.showAndWait();
        }

    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        switchScenes.goToScene("/driverMain.fxml");
    }

    @Override
    public void mapInitialized() {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(-43.5235, 172.5839))
                .mapType(ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(12);

        map = mapView.createMap(mapOptions);
        addStopPointMarkers();
    }

    private void addStopPointMarkers() {
        final String apiKey = "AIzaSyAUC7URAPnPNNPhcsCLLZgAJ4KpB9SFXvQ";
        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);

        for (StopPoint stopPoint : Data.stopPoints) {
            MarkerOptions markerOptions = new MarkerOptions();
            try {
                GeocodingApiRequest request = new GeocodingApiRequest(context);
                GeocodingResult[] result = request.address(stopPoint.getAddress()).await();
                LatLong latLon = new LatLong(result[0].geometry.location.lat, result[0].geometry.location.lng);
                markerOptions.position(latLon).visible(true).title(stopPoint.getAddress());
                map.addMarker(new Marker(markerOptions));
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
