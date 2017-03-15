package model;

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
}
