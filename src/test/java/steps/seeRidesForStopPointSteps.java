package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class seeRidesForStopPointSteps {

    private List<StopPoint> stops = new ArrayList<>();
    private StopPoint selected;
    private Ride ride1;
    private Ride ride2;
    private Ride ride3;
    private StopPoint stop;
    private Collection<Ride> ridesForStop = new ArrayList<>();
    private String filter;


    @Given("^there is some stop points including (\\d+) \"([^\"]*)\" street\\.$")
    public void thereIsSomeStopPointsIncludingStreet(int number, String streetName) throws Throwable {
        stop = new StopPoint(number, streetName);
        StopPoint stop2 = new StopPoint(3, "Bear");
        stops.add(stop);
        stops.add(stop2);
    }

    @Given("^sally is a passenger$")
    public void sallyIsAPassenger() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^there are some rides with (\\d+) \"([^\"]*)\" street included as a stop point$")
    public void thereAreSomeRidesWithStreetIncludedAsAStopPoint(int arg1, String arg2) {
        Car car = mock(Car.class);
        Trip trip = new Trip(new Route(stops, ""), "to Uni", false, car);
        ride1 = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        stops.remove(stop);
        trip = new Trip(new Route(stops, ""), "to Uni", false, car);
        ride2 = new Ride(trip, 6, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
    }

    @When("^sally selects a (\\d+) \"([^\"]*)\" street$")
    public void sallySelectsAStreet(int arg1, String arg2) {
        selected = stop;
    }

    @Then("^the rides which have (\\d+) \"([^\"]*)\" street as a stop point are seen\\.$")
    public void theRidesWhichHaveStreetAsAStopPointAreSeen(int arg1, String arg2) throws Throwable {
        ObservableList<Ride> rides = FXCollections.observableArrayList();
        rides.add(ride1);
        assertEquals(rides, Data.ridesForStopPoint(selected));
    }

    @Given("^there is a stop point that has multiple rides that go to it\\.$")
    public void thereIsAStopPointThatHasMultipleRidesThatGoToIt() {
        StopPoint stop4 = new StopPoint(90, "Cabbage");
        stops.add(stop);
        stops.add(stop4);
        Car car = mock(Car.class);
        Trip trip = new Trip(new Route(stops, ""), "to Uni", false, car);
        ride3 = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
    }

    @Given("^sally has selected that stop point$")
    public void sallyHasSelectedThatStopPoint() {
        selected = stop;
        ridesForStop.addAll(Data.ridesForStopPoint(selected));
    }

    @When("^sally selects a filter option \"([^\"]*)\"$")
    public void sallySelectsAFilterOption(String filter) {
        this.filter = filter;
    }

    @Then("^the rides which go \"([^\"]*)\" are seen\\.$")
    public void theRidesWhichGoAreSeen(String arg1) throws Throwable {
        Collection<Ride> filtered = new ArrayList<>();
        filtered.add(ride1);
        filtered.add(ride3);
        assertEquals(filtered, Data.filterRides(filter));
    }



}
