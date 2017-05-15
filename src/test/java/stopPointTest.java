import com.google.maps.errors.ApiException;
import com.google.maps.model.Distance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class stopPointTest {

    @Test
    public void searchTest(){
        StopPoint stop = new StopPoint(6, "Hare");
        StopPoint stopPoint = new StopPoint(8, "Bear");
        StopPoint stopPoint2 = new StopPoint(6, "Bear");
        Data.stopPointsList.add(stop);
        Data.stopPointsList.add(stopPoint);
        Data.stopPointsList.add(stopPoint2);
        ObservableList<StopPoint> result = FXCollections.observableArrayList();
        result.add(stopPoint);
        result.add(stopPoint2);
        Assert.assertEquals(result.sorted(), Search.stopPointsSearch("Bear"));
        result.remove(stopPoint);
        result.add(stop);
        Assert.assertEquals(result.sorted(), Search.stopPointsSearch("6"));
    }

    @Test
    public void calculateCostOfTripTest(){
        StopPoint stop = new StopPoint(21, "Halswell Junction Road");
        List<StopPoint> stops = new ArrayList<>();
        stops.add(stop);
        Route route = new Route(stops, "test");
        Car car = mock(Car.class);
        Answer<Double> answer = invocationOnMock -> 10.0;
        when(car.getEfficiency()).thenAnswer(answer);

        Trip trip = new Trip(route, "to University", false, car);
        try {
            double cost = trip.calculateCostPerPassenger();
            Assert.assertEquals(1.87415, cost, 0.01);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
