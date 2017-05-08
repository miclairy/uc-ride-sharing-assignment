import model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
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

    @Before
    public void setUp(){
        Route route = mock(Route.class);
        car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        trip = new Trip(route, "To University", true, car);
        ride = new Ride(trip, 2, new Driver("jo"),
                new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testNumSeats(){
        assert(ride.getAvailableSeats() <= car.getNumSeats() );
    }

    @Test
    public void passengerBookTest(){
        Passenger passenger = mock(Passenger.class);
        int previousAvailableSeats = ride.getAvailableSeats();
        ride.bookPassenger(passenger);
        assert(ride.getAvailableSeats() < previousAvailableSeats);
    }

    @Test
    public void passengerBooksLastSeatTest(){
        Passenger passenger = mock(Passenger.class);
        Passenger passenger1 = mock(Passenger.class);
        Data.getSharedRides().add(ride);
        ride.bookPassenger(passenger);
        ride.bookPassenger(passenger1);
        assertEquals(0, ride.getAvailableSeats());
        assertFalse(Data.getSharedRides().contains(ride));
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
    public void recurrentRideTest(){ //TODO test that they are correct days
        Data.getSharedRides().clear();
        trip.setExpirationDate(new GregorianCalendar(2017, 4, 30)); //30th may 2017
        Set<Integer> days = new HashSet<>();
        days.add(TimeUtils.weekDayToInt("Wednesday"));
        trip.setDays(days);
        trip.share(2, new Driver("jo"), new GregorianCalendar(2017, 3, 30));
        assertEquals(4, Data.getSharedRides().size());

        Data.getSharedRides().clear();
        days.add(TimeUtils.weekDayToInt("Sunday"));
        trip.setDays(days);
        trip.share(2, new Driver("jo"), new GregorianCalendar(2017, 3, 30));
        assertEquals(9, Data.getSharedRides().size());
    }
}
