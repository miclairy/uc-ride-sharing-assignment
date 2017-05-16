package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Passenger;

/**
 * Created by clbmi on 16/05/2017.
 */
public class editAccountSteps {

    Passenger sally;

    @Given("^Sally has an account$")
    public void sallyHasAnAccount() throws Throwable {
        sally = new Passenger();
    }

    @When("^Sally changes her name to \"([^\"]*)\" and her phone number to \"([^\"]*)\"$")
    public void sallyChangesHerNameToAndHerPhoneNumberTo(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Her details are changed$")
    public void herDetailsAreChanged() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Sally changes her uc id to \"([^\"]*)\"$")
    public void sallyChangesHerUcIdTo(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Her details are not changed$")
    public void herDetailsAreNotChanged() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Jo has a driver account$")
    public void joHasADriverAccount() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Jo goes to edit his account and changes his license expiration to next year$")
    public void joGoesToEditHisAccountAndChangesHisLicenseExpirationToNextYear() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^his new license information is stored$")
    public void hisNewLicenseInformationIsStored() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
