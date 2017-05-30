package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class bookRideSteps {

    private List<StopPoint> stops = new ArrayList<>();
    private Ride ride1;
    private Ride selectedRide;
    private Passenger sally;
    private Driver jo = new Driver();
    private int availableSeatsBefore;

    @Given("^sally has selected a ride$")
    public void sallyHasSelectedARide() throws InvalidDataException {
        Car car = new Car("BMW", "Blue", "mack6", "TED123", 2010, 5);
        Route route = mock(Route.class);
        Trip trip = new Trip(route, "to Uni", false, car);
        ride1 = new Ride(trip, 5, LocalDate.now());
        selectedRide = ride1;
    }

    @When("^sally books the ride$")
    public void sallyBooksTheRide() {
        availableSeatsBefore = selectedRide.getAvailableSeats();
        sally = new Passenger();
        Map<String, String> store = new HashMap<>();
        store.put("ucId", "sal34");
        store.put("name", "sally");
        store.put("address", "45 Sally");
        store.put("phone", "450138318");
        store.put("email", "sal34@uclive.ac.nz");
        sally.setDetails(store);
        selectedRide.bookPassenger(jo, sally);
    }

    @Then("^sally will be expected on the ride and the available seats decreases$")
    public void sallyWillBeExpectedOnTheRideAndTheAvailableSeatsDecreases() {
        System.out.println(selectedRide.getAvailableSeats());
        assert (selectedRide.getPassengers().contains(sally));
        assert (availableSeatsBefore > selectedRide.getAvailableSeats());
    }

    @Then("^she will know that she booked the ride$")
    public void sheWillKnowThatSheBookedTheRide() {
        assert (ride1.getPassengers().contains(sally));
    }

    @Given("^sally has booked a ride$")
    public void sallyHasBookedARide() throws InvalidDataException {
        Car car = new Car("BMW", "Blue", "mack6", "TED123", 2010, 5);
        Trip trip = new Trip(new Route(stops, ""), "to Uni", false, car);
        selectedRide = new Ride(trip, 5, LocalDate.now());

        sally = new Passenger();
        selectedRide.bookPassenger(jo, sally);
        availableSeatsBefore = selectedRide.getAvailableSeats();
    }

    @When("^sally goes to book the ride again$")
    public void sallyGoesToBookTheRideAgain() {
        selectedRide.bookPassenger(jo, sally);
    }

    @Then("^nothing happens and she is not included again\\.$")
    public void nothingHappensAndSheIsNotIncludedAgain() {
        assertEquals(availableSeatsBefore, selectedRide.getAvailableSeats());
    }



}
