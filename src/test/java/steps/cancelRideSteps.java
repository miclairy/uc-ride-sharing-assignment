package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 10/05/2017.
 */
public class cancelRideSteps {

    private Driver jo;
    private Passenger sally;
    private Ride josRide;

    @Given("^Jo is a driver who wants to cancel a ride$")
    public void joIsADriverWhoWantsToCancelARide() {
        jo = new Driver();
    }

    @Given("^Jo has a trip which he has shared$")
    public void joHasATripWhichHeHasShared() {
        Route route = mock(Route.class);
        Car car = mock(Car.class);
        Trip trip = new Trip(route, "to Uni", false, car);
        josRide = new Ride(trip, 5, jo, LocalDate.now());    }

    @Given("^there are passengers booked on the ride$")
    public void thereArePassengersBookedOnTheRide() {
        sally = new Passenger();
        sally.bookRide(josRide);
    }

    @When("^jo selects to cancel the ride$")
    public void joSelectsToCancelTheRide() {
        josRide.cancelRide();
    }

    @Then("^the passengers are notified$")
    public void thePassengersAreNotified() {
        assertFalse(sally.bookRide(josRide));
    }

    @Then("^the ride is no longer available$")
    public void theRideIsNoLongerAvailable() {
        assertFalse(Data.getSharedRides().contains(josRide));
    }
}
