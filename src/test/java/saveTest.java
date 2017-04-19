import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 19/04/2017.
 */
public class saveTest {

    @Test
    public void fileCreatedTest(){
        Driver jo = new Driver("jo");
        jo.addCar(new Car("car", "blue", "mazda", "123RTF", 1200, 6));
        StopPoint stopPoint1 = new StopPoint(3, "hare");
        StopPoint stopPoint2 = new StopPoint(4, "magic");
        StopPoint stopPoint3 = new StopPoint(12, "alpha");
        ObservableList<StopPoint> stops = FXCollections.observableArrayList();
        stops.add(stopPoint1);
        stops.add(stopPoint2);
        stops.add(stopPoint3);
        jo.createRoute(stops, "1");
        Trip trip = new Trip(jo.getRoutes().get(0), "to uni", true, jo.getCars().get(0));
        jo.getTrips().add(trip);
        Data.drivers.add(jo);

        Rss toSave = new Rss();
        try {
            Main.save(toSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
