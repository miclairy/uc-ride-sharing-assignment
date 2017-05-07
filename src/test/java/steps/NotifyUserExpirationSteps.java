package steps;

import controllers.ExpiryNotifactions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Car;
import model.Data;
import model.Driver;
import model.License;

import java.time.LocalDate;
import java.time.Year;
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
        Calendar issuedDate = new GregorianCalendar();
        Calendar expiryDate = new GregorianCalendar();
        issuedDate.set(2000, 5, 12);
        expiryDate.setTime(new Date());
        expiryDate.add(Calendar.MONTH, 1);
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
    public void hisWOFExpiresInOneMonth() {
        Car car = new Car("car", "Blue", "Subarbu", "FR2534", 2001, 5);
        car.setWofExpiration(LocalDate.now().plusMonths(1));
        car.setRegistrationExpiry(LocalDate.of(2100, 5, 12));
        jo.addCar(car);

        jo.setLicense(new License("Full", "RT3464858", new GregorianCalendar(2000, 5, 8),
                new GregorianCalendar(8100, 5, 8)));
    }

    @Then("^he will be notified that s WOF is going to expire\\.$")
    public void heWillBeNotifiedThatSWOFIsGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        notify.add(ExpiryNotifactions.Expired.WOF);
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }

    @Given("^his registration expires in one month$")
    public void hisRegistrationExpiresInOneMonth() {
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
    public void hisRegistrationExpiresInWeeks(int weeks) {
        Car car = new Car("car", "Blue", "Subarbu", "FR2534", 2001, 5);
        car.setRegistrationExpiry(LocalDate.now().plusWeeks(weeks));
        car.setWofExpiration(LocalDate.of(2100, 5, 7));
        jo.addCar(car);
        jo.setLicense(new License("Full", "RT3464858", new GregorianCalendar(2000, 5, 8),
                new GregorianCalendar(8100, 5, 8)));
    }

    @Then("^he will not be notified that it is going to expire\\.$")
    public void heWillNotBeNotifiedThatItIsGoingToExpire() {
        Set<ExpiryNotifactions.Expired> notify = new HashSet<>();
        assertEquals(notify, ExpiryNotifactions.checkNotifyUser(jo));
    }
}
