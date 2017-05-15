package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Car class to store the vehicle attributes
 */
public class Car {

    private String type;
    private String colour;
    private String model;
    private String plates;
    private int year;
    private int numSeats;
    private LocalDate wofExpiration;
    private LocalDate registrationExpiry;
    private double efficiency;

    public Car(String type, String colour, String model, String plates, int year, int numSeats) {
        this.type = type;
        this.colour = colour;
        this.model = model;
        this.plates = plates;
        this.year = year;
        this.numSeats = numSeats;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    public String getPlates() {
        return plates;
    }

    public int getYear() {
        return year;
    }

    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return plates.equals(car.plates);
    }

    @Override
    public int hashCode() {
        return plates.hashCode();
    }

    @Override
    public String toString(){
        String str = plates + " : " + year + " " + colour + " " + model + " of type " + type + " with " + numSeats + " seats.";
        return str;
    }


    public void setWofExpiration(LocalDate wofExpiration) {
        this.wofExpiration = wofExpiration;
    }

    public LocalDate getWofExpiry() {
        return wofExpiration;
    }

    public LocalDate getRegistrationExpiry() {
        return registrationExpiry;
    }

    public void setRegistrationExpiry(LocalDate registrationExpiry) {
        this.registrationExpiry = registrationExpiry;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getEfficiency() {
        return efficiency;
    }
}
