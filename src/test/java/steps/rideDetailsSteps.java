package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class rideDetailsSteps {

    private Passenger sally;
    private Car car;
    private int numStops;
    private int routeLength;
    private Ride ride;
    private String driverName;
    private String grade;
    private int year;
    private String colour;
    private String model;
    private int availableSeats;
    private Driver jo;

    @Given("^Sally is a passenger$")
    public void sallyIsAPassenger() {
        sally = new Passenger();
    }

    @When("^sally selects a ride which is from \"([^\"]*)\" who is \"([^\"]*)\" grade and with a (\\d+) \"([^\"]*)\" \"([^\"]*)\" with (\\d+) seats available$")
    public void sallySelectsARideWhichIsFromWhoIsGradeAndWithAWithSeatsAvailable(String driver, String grade, int year, String colour, String model, int availableSeats) throws InvalidDataException {
        this.driverName = driver;
        this.grade = grade;
        this.year = year;
        this.colour = colour;
        this.model = model;
        this.availableSeats = availableSeats;
        jo = new Driver(driver);
        jo.setGrade(grade);
        car = new Car("", colour, model, "123TRE", year, availableSeats);
        car.setEfficiency(10.0);
    }

    @When("^the route is (\\d+) minutes long with (\\d+) stops\\.$")
    public void theRouteIsMinutesLongWithStops(int routeLength, int numStops) {
        this.routeLength = routeLength;
        this.numStops = numStops;
//        StopPoint stop1 = mock(StopPoint.class);
//        StopPoint stop2 = mock(StopPoint.class);
//        StopPoint stop3 = mock(StopPoint.class);
        StopPoint stop1 = new StopPoint(6, "Hare Street");
        StopPoint stop2 = new StopPoint(42,"Arthur Street");
        StopPoint stop3 = new StopPoint(73, "Mary Street");
        List<StopPoint> stops = new ArrayList<>();
        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        Route route = new Route(stops, "");
        Trip trip = new Trip(route, "from uni", false, car);
        trip.setTimeForStopPoint(stop1, LocalTime.of(15, 0));
        trip.setTimeForStopPoint(stop2, LocalTime.of(15, 10));
        trip.setTimeForStopPoint(stop3, LocalTime.of(15, 20));
        ride = new Ride(trip, car.getNumSeats(), LocalDate.now());

    }

    @Then("^the rides details are displayed including drivers name, grade, car model, color, year, seats available, route length and number of stops\\.$")
    public void theRidesDetailsAreDisplayedIncludingDriversNameGradeCarModelColorYearSeatsAvailableRouteLengthAndNumberOfStops() throws Throwable {
        String details = "\nCar: " + car.toString() +
                        "\nDirection: from uni" + "\nNumber of Stops: " + numStops + "\nAvailable Seats: " + car.getNumSeats()
                + "\nCost: $2.90";
        assertEquals(details, ride.getDetails());
    }
}
