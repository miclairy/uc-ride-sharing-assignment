package model;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;

import java.io.IOException;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPoint {

    private int streetNumber;
    private String suburb;
    private String streetName;
    private int distanceFromUni;
    private static final String apiKey = "AIzaSyAUC7URAPnPNNPhcsCLLZgAJ4KpB9SFXvQ";
    private static GeoApiContext context = new GeoApiContext();

    public StopPoint(int streetNumber, String streetName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        context.setApiKey(apiKey);
    }

    public StopPoint(int streetNumber, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.streetName = streetName;
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

    public Distance calculateDistance() throws InterruptedException, ApiException, IOException {

        DistanceMatrixApiRequest distanceRequest = new DistanceMatrixApiRequest(context);
        distanceRequest.origins("43.5235, 172.5839"); //uni lat long
        DistanceMatrix distance = distanceRequest.origins("University of Canterbury")
                                                .destinations(streetNumber + " " + streetName + "Christchurch")
                                                .mode(TravelMode.DRIVING)
                                                .await();
        return distance.rows[0].elements[0].distance;

    }
}
