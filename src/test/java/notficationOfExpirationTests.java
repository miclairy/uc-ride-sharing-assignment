import controllers.ExpiryNotifactions;
import model.Car;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

/**
 * Created by clbmi on 7/05/2017.
 */
public class notficationOfExpirationTests {

    @Test
    public void expirationTest(){
        assert ExpiryNotifactions.checkIfNotify(LocalDate.now().plusMonths(1));
        assert ExpiryNotifactions.checkIfNotify(LocalDate.now().plusWeeks(1));
        assert ExpiryNotifactions.checkIfNotify(LocalDate.now().plusWeeks(2));
    }


}
