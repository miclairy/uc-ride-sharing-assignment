package model;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import java.io.IOException;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPoint {

    private int streetNumber;
    private String suburb;
    private String streetName;
    private String placeName;
    private transient Marker marker;
    private transient MarkerOptions markerOptions;
//    private static final String apiKey = "AIzaSyAUC7URAPnPNNPhcsCLLZgAJ4KpB9SFXvQ";
//    private static GeoApiContext context = new GeoApiContext();

    public StopPoint(int streetNumber, String streetName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
//        context.setApiKey(apiKey);
    }

    public StopPoint(int streetNumber, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.streetName = streetName;
    }

    public StopPoint(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopPoint stopPoint = (StopPoint) o;

        if (streetNumber != stopPoint.streetNumber) return false;
        if (suburb != null ? !suburb.equals(stopPoint.suburb) : stopPoint.suburb != null) return false;
        return streetName != null ? streetName.equals(stopPoint.streetName) : stopPoint.streetName == null;

    }

    @Override
    public int hashCode() {
        int result = streetNumber;
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = streetNumber + " " +
                streetName + " \n";
        if (!(suburb == null)) {
            str += " " + suburb;
        }
        return str;
    }

    public String getAddress() {
        if (placeName != null){
            return placeName;
        }
        return streetNumber + " " + streetName + " Christchurch";
    }


    public void hideMarker(GoogleMap map){
        if (marker != null) {
            map.removeMarker(marker);
            this.marker = null;
        }
    }

    public void storeMarker(Marker marker, MarkerOptions markerOptions) {
        this.marker = marker;
        this.markerOptions = markerOptions;
    }

    public Marker restoreMarker(){
        this.marker = new Marker(markerOptions);
        return marker;
    }

//    public Distance calculateDistance() throws InterruptedException, ApiException, IOException {
//
//        DistanceMatrixApiRequest distanceRequest = new DistanceMatrixApiRequest(context);
//        DistanceMatrix distance = distanceRequest.origins("University of Canterbury")
//                                                .destinations(streetNumber + " " + streetName + "Christchurch")
//                                                .mode(TravelMode.DRIVING)
//                                                .await();
//        return distance.rows[0].elements[0].distance;
//
//    }
}
