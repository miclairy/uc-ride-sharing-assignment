package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Driver;
import model.License;

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
    private Map<String, Object> store = new HashMap<>();
    private License license;

    @Given("^jo clicked become driver$")
    public void joClickedBecomeDriver() {
        jo = new Driver("");
    }

    @When("^jo enters \"([^\"]*)\", \"([^\"]*)\", (\\d+) and \"([^\"]*)\" and he uploads a photo and enters the password \"([^\"]*)\" twice$")
    public void joEntersAndAndHeUploadsAPhotoAndEntersThePasswordTwice(String name, String address, long phone, String email, String password) {
        this.password = password;
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
        license = new License(type,  number, df.parse(issued), df.parse(expiry));
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

}
