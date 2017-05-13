package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 13/05/2017.
 */
public class cancelBookedRideSteps {

    private Passenger sally = new Passenger();
    private Ride ride;
    private Driver jo = new Driver();
    private String reason;

    @Given("^sally has booked a ride and wants to cancel it$")
    public void sallyHasBookedARideAndWantsToCancelIt() {
        Car car = new Car("car", "blue", "mazda", "ATE346", 1998, 1);
        Trip trip = new Trip(mock(Route.class), "to uni", false, car);
        ride = new Ride(trip, 1, LocalDate.now());
        ride.bookPassenger(jo, sally);
    }

    @When("^sally cancels the booking because \"([^\"]*)\"$")
    public void sallyCancelsTheBookingBecause(String reason) {
        this.reason = reason;
        ride.cancelPassenger(sally, reason);
    }

    @Then("^the drivers car is available again if it wasn't before with updated available seats$")
    public void theDriversCarIsAvailableAgainIfItWasnTBeforeWithUpdatedAvailableSeats() {
        assertEquals(Ride.RideState.Running.name(), ride.getRideState());
        assertEquals(1, ride.getAvailableSeats());
    }

    @Then("^the driver is notified of the cancellation$")
    public void theDriverIsNotifiedOfTheCancellation() {
        HashMap<Passenger, String> reasons = new HashMap<>();
        reasons.put(sally, reason);
        assertEquals(reasons, ride.notifyDriver());
    }
}
