import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.mockito.Mockito.mock;


public class RideTest {

    private Ride ride;
    private Car car;

    @Before
    public void setUp(){
        Route route = mock(Route.class);
        car = new Car("Car", "Blue", "Mazda6", "ALN345", 2011, 5);
        ride = new Ride(new Trip(route, "To Uni", false, car), 15);
    }

    @Test
    public void testNumSeats(){
        assert(ride.getAvailableSeats() <= car.getNumSeats() );
    }

    @Test
    public void passengerBookTest(){
        Passenger passenger = mock(Passenger.class);
        int previousAvailableSeats = ride.getAvailableSeats();
        ride.addPassenger(passenger);
        assert(ride.getAvailableSeats() < previousAvailableSeats);
    }

}
