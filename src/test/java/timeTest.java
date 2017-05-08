import model.TimeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clbmi on 26/03/2017.
 */
public class timeTest {

    @Test
    public void monthTOIntTest(){
        assertEquals(3, TimeUtils.monthToInt("March"));
        assertEquals(12, TimeUtils.monthToInt("December"));
        assertEquals(6, TimeUtils.monthToInt("June"));
    }
}
