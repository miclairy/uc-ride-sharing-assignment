package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Driver;
import model.License;
import model.Passenger;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by clbmi on 16/05/2017.
 */
public class editAccountSteps {

    private Passenger sally;
    private Driver jo;
    private Map<String, String> details = new HashMap<>();
    private License license ;

    @Given("^Sally has an account$")
    public void sallyHasAnAccount() {
        sally = new Passenger();
        details.put("ucId", "sal34");
        details.put("name", "Sally");
        details.put("address", "34 Sale");
        details.put("phone",  "028464103");
        details.put("email", "sal34@uclive.ac.nz");
        sally.setDetails(details);
    }

    @When("^Sally changes her name to \"([^\"]*)\" and her phone number to \"([^\"]*)\"$")
    public void sallyChangesHerNameToAndHerPhoneNumberTo(String newName, String newPhone) {
        HashMap<String, String> newDetail = new HashMap<>();
        newDetail.put("name", newName);
        newDetail.put("phone",  newPhone);
        sally.setDetails(newDetail);

        details.replace("name", newName);
        details.replace("phone", newPhone);
    }

    @Then("^Her details are changed$")
    public void herDetailsAreChanged() throws Throwable {
        assertEquals(details, sally.getDetails());
    }

    @When("^Sally changes her uc id to \"([^\"]*)\"$")
    public void sallyChangesHerUcIdTo(String newUcId) {
        HashMap<String, String> newDetail = new HashMap<>();
        newDetail.put("ucId", newUcId);
        sally.setDetails(details);
    }

    @Then("^Her details are not changed$")
    public void herDetailsAreNotChanged() throws Throwable {
        assertEquals(details, sally.getDetails());
    }

    @Given("^Jo has a driver account$")
    public void joHasADriverAccount() {
        jo = new Driver();
        details.put("ucId", "jo78");
        details.put("name", "jo");
        details.put("address", "34 joes");
        details.put("phone",  "028464103");
        details.put("email", "jo34@uclive.ac.nz");
        jo.setDetails(details);
        license = new License("Full", "FR54367", LocalDate.of(2015, 05, 1),
                LocalDate.of(2025, 05, 1));
        jo.setLicense(license);
    }

    @When("^Jo goes to edit his account and changes his license expiration to next year$")
    public void joGoesToEditHisAccountAndChangesHisLicenseExpirationToNextYear() {
        license.upDateExpiiry(LocalDate.of(2026, 05, 1));
    }

    @Then("^his new license information is stored$")
    public void hisNewLicenseInformationIsStored() throws Throwable {
        assertEquals(2026, jo.getLicense().getExpiry().getYear());
    }
}
