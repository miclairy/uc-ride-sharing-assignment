import model.Car;
import model.Passenger;
import model.Ride;
import model.Trip;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by clbmi on 26/03/2017.
 */
public class RideTest {

    @Test
    public void testNumSeats(){

    }

    @Test
    public void passengerBookTest(){
        Car car = mock(Car.class);
        when(car.getNumSeats()).thenReturn(5);
        Passenger passenger = mock(Passenger.class);

        Ride ride = new Ride(new Trip(), );
        when(car.getNumSeats()).thenReturn(5);
        assert(ride.getAvailableSeats() <= car.getNumSeats());
    }

}
