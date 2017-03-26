import model.Time;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clbmi on 26/03/2017.
 */
public class timeTest {

    @Test
    public void monthTOIntTest(){
        assertEquals(3, Time.monthToInt("March"));
        assertEquals(12, Time.monthToInt("December"));
        assertEquals(6, Time.monthToInt("June"));
    }
}
