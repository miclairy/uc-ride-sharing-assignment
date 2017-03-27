package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import org.junit.Assert;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 25/03/2017.
 */
public class makeTripSteps {

    Driver jo;
    ObservableList<StopPoint> stops;
    Trip trip;

    @Given("^jo is a driver making a trip$")
    public void joIsADriverMakingATrip() {
        jo = new Driver("jo");
    }

    @Given("^jo has some routes$")
    public void joHasSomeRoutes() {
        StopPoint stopPoint1 = mock(StopPoint.class);
        StopPoint stopPoint2 = mock(StopPoint.class);
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
            Time timeT = new Time(15, time);
            trip.setTimeForStopPoint(stop, timeT);
            time += timeInterval;
        }
    }

    @When("^that the trip is recurrent so it repeats every \"([^\"]*)\" until (\\d+)th \"([^\"]*)\"\\.$")
    public void thatTheTripIsRecurrentSoItRepeatsEveryUntilTh(String weekday, int day, String month) {
        ArrayList<String> days = new ArrayList<>();
        days.add(weekday);
        trip.setDays(days);
        trip.setExpirationDate(new GregorianCalendar(Calendar.YEAR, Time.monthToInt(month), day));
        jo.getTrips().add(trip);
    }

    @Then("^the trip is displayed to jo with all information\\.$")
    public void theTripIsDisplayedToJoWithAllInformation() {
        Trip joTrip = jo.getTrips().get(0);
        assertEquals(jo.getTrips().get(0), trip);
        StopPoint stop = joTrip.getRoute().getStops().get(2);
        Time time = new Time(15, 30);
        assertEquals(time, joTrip.getStopTimes().get(stop));
    }

}
