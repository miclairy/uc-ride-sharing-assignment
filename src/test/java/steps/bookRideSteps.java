package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class bookRideSteps {

    private List<StopPoint> stops = new ArrayList<>();
    private Ride ride1;
    private Ride selectedRide;
    private Passenger sally;
    private int availableSeatsBefore;

    @Given("^sally has selected a ride$")
    public void sallyHasSelectedARide() {
        Car car = new Car("BMW", "Blue", "mack6", "TED123", 2010, 5);
        Route route = mock(Route.class);
        Trip trip = new Trip(route, "to Uni", false, car);
        ride1 = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        selectedRide = ride1;
    }

    @When("^sally books the ride$")
    public void sallyBooksTheRide() {
        availableSeatsBefore = selectedRide.getAvailableSeats();
        sally = new Passenger();
        selectedRide.bookPassenger(sally);
    }

    @Then("^sally will be expected on the ride and the available seats decreases$")
    public void sallyWillBeExpectedOnTheRideAndTheAvailableSeatsDecreases() throws Throwable {
        System.out.println(selectedRide.getAvailableSeats());
        assert (selectedRide.getPassengers().contains(sally));
        assert (availableSeatsBefore > selectedRide.getAvailableSeats());
    }

    @Then("^she will know that she booked the ride$")
    public void sheWillKnowThatSheBookedTheRide() {
        assert (sally.getBookedRides().contains(ride1));
    }

    @Given("^sally has booked a ride$")
    public void sallyHasBookedARide() {
        Car car = new Car("BMW", "Blue", "mack6", "TED123", 2010, 5);
        Trip trip = new Trip(new Route(stops, ""), "to Uni", false, car);
        selectedRide = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));

        System.out.println(selectedRide.getAvailableSeats());
        sally = new Passenger();
        selectedRide.bookPassenger(sally);
        availableSeatsBefore = selectedRide.getAvailableSeats();
    }

    @When("^sally goes to book the ride again$")
    public void sallyGoesToBookTheRideAgain() {
        selectedRide.bookPassenger(sally);
    }

    @Then("^nothing happens and she is not included again\\.$")
    public void nothingHappensAndSheIsNotIncludedAgain() throws Throwable {
        System.out.println(selectedRide.getAvailableSeats());
        assertEquals(availableSeatsBefore, selectedRide.getAvailableSeats());
    }



}
