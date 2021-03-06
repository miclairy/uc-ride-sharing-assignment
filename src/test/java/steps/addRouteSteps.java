package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import model.*;
import org.junit.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by cba62 on 22/03/17.
 */
public class addRouteSteps {

    Driver jo;
    Data data = mock(Data.class);
    ArrayList<StopPoint> stops;
    ObservableList<StopPoint> stopsO;

    @Given("^Jo is a driver and wants to make a route$")
    public void joIsADriverAndWantsToMakeARoute() {
        jo = new Driver("Jo");
    }

    @Given("^there are more than (\\d+) stop point$")
    public void thereAreMoreThanStopPoint(int arg1) {

        StopPoint stopPoint1 = mock(StopPoint.class);
        StopPoint stopPoint2 = mock(StopPoint.class);
        StopPoint stopPoint3 = mock(StopPoint.class);
        stops = new ArrayList<>(Arrays.asList(stopPoint1, stopPoint2, stopPoint3));

    }

    @When("^jo creates route by adding stop points$")
    public void joCreatesRouteByAddingStopPoints() throws InvalidDataException {
        when(data.getStopPoints()).thenReturn(stops);
        ObservableList<StopPoint> stops = FXCollections.observableArrayList();
        stops.addAll(data.getStopPoints());
        jo.createRoute(stops, "");
    }

    @Then("^a new route is stored with the stop points\\.$")
    public void aNewRouteIsStoredWithTheStopPoints() {

        when(data.getStopPoints()).thenReturn(stops);
        Route route = new Route(data.getStopPoints(), "");
        assertTrue(jo.getRoutes().contains(route));
    }

    @When("^jo creates route by with (\\d+) stop points$")
    public void joCreatesRouteByWithStopPoints(int arg1) throws Throwable {
        stopsO = FXCollections.observableArrayList();

    }

    @Then("^a new route is not made and an exception is thrown\\.$")
    public void aNewRouteIsNotMadeAndAnExceptionIsThrown() throws Throwable {
        try {
            jo.createRoute(stopsO, "");
            fail("invalid exception not thrown");
        } catch (InvalidDataException e) {

            assertEquals(InvalidDataException.class, e.getClass());
        }
    }


}
