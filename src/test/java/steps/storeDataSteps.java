package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Driver;
import model.StopPoint;
import model.Trip;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 19/04/2017.
 */
public class storeDataSteps {

    private Trip trip;

    @Given("^there is a trip in the system$")
    public void thereIsATripInTheSystem() {
        Driver jo = new Driver("jo");
        StopPoint stopPoint1 = mock(StopPoint.class);
        StopPoint stopPoint2 = mock(StopPoint.class);
        StopPoint stopPoint3 = mock(StopPoint.class);
        ObservableList<StopPoint> stops = FXCollections.observableArrayList();
        stops.add(stopPoint1);
        stops.add(stopPoint2);
        stops.add(stopPoint3);
        jo.createRoute(stops, "1");
        trip = new Trip(jo.getRoutes().get(0), "to uni", true, jo.getCars().get(0));

    }

    @When("^the application is closed and reopened$")
    public void theApplicationIsClosedAndReopened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the trip should still be there$")
    public void theTripShouldStillBeThere() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
