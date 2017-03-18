package steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Car;
import model.Driver;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * 2 scenarios one to test if car is registered and associated to driver with correct attributes and one to test that
 * they can register another car TODO: test that registered car has different license plate option to use car already
 * registered
 */


public class registerCarSteps {

    Driver jo;
    int seatNum;
    String plateNum;
    String colour;
    int year;
    String type;
    String model;

    @Given("^Jo is a driver$")
    public void jo_is_a_driver() throws Throwable {

        jo = new Driver("Jo");
    }


    @Given("^Jo has a car with (\\d+) seats and type is \"([^\"]*)\"$")
    public void jo_has_a_car_with_seats_and_type_is(int seatNum, String type) throws Throwable {
        this.seatNum = seatNum;
        this.type = type;
    }

    @Given("^the car colour is \"([^\"]*)\", model is \"([^\"]*)\"$")
    public void the_car_colour_is_model_is(String colour, String model) throws Throwable {
        this.colour = colour;
        this.model = model;
    }


    @Given("^license plate \"([^\"]*)\"$")
    public void license_plate(String plate) throws Throwable {

        plateNum = plate;
    }


    @Given("^year (\\d+)$")
    public void year(int year) throws Throwable {

        this.year = year;
    }


    @When("^the car is registered$")
    public void the_car_is_registered() throws Throwable {

        Car car = new Car(type, colour, model, plateNum, year, seatNum);
        jo.addCar(car);
    }

    @Then("^the car's attributes of year (\\d+), license plate \"([^\"]*)\", colour \"([^\"]*)\" and (\\d+) seats are stored\\.$")
    public void the_car_s_attributes_of_year_license_plate_colour_and_seats_are_stored(int year, String plate, String colour, int seats) throws Throwable {
        Car car = new Car(type, colour, model, plateNum, year, seatNum);
        assertEquals(car, jo.getCars().get(0));
    }


    @Given("^Jo has a car registered a car$")
    public void jo_has_a_car_registered_a_car() throws Throwable {
        jo = new Driver("jo");
        jo.addCar(new Car("small", "blue", "Mazda", "YTS123", 2000, 5));
        assert(jo.getCars().size() > 0);
    }


    @When("^jo registers a new car$")
    public void jo_registers_a_new_car() throws Throwable {
        Car car = new Car("Minivan", "yellow", "BMW", "MIN356", 1980, 8);
        jo.addCar(car);
    }


    @Then("^the car's is registered and jo has add the car to his account$")
    public void the_car_s_is_registered_and_jo_has_add_the_car_to_his_account() throws Throwable {
        assert(jo.getCars().size() > 1);
    }


}
