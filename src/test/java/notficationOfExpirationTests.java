import model.ExpiryNotifactions;
import org.junit.Test;

import java.time.LocalDate;

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
