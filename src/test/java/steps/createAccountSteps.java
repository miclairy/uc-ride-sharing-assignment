package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by clbmi on 26/04/2017.
 */
public class createAccountSteps {

    private Driver jo;
    private String password;
    private String passwordP;
    private Map<String, Object> store = new HashMap<>();
    private Map<String, Object> passengerStore = new HashMap<>();
    private License license;
    private Passenger sally;

    @Given("^jo clicked become driver$")
    public void joClickedBecomeDriver() {
        jo = new Driver("");
    }

    @When("^jo enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+) and \"([^\"]*)\" and he uploads a photo and enters the password \"([^\"]*)\" twice$")
    public void joEntersAndAndHeUploadsAPhotoAndEntersThePasswordTwice(String ucid, String name, String address, long phone, String email, String password) {
        this.password = password;
        store.put("ucId", ucid);
        store.put("name", name);
        store.put("address", address);
        store.put("phone", phone);
        store.put("email", email);
    }

    @Then("^the email and password are verified and he is asked for his drivers license information$")
    public void theEmailAndPasswordAreVerifiedAndHeIsAskedForHisDriversLicenseInformation() {
        assert(jo.verifyEmail((String) store.get("email")));
        assert(jo.verifyPassword(password, password));
    }

    @When("^jo enters type \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void joEntersType(String type, String number, String issued, String expiry) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar issuedDate = new GregorianCalendar();
        Calendar expiryDate = new GregorianCalendar();
        issuedDate.setTime(df.parse(issued));
        expiryDate.setTime(df.parse(expiry));
        license = new License(type,  number, issuedDate, expiryDate);
    }

    @Then("^it is verified he can carry passengers$")
    public void itIsVerifiedHeCanCarryPassengers()  {
        assert(license.verify());
    }

    @Then("^his details are stored and account is created$")
    public void hisDetailsAreStoredAndAccountIsCreated() {
        jo.setDetails(store);
        jo.setLicense(license);
        jo.storePassword(password);
        assertEquals(jo.getDetails(), store);

    }

    @Given("^sally clicked to become a passenger$")
    public void sallyClickedToBecomeAPassenger() {
        sally = new Passenger();
    }

    @When("^sally enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", (\\d+) and \"([^\"]*)\" and she uploads a photo and enters the password \"([^\"]*)\" twice$")
    public void sallyEntersAndAndSheUploadsAPhotoAndEntersThePasswordTwice(String ucid, String name, String address, long phone, String email, String password) {
        this.passwordP = password;
        passengerStore.put("ucId", ucid);
        passengerStore.put("name", name);
        passengerStore.put("address", address);
        passengerStore.put("phone", phone);
        passengerStore.put("email", email);
    }

    @Then("^the email and password are verified and her account is created$")
    public void theEmailAndPasswordAreVerifiedAndHerAccountIsCreated() {
        assert(sally.verifyEmail((String) passengerStore.get("email")));
        assert(sally.verifyPassword(passwordP, passwordP));

    }

    @Then("^the email fails verification and she is told the email is already in use$")
    public void theEmailFailsVerificationAndSheIsToldTheEmailIsAlreadyInUse() {
        Passenger temp = new Passenger();
        assertFalse(temp.verifyEmail((String) passengerStore.get("email")));
    }

    @Given("^sally is already signed up$")
    public void sallyIsAlreadySignedUp() throws Throwable {
        sally = new Passenger();
        this.passwordP = "liveLife";
        Map<String, Object> passengerStore = new HashMap<>();
        passengerStore.put("ucId", "sal34");
        passengerStore.put("name", "sally");
        passengerStore.put("address", "23 bear street");
        long phone = 1234568852;
        passengerStore.put("phone", phone);
        passengerStore.put("email", "sal34@canterbury.ac.nz");
        sally.setDetails(passengerStore);
        Data.passengers.add(sally);
    }

}
