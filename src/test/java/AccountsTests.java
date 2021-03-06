import model.Driver;
import model.License;
import model.Passenger;
import model.PasswordUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertFalse;


/**
 * Created by clbmi on 26/04/2017.
 */
public class AccountsTests {

    @Test
    public void verifyLicenseTest() throws ParseException {

        LocalDate issuedDate = LocalDate.of(2016, 9, 2);
        LocalDate expiryDate = LocalDate.of(2026, 02, 06);
        License license = new License("full", "FR123456", issuedDate, expiryDate);
        License restrictedLicense = new License("restricted", "FR123456", issuedDate, expiryDate);
        LocalDate wrongExpiryDate = LocalDate.of(2016, 02, 06);
        License wrongExpiry = new License("full",  "FR123456", issuedDate, wrongExpiryDate);
        License oldLicense = new License("full for 2 years",  "FR123456", issuedDate, expiryDate);
        LocalDate expired = LocalDate.of(2017, 02, 06);
        License expiredLicense = new License("full",  "FR123456", issuedDate, expired);
        assert(license.verify());
        assert(oldLicense.verify());
        assertFalse(restrictedLicense.verify());
        assertFalse(wrongExpiry.verify());
        assertFalse(expiredLicense.verify());
    }

    @Test
    public void verifyEmailTest() throws IOException {
        Driver driver = new Driver();
        assert(driver.verifyEmail("lalal34@uclive.ac.nz"));
        assert (driver.verifyEmail("jo.blogs@canterbury.ac.nz"));
        assertFalse(driver.verifyEmail("piggy@gmail.com"));
    }

    @Test
    public void verifyPasswordTest(){
        Driver driver = new Driver();
        assert (driver.verifyPassword("abd23", "abd23"));
        assertFalse(driver.verifyPassword("12345fsd", "aeyH35"));
    }

    @Test
    public void testPasswordStore() throws IOException {
        Passenger acc = new Passenger();
        acc.storePassword("magicFun124");
        assert (!acc.getPassword().equals("magicFun124"));
    }


    @Test
    public void enterPasswordTest() throws IOException {
        Passenger acc = new Passenger();
        acc.storePassword("liveLifeLoud2345");
        assert (PasswordUtils.isExpectedPassword("liveLifeLoud2345".toCharArray(), acc.getSalt(), acc.getPassword()));
    }

    @Test
    public void enterFailedPasswordTest() throws IOException {
        Passenger acc = new Passenger();
        acc.storePassword("liveLifeLoud2345");
        assertFalse(PasswordUtils.isExpectedPassword("magicFun234".toCharArray(), acc.getSalt(), acc.getPassword()));
    }

    @Test
    public void changePasswordTest() throws IOException {
        Passenger acc = new Passenger();
        acc.storePassword("liveLifeLoud2345");
        acc.changePassword("lalalala");
        assert (PasswordUtils.isExpectedPassword("lalalala".toCharArray(), acc.getSalt(), acc.getPassword()));
    }

    @After
    public void removeMadeAccounts() throws IOException {
        cleanUpFile("null");
    }

    private void cleanUpFile(String emailToRemove) throws IOException {
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String line = reader.readLine();
        List<String> usersBuffer = new ArrayList<>();
        while (line != null){
            usersBuffer.add(line + "\n");
            line = reader.readLine();

        }
        FileWriter fileWriter = new FileWriter(users);
        for (String user: usersBuffer){
            if (!user.split(",")[0].equals(emailToRemove)){
                fileWriter.write(user);
            }
        }

        reader.close();
        fileWriter.close();
    }


}
