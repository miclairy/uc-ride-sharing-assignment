package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
    public void joHasSomeRoutes() throws InvalidDataException {
        StopPoint stopPoint1 = mock(StopPoint.class);
        stopPoint2 = new StopPoint(6, "hare");
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

    @When("^Jo creates a recurrent is \"([^\"]*)\" trip by defining it to be his only route \"([^\"]*)\" (\\d+) each stop point (\\d+) minutes after the previous$")
    public void joCreatesARecurrentIsTripByDefiningItToBeHisOnlyRouteEachStopPointMinutesAfterThePrevious(String recurrence, String direction, int time, int timeInterval) {
        Route route = jo.getRoutes().get(0);
        trip = new Trip(jo.getRoutes().get(0), direction, Boolean.valueOf(recurrence), jo.getCars().get(0));
        trip.setName("Test Trip");
        int timeOffset = timeInterval;
        for (StopPoint stop : route.getStops()) {
            trip.setTimeForStopPoint(stop, LocalTime.of(15, timeOffset));
            timeOffset += timeInterval;
        }
    }

    @When("^that the trip is recurrent so it repeats every \"([^\"]*)\" until (\\d+)th \"([^\"]*)\"\\.$")
    public void thatTheTripIsRecurrentSoItRepeatsEveryUntilTh(String weekday, int day, String month) throws InvalidDataException {
        Set<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.of(day));
        trip.setDays(days);
        trip.setExpirationDate(LocalDate.of(Calendar.YEAR, Month.valueOf(month.toUpperCase()), day));
        jo.getTrips().add(trip);
    }

    @Then("^the trip is displayed to jo with all information\\.$")
    public void theTripIsDisplayedToJoWithAllInformation() {
        Trip joTrip = jo.getTrips().get(0);
        assertEquals(jo.getTrips().get(0), trip);
        StopPoint stop = stopPoint2;
        assertEquals(LocalTime.of(15, 30), joTrip.getStopTimes().get(stop.toString()));
        assertEquals(true, trip.getRecurrent());
        assertEquals(LocalDate.of(Calendar.YEAR, Month.valueOf("may".toUpperCase()), 6), trip.getExpirationDate());
    }

    @When("^it is added to jo$")
    public void itIsAddedToJo() throws Throwable {
        jo.getTrips().add(trip);
    }

    @Then("^the no recurrent trip is displayed to jo with all information\\.$")
    public void theNoRecurrentTripIsDisplayedToJoWithAllInformation() throws Throwable {
        Trip joTrip = jo.getTrips().get(0);
        assertEquals(jo.getTrips().get(0), trip);
        StopPoint stop = stopPoint2;
        assertEquals(LocalTime.of(15, 30), joTrip.getStopTimes().get(stop.toString()));
        assertEquals(false, trip.getRecurrent());
    }

}
