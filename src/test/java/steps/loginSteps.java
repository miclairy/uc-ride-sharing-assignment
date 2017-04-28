package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Account;
import model.Driver;
import model.PasswordUtils;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;


/**
 * Created by clbmi on 28/04/2017.
 */
public class loginSteps {

    private Account jo;
    private Account sally;
    private String password;
    private String email;

    @Given("^jo has an account$")
    public void joHasAnAccount() throws IOException {
        jo = new Account();
        Map<String, Object> store = new HashMap<>();
        store.put("ucId", "jba23");
        store.put("name", "jo");
        store.put("address", "6 hare");
        store.put("phone", (long) 5555552);
        store.put("email", "jba12@uclive.ac.nz");
        jo.setDetails(store);
        jo.storePassword("123Abc");

    }

    @When("^he enters the correct email and password$")
    public void heEntersTheCorrectEmailAndPassword() {
        password = "123Abc";
        email = (String) jo.getDetails().get("email");

    }

    @Then("^he is let into his account with his trips etc$")
    public void heIsLetIntoHisAccountWithHisTripsEtc() throws IOException, DecoderException {

        assert PasswordUtils.login(email, password);

    }

    @Given("^jo doesn't have an account$")
    public void joDoesnTHaveAnAccount() throws IOException {
        sally = new Account();
        Map<String, Object> store = new HashMap<>();
        store.put("ucId", "sal34");
        store.put("name", "sally");
        store.put("address", "8 bear");
        store.put("phone", (long) 599720263);
        store.put("email", "123@uclive.ac.nz");
        sally.setDetails(store);
        sally.storePassword("pass");
    }

    @When("^jo tries to log in$")
    public void joTriesToLogIn() {
        password = "Prince";
        email = "dfjk4@uclive.ac.nz";
    }

    @Then("^he is told the credentials are wrong$")
    public void heIsToldTheCredentialsAreWrong() throws IOException, DecoderException {
        assertFalse(PasswordUtils.login(email, password));
    }

}
