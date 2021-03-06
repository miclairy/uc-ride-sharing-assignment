package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static org.junit.Assert.assertEquals;


/**
 * Created by clbmi on 19/04/2017.
 */
public class storeDataSteps {

    private Trip trip;
    private List<Driver> jos = new ArrayList<>();
    private List<StopPoint> stops = new ArrayList<>();
    private List<Ride> rides;

    @Given("^there is a trip in the system$")
    public void thereIsATripInTheSystem() throws InvalidDataException {
        Data.setDataListeners();
        Data.drivers.clear();
        Data.stopPoints.clear();
        for (Driver jo : jos){
            jo.getRides().clear();
        }
        Driver jo = new Driver("jo");
        jo.addCar(new Car("car", "blue", "mazda", "123RTF", 1200, 6));
        StopPoint stopPoint1 = new StopPoint(3, "hare");
        StopPoint stopPoint2 = new StopPoint(4, "magic");
        StopPoint stopPoint3 = new StopPoint(12, "alpha");
        Data.stopPoints.add(stopPoint1);
        Data.stopPoints.add(stopPoint2);
        Data.stopPoints.add(stopPoint3);
        stops.addAll(Data.stopPointsList);
        jo.createRoute(Data.stopPointsList, "1");
        trip = new Trip(jo.getRoutes().get(0), "to uni", true, jo.getCars().get(0));
        Set<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.FRIDAY);
        trip.setDays(days);
        trip.setExpirationDate(LocalDate.of(2018, 1, 1));
        Map<String, LocalTime> times = new HashMap<>();
        times.put("A stop", LocalTime.of(23, 59, 0));
        trip.setStopTimes(times);
        trip.setName("Test");
        jo.addTrip(trip);
        Data.addDriver(jo);
        jos.add(jo);

    }

    @When("^the application is reopened$")
    public void theApplicationIsReopened() throws Throwable {
        try {
            Data.load("/dataTest.json");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Then("^the ride is in the json$")
    public void theRideIsInTheJson() throws Throwable {
        File file = new File("src/main/resources/dataTestWritten.json");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.contains("\"rides\": [")){
                assertEquals("      \"rides\": [", line);
                return;
            }
        }
        assert false;
    }

    @Then("^the trip should still be there$")
    public void theTripShouldStillBeThere() {
        assertEquals(jos.get(0), Data.drivers.get(0));
        trip.setShared(true);
        assertEquals(trip, Data.drivers.get(0).getTrips().get(0));
        assertEquals(stops, Data.stopPointsList);
    }

    @Given("^there is a ride$")
    public void thereIsARide() {
        trip.share(5, Data.drivers.get(0), LocalDate.of(2017, 7, 30));
        rides = jos.get(0).getRides();
    }

    @Then("^the ride should still be there$")
    public void theRideShouldStillBeThere() {
        assertEquals(rides, Data.drivers.get(0).getRides());
    }

    @When("^the application is closed$")
    public void theApplicationIsClosed() throws Throwable {
        Rss toSave = new Rss();
        String saveLocation = "src/main/resources/dataTestWritten.json";
        try {
            Data.save(toSave, saveLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("^the trip is entered in the json$")
    public void theTripIsEnteredInTheJson() throws Throwable {
        File file = new File("src/main/resources/dataTestWritten.json");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.contains("\"trips\": [")){
                assertEquals("      \"trips\": [", line);
                return;
            }
        }
        assert false;
    }
}
