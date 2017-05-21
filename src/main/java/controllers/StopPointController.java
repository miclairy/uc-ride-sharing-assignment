package controllers;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.Data;
import model.Search;
import model.StopPoint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import static com.lynden.gmapsfx.javascript.object.MapTypeIdEnum.ROADMAP;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPointController implements Initializable, MapComponentInitializedListener {

    @FXML private TextField number;
    @FXML private TextField street;
    @FXML private TextField suburb;
    @FXML private Text title;
    @FXML private GoogleMapView mapView;
    @FXML private GoogleMap map;
    @FXML private ListView stopPointsList;
    @FXML private Text numberLabel;
    @FXML private Text streetLabel;
    @FXML private Text suburbLabel;
    @FXML private Text createAddress;
    @FXML private Label searchLabel;
    @FXML private TextField searchField;
    private boolean createStopPoint = true;
    private MapOptions mapOptions;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
        stopPointsList.setItems(Data.stopPointsList.sorted());
        stopPointsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private void hideCreationOptions(){
        title.setText("Search and select stop points");
        createAddress.setVisible(false);
        numberLabel.setVisible(false);
        streetLabel.setVisible(false);
        suburbLabel.setVisible(false);
        number.setVisible(false);
        street.setVisible(false);
        suburb.setVisible(false);
    }

    public void makeOrSelectStopPoint() throws IOException {
        if (createStopPoint) {
            makeStopPoint();
        } else {
            selectStopPoint();
        }
    }

    private void selectStopPoint() throws IOException {
        ObservableList selectedStops = stopPointsList.getSelectionModel().getSelectedItems();
        SwitchScenes switchScenes = new SwitchScenes();
        String newScene;
        if (Data.getDriverUser() != null) {
            newScene = "/driverMain.fxml";
        } else {
            newScene = "/passengerMain.fxml";
        }
        if (selectedStops.isEmpty()){
            switchScenes.goToScene(newScene);
        } else {
            switchScenes.goToScene(newScene, selectedStops);
        }
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

    @FXML
    private void search(){
        ObservableList<StopPoint> searchResult = Search.stopPointsSearch(searchField.getText());
        stopPointsList.setItems(searchResult);
        filterMarkers(searchResult);
    }

    private void filterMarkers(ObservableList<StopPoint> searchResult) {
        for (StopPoint stop : Data.stopPoints){
            stop.hideMarker(map);
            if (searchResult.contains(stop) || searchResult.isEmpty()){
                Marker marker = stop.restoreMarker();
                map.addMarker(marker);
            }
        }
    }

    public void cancel() throws IOException {
        SwitchScenes switchScenes = new SwitchScenes();
        if (Data.getDriverUser() != null) {
            switchScenes.goToScene("/driverMain.fxml");
        } else {
            switchScenes.goToScene("/passengerMain.fxml");
        }
    }

    @Override
    public void mapInitialized() {
        mapOptions = new MapOptions();
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
        addAllStopPointMarkers();
    }

    private void addAllStopPointMarkers() {
        final String apiKey = "AIzaSyAUC7URAPnPNNPhcsCLLZgAJ4KpB9SFXvQ";
        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
        for (StopPoint stopPoint : Data.stopPoints) {
            MarkerOptions markerOptions = new MarkerOptions();
            try {
                GeocodingApiRequest request = new GeocodingApiRequest(context);
                GeocodingResult[] result = request.address(stopPoint.getAddress()).await();
                LatLong latLon = new LatLong(result[0].geometry.location.lat, result[0].geometry.location.lng);
                markerOptions.position(latLon).visible(true).title(stopPoint.getAddress());
                Marker marker = new Marker(markerOptions);
                stopPoint.storeMarker(marker, markerOptions);
                map.addMarker(marker);
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void setMode(Boolean create) {
        createStopPoint = create;
        if (!create){
            hideCreationOptions();
        }
    }
}
