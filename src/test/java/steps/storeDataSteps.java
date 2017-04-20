package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by clbmi on 19/04/2017.
 */
public class storeDataSteps {

    private Trip trip;
    private Driver jo;
    private List<StopPoint> stops = new ArrayList<>();

    @Given("^there is a trip in the system$")
    public void thereIsATripInTheSystem() {
        jo = new Driver("jo");
        jo.addCar(new Car("car", "blue", "mazda", "123RTF", 1200, 6));
        StopPoint stopPoint1 = new StopPoint(3, "hare");
        StopPoint stopPoint2 = new StopPoint(4, "magic");
        StopPoint stopPoint3 = new StopPoint(12, "alpha");
        Data.stopPoints.add(stopPoint1);
        Data.stopPoints.add(stopPoint2);
        Data.stopPoints.add(stopPoint3);
        stops.addAll(Data.stopPointsList);
        jo.createRoute(Data.stopPointsList, "1");
        trip = new Trip(jo.getRoutes().get(0), "to uni", true, jo.getCars().get(0));
        jo.addTrip(trip);
        Data.drivers.add(jo);

    }

    @When("^the application is closed and reopened$")
    public void theApplicationIsClosedAndReopened() {
        Rss toSave = new Rss();
        try {
            Data.save(toSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Data.drivers.clear();
        Data.stopPoints.clear();
        try {
            Data.load();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Then("^the trip should still be there$")
    public void theTripShouldStillBeThere() {
        assertEquals(jo, Data.drivers.get(0));
        assertEquals(trip, Data.drivers.get(0).getTrips().get(0));
        assertEquals(stops, Data.stopPointsList);
    }
}
