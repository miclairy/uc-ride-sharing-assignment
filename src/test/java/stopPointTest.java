import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Data;
import model.Search;
import model.StopPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
        assertEquals(result.sorted(), Search.stopPointsSearch("Bear"));
        result.remove(stopPoint);
        result.add(stop);
        assertEquals(result.sorted(), Search.stopPointsSearch("6"));
    }

    @Test
    public void calculateDistanceFromUniTest(){
        StopPoint stop = new StopPoint(6, "Hare");

    }
}
