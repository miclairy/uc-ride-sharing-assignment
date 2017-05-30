package steps;

import model.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by clbmi on 7/05/2017.
 */
public class NotifyUserExpirationSteps {

    private Driver jo;

    @Given("^Jo has an account$")
    public void joHasAnAccount()  {
        jo = new Driver("jo");

    }

    @Given("^his license expires in one month$")
    public void hisLicenseExpiresInOneMonth() {
        LocalDate issuedDate = LocalDate.of(2000, 5, 12);
        LocalDate expiryDate = LocalDate.now().plusMonths(1);
        License license = new License("full", "FR346568", issuedDate, expiryDate);
        jo.setLicense(license);
    }

    @When("^logs in$")
    public void logsIn() {
        Data.setDriverUser(jo);
    }

    @Then("^he will be notified that his license going to expire\\.$")
    public void heWillBeNotifiedThatHisLicenseGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        notify.add(ExpiryNotifactions.Expired.LICENSE);
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }

    @Given("^his WOF expires in one month$")
    public void hisWOFExpiresInOneMonth() throws InvalidDataException {
        Car car = new Car("car", "Blue", "Subarbu", "FR2534", 2001, 5);
        car.setWofExpiration(LocalDate.now().plusMonths(1));
        car.setRegistrationExpiry(LocalDate.of(2100, 5, 12));
        jo.addCar(car);

        jo.setLicense(new License("Full", "RT3464858", LocalDate.of(2000, 5, 8),
                LocalDate.of(8100, 5, 8)));
    }

    @Then("^he will be notified that s WOF is going to expire\\.$")
    public void heWillBeNotifiedThatSWOFIsGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        notify.add(ExpiryNotifactions.Expired.WOF);
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }

    @Given("^his registration expires in one month$")
    public void hisRegistrationExpiresInOneMonth() throws InvalidDataException {
        Car car = new Car("car", "Blue", "Subarbu", "FR2534", 2001, 5);
        car.setRegistrationExpiry(LocalDate.now().plusMonths(1));
        car.setWofExpiration(LocalDate.of(2100, 7, 5));
        jo.addCar(car);
    }

    @Then("^he will be notified that the registration and license are going to expire\\.$")
    public void heWillBeNotifiedThatTheRegistrationAndLicenseAreGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        notify.add(ExpiryNotifactions.Expired.REGISTRATION);
        notify.add(ExpiryNotifactions.Expired.LICENSE);
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }

    @Given("^his registration expires in (\\d+) weeks$")
    public void hisRegistrationExpiresInWeeks(int weeks) throws InvalidDataException {
        Car car = new Car("car", "Blue", "Subarbu", "FR2534", 2001, 5);
        car.setRegistrationExpiry(LocalDate.now().plusWeeks(weeks));
        car.setWofExpiration(LocalDate.of(2100, 5, 7));
        jo.addCar(car);
        jo.setLicense(new License("Full", "RT3464858", LocalDate.of(2000, 5, 8),
                LocalDate.of(8100, 5, 8)));
    }

    @Then("^he will not be notified that it is going to expire\\.$")
    public void heWillNotBeNotifiedThatItIsGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }
}
