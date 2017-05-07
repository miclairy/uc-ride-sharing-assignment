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
    private StopPoint stop2;
    private Collection<Ride> ridesForStop = new ArrayList<>();
    private String filter;


    @Given("^there is some stop points including (\\d+) \"([^\"]*)\" street\\.$")
    public void thereIsSomeStopPointsIncludingStreet(int number, String streetName) {
        stop = new StopPoint(number, streetName);
        stop2 = new StopPoint(3, "Bear");
        stops.add(stop);
        stops.add(stop2);
    }

    @Given("^sally is a passenger$")
    public void sallyIsAPassenger() {
        Passenger sally = new Passenger();
    }

    @Given("^there are some rides with (\\d+) \"([^\"]*)\" street included as a stop point$")
    public void thereAreSomeRidesWithStreetIncludedAsAStopPoint(int arg1, String arg2) {
        Car car = mock(Car.class);
        Trip trip = new Trip(new Route(stops, ""), "To University", false, car);
        trip.setName("trip");
        ride1 = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        List<StopPoint> stops2 = new ArrayList<>();
        stops2.add(stop2);
        Trip trip2 = new Trip(new Route(stops2, ""), "From University", false, car);
        trip2.setName("trip2");
        ride2 = new Ride(trip2, 6, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        Data.getSharedRides().add(ride1);
        Data.getSharedRides().add(ride2);
    }

    @When("^sally selects a (\\d+) \"([^\"]*)\" street$")
    public void sallySelectsAStreet(int arg1, String arg2) {
        selected = stop;
    }

    @Then("^the rides which have (\\d+) \"([^\"]*)\" street as a stop point are seen\\.$")
    public void theRidesWhichHaveStreetAsAStopPointAreSeen(int arg1, String arg2) {
        ObservableList<Ride> rides = FXCollections.observableArrayList();
        rides.add(ride1);
        assertEquals(rides, Search.ridesForStopPoint(selected));
    }

    @Given("^there is a stop point that has multiple rides that go to it\\.$")
    public void thereIsAStopPointThatHasMultipleRidesThatGoToIt() {
        StopPoint stop4 = new StopPoint(90, "Cabbage");
        stops.add(stop);
        stops.add(stop4);
        Car car = mock(Car.class);
        Trip trip3 = new Trip(new Route(stops, ""), "To University", false, car);
        trip3.setName("trip3");
        ride3 = new Ride(trip3, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        Trip trip = new Trip(new Route(stops, ""), "To University", false, car);
        trip.setName("trip");
        ride1 = new Ride(trip, 5, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        stops.remove(stop);
        Trip trip2 = new Trip(new Route(stops, ""), "From University", false, car);
        trip2.setName("trip2");
        ride2 = new Ride(trip2, 6, new Driver("jo"), new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
    }

    @Given("^sally has selected that stop point$")
    public void sallyHasSelectedThatStopPoint() {
        selected = stop;
        ridesForStop.addAll(Search.ridesForStopPoint(selected));
        Data.getSharedRides().clear();
        Data.getSharedRides().add(ride1);
        Data.getSharedRides().add(ride2);
        Data.getSharedRides().add(ride3);
    }

    @When("^sally selects a filter option \"([^\"]*)\"$")
    public void sallySelectsAFilterOption(String filter) {
        this.filter = filter;
    }

    @Then("^the rides which go \"([^\"]*)\" are seen\\.$")
    public void theRidesWhichGoAreSeen(String arg1)  {
        Collection<Ride> filtered = new ArrayList<>();
        filtered.add(ride1);
        filtered.add(ride3);

        assertEquals(filtered, Search.filterRides(filter));
    }



}
