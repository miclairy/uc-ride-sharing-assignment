package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;

import static org.junit.Assert.assertEquals;

/**
 * bob creates stop point then sally creates another and a duplicate is not made.
 */
public class createStopPointSteps {

    private Driver bob;
    private Driver sally;
    private int number;
    private String address;

    @Given("^bob is a driver$")
    public void bob_is_a_driver() {
        bob = new Driver("bob");
    }

    @When("^bob creates a stop point at (\\d+) \"([^\"]*)\"$")
    public void bob_creates_a_stop_point_at(int number, String address) {
        this.number = number;
        this.address = address;
        bob.createStopPoint(number, address);
    }


    @Then("^the street address is stored as a stop point$")
    public void the_street_address_is_stored_as_a_stop_point() {
        assertEquals(1, Data.stopPoints.size());
        assert(Data.stopPoints.contains(new StopPoint(number, address)));
}

    @Given("^Sally is a driver$")
    public void sally_is_a_driver(){
        sally = new Driver("sally");
    }

    @When("^Sally creates a stop point at (\\d+) \"([^\"]*)\" after bob$")
    public void sally_creates_a_stop_point_at_after_bob(int number, String address) throws Throwable {
        sally.createStopPoint(number, address);
    }

    @Then("^a new stop point is not made$")
    public void a_new_stop_point_is_not_made() {
        assertEquals(1, Data.stopPoints.size());
    }
}
