package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.mock;


public class shareRideSteps {

    private Driver jo;
    private Trip trip;

    @Given("^Jo has made a trip$")
    public void joHasMadeATrip()  {
        jo = new Driver("Jo");
        Route route = mock(Route.class);
        Car car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        trip = new Trip(route, "To University", false, car);
    }

    @When("^jo shares the trip with (\\d+) available seats$")
    public void joSharesTheTripWithAvailableSeats(int seats)  {
        trip.share(seats, new Driver("jo"), LocalDate.now());
    }

    @Then("^a ride that can be booked is created and the trip is shared$")
    public void aRideThatCanBeBookedIsCreatedAndTheTripIsShared() {
        int size = 0;
        assert(trip.isShared());
        assert(Data.getSharedRides().size() > size);
    }
}
