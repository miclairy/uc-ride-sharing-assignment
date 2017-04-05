import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        Passenger passenger2 = mock(Passenger.class);
        ride.bookPassenger(passenger);
        ride.bookPassenger(passenger1);
        assertEquals(0, ride.getAvailableSeats());
        assertFalse(Data.getSharedRides().contains(ride));
        //ride.bookPassenger(passenger2);
    }



}
