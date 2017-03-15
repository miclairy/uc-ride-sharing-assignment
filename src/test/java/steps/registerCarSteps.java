package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Driver;

/**
 * Created by cba62 on 15/03/17.
 */


public class registerCarSteps {

    Driver jo;

    @Given("^Jo is a driver$")
    public void jo_is_a_driver() throws Throwable {

        jo = new Driver("Jo");
    }

    @Given("^Jo has a car with (\\d+) seats$")
    public void jo_has_a_car_with_seats(int seats) throws Throwable {

        int seatNum = seats;
    }


    @Given("^license plate \"([^\"]*)\"$")
    public void license_plate(String plate) throws Throwable {

        System.out.println(plate);
    }

    @Given("^the car colour is \"([^\"]*)\"$")
    public void the_car_colour_is(String colour) throws Throwable {

        System.out.println(colour);
    }


    @Given("^year (\\d+)$")
    public void year(int year) throws Throwable {

        System.out.println(year);
    }


    @When("^the car is registered$")
    public void the_car_is_registered() throws Throwable {

        //throw new PendingException();
    }

    @Then("^the car's attributes of year (\\d+), license plate \"([^\"]*)\", colour \"([^\"]*)\" and (\\d+) seats are stored\\.$")
    public void the_car_s_attributes_of_year_license_plate_colour_and_seats_are_stored(int year, String plate, String colour, int seats) throws Throwable {
        System.out.println(year + plate + colour + seats);
    }


}
