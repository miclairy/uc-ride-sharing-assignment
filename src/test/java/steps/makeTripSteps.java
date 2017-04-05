package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class makeTripSteps {

    private Driver jo;
    private ObservableList<StopPoint> stops;
    private Trip trip;
    private StopPoint stopPoint2;

    @Given("^jo is a driver making a trip$")
    public void joIsADriverMakingATrip() {
        jo = new Driver("jo");
    }

    @Given("^jo has some routes$")
    public void joHasSomeRoutes() {
        StopPoint stopPoint1 = mock(StopPoint.class);
        stopPoint2 = mock(StopPoint.class);
        StopPoint stopPoint3 = mock(StopPoint.class);
        stops = FXCollections.observableArrayList();
        stops.add(stopPoint1);
        stops.add(stopPoint2);
        stops.add(stopPoint3);
        jo.createRoute(stops, "1");
    }

    @Given("^Jo registered a car\\.$")
    public void joRegisteredACar() throws Throwable {
        Car car = mock(Car.class);
        jo.addCar(car);
    }

    @When("^Jo creates a trip by defining it to be his only route \"([^\"]*)\" (\\d+) each stop point (\\d+) minutes after the previous$")
    public void joCreatesATripByDefiningItToBeHisOnlyRouteEachStopPointMinutesAfterThePrevious(String direction, int time, int timeInterval) {
        Route route = jo.getRoutes().get(0);
        trip = new Trip(jo.getRoutes().get(0), direction, true, jo.getCars().get(0));
        for (StopPoint stop : route.getStops()) {
            Time timeT = new Time(3, timeInterval, "pm");
            trip.setTimeForStopPoint(stop, timeT);
            timeInterval += timeInterval;
        }
    }

    @When("^that the trip is recurrent so it repeats every \"([^\"]*)\" until (\\d+)th \"([^\"]*)\"\\.$")
    public void thatTheTripIsRecurrentSoItRepeatsEveryUntilTh(String weekday, int day, String month) {
        Set<String> days = new HashSet<>();
        days.add(weekday);
        trip.setDays(days);
        trip.setExpirationDate(new GregorianCalendar(Calendar.YEAR, Time.monthToInt(month), day));
        jo.getTrips().add(trip);
    }

    @Then("^the trip is displayed to jo with all information\\.$")
    public void theTripIsDisplayedToJoWithAllInformation() {
        Trip joTrip = jo.getTrips().get(0);
        assertEquals(jo.getTrips().get(0), trip);
        StopPoint stop = stopPoint2;
        Time time = new Time(3, 30, "pm");
        assertEquals(time, joTrip.getStopTimes().get(stop));
    }

}
