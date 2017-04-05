import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class RideTest {

    private Ride ride;
    private Car car;

    @Before
    public void setUp(){
        Route route = mock(Route.class);
        car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        ride = new Ride(new Trip(route, "To Uni", false, car), 2, new Driver("jo"),
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
    public void passengerBooksLastSeat(){
        Passenger passenger = mock(Passenger.class);
        Passenger passenger1 = mock(Passenger.class);
        Data.getSharedRides().add(ride);
        ride.bookPassenger(passenger);
        ride.bookPassenger(passenger1);
        assertEquals(0, ride.getAvailableSeats());
        assertFalse(Data.getSharedRides().contains(ride));
    }

    @Test
    public void rideLength(){
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
        trip.setTimeForStopPoint(stop2, new Time(3, 00, "pm"));
        trip.setTimeForStopPoint(stop3, new Time(3, 00, "pm"));

        assertEquals(new Time(0, 0, ""), trip.getLength());

        trip.setTimeForStopPoint(stop1, new Time(3, 00, "pm"));
        trip.setTimeForStopPoint(stop2, new Time(3, 10, "pm"));
        trip.setTimeForStopPoint(stop3, new Time(3, 00, "pm"));

        assertEquals(new Time(0, 10, ""), trip.getLength());
    }


}
