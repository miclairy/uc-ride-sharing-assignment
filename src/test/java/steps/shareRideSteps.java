package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class shareRideSteps {

    private Driver jo;
    private Trip trip;

    @Given("^Jo has made a trip$")
    public void joHasMadeATrip() throws InvalidDataException {
        jo = new Driver("Jo");
        Route route = mock(Route.class);
        Car car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        trip = new Trip(route, "To University", false, car);
        Map<String, LocalTime> times = new HashMap<>();
        times.put("A stop", LocalTime.now().plusHours(1).plusMinutes(2));
        trip.setStopTimes(times);
    }

    @When("^jo shares the trip with (\\d+) available seats$")
    public void joSharesTheTripWithAvailableSeats(int seats)  {
        trip.share(seats, jo, LocalDate.now().minusDays(1));
    }

    @Then("^a ride that can be booked is created and the trip is shared$")
    public void aRideThatCanBeBookedIsCreatedAndTheTripIsShared() {
        int size = 0;
        assert(trip.isShared());
        assert(jo.getRides().size() > size);
    }

    @Then("^a ride that can be booked is created with the maximum number of seats in the car$")
    public void aRideThatCanBeBookedIsCreatedWithTheMaximumNumberOfSeatsInTheCar() throws Throwable {
        assertEquals(5, jo.getRides().get(0).getAvailableSeats());
    }

}
