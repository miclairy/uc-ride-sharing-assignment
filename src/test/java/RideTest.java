import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class RideTest {

    private Ride ride;
    private Car car;
    private Trip trip;
    private Driver jo = new Driver();

    @Before
    public void setUp(){
        Route route = mock(Route.class);
        car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        trip = new Trip(route, "To University", true, car);
        ride = new Ride(trip, 2, LocalDate.now());
    }

    @Test
    public void testNumSeats(){
        assert(ride.getAvailableSeats() <= car.getNumSeats() );
    }

    @Test
    public void passengerBookTest(){
        Passenger passenger = mock(Passenger.class);
        int previousAvailableSeats = ride.getAvailableSeats();
        ride.bookPassenger(jo, passenger);
        assert(ride.getAvailableSeats() < previousAvailableSeats);
    }

    @Test
    public void passengerBooksLastSeatTest(){
        Passenger passenger = mock(Passenger.class);
        Passenger passenger1 = mock(Passenger.class);
        jo.addRide(ride);
        ride.bookPassenger(jo, passenger);
        ride.bookPassenger(jo, passenger1);
        assertEquals(0, ride.getAvailableSeats());
        assertEquals(Ride.RideState.Full.name(), ride.getRideState());
    }

    @Test
    public void rideLengthTest(){
        StopPoint stop1 = mock(StopPoint.class);
        StopPoint stop2 = mock(StopPoint.class);
        StopPoint stop3 = mock(StopPoint.class);
        Collection<StopPoint> stops = new ArrayList<>();
        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        Route route = new Route(stops, "");
        Trip trip = new Trip(route, "from uni", false, car);
        trip.setTimeForStopPoint(stop1, LocalTime.of(15, 0));
        trip.setTimeForStopPoint(stop2, LocalTime.of(15, 0));
        trip.setTimeForStopPoint(stop3, LocalTime.of(15, 0));

        assertEquals(Duration.of(0, SECONDS), trip.getLength());

        trip.setTimeForStopPoint(stop1, LocalTime.of(15, 0));
        trip.setTimeForStopPoint(stop2, LocalTime.of(15, 10));
        trip.setTimeForStopPoint(stop3, LocalTime.of(15, 0));

        assertEquals(Duration.of(10, MINUTES), trip.getLength());
    }

    @Test
    public void recurrentRideTest(){ //TODO test that they are correct days and fix
        jo.getRides().clear();
        trip.setExpirationDate(LocalDate.of(2017, 4, 30)); //30th may 2017
        Set<DayOfWeek> days = new HashSet<>();
        days.add(DayOfWeek.WEDNESDAY);
        trip.setDays(days);
        trip.share(2, jo, LocalDate.of(2017, 3, 30));
        assertEquals(4, jo.getRides().size());

        jo.getRides().clear();
        days.add(DayOfWeek.SUNDAY);
        trip.setDays(days);
        trip.share(2, jo, LocalDate.of(2017, 3, 30));
        assertEquals(7, jo.getRides().size());
    }
}
