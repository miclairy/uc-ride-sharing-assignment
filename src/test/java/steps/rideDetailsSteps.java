package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

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
    public void sallySelectsARideWhichIsFromWhoIsGradeAndWithAWithSeatsAvailable(String driver, String grade, int year, String colour, String model, int availableSeats) {
        this.driverName = driver;
        this.grade = grade;
        this.year = year;
        this.colour = colour;
        this.model = model;
        this.availableSeats = availableSeats;
        jo = new Driver(driver);
        jo.setGrade(grade);
        car = new Car("", colour, model, "123TRE", year, availableSeats);
    }

    @When("^the route is (\\d+) minutes long with (\\d+) stops\\.$")
    public void theRouteIsMinutesLongWithStops(int routeLength, int numStops) {
        this.routeLength = routeLength;
        this.numStops = numStops;
        StopPoint stop1 = mock(StopPoint.class);
        StopPoint stop2 = mock(StopPoint.class);
        StopPoint stop3 = mock(StopPoint.class);
        Collection<StopPoint> stops = new ArrayList<>();
        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        Route route = new Route(stops, "");
        Trip trip = new Trip(route, "from uni", false, car);
        trip.setTimeForStopPoint(stop1, new Time(3, 00, "pm"));
        trip.setTimeForStopPoint(stop2, new Time(3, 10, "pm"));
        trip.setTimeForStopPoint(stop3, new Time(3, 20, "pm"));
        ride = new Ride(trip, car.getNumSeats(), jo, new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));

    }

    @Then("^the rides details are displayed including drivers name, grade, car model, color, year, seats available, route length and number of stops\\.$")
    public void theRidesDetailsAreDisplayedIncludingDriversNameGradeCarModelColorYearSeatsAvailableRouteLengthAndNumberOfStops() throws Throwable {
        String details = "Driver: " + driverName + "\nGrade: " + grade + "\nCar: " + car.toString() +
                        "\n Route Length: 00:" + routeLength + "\nNumber of Stops: " + numStops;
        assertEquals(details, ride.getDetails());
    }
}
