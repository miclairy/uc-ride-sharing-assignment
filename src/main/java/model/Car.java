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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (numSeats != car.numSeats) return false;
        if (type != null ? !type.equals(car.type) : car.type != null) return false;
        if (colour != null ? !colour.equals(car.colour) : car.colour != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return plates != null ? plates.equals(car.plates) : car.plates == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (plates != null ? plates.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + numSeats;
        return result;
    }

    @Override
    public String toString(){
        String str = plates + " : " + year + " " + colour + " " + model + " of type" + type + " with " + numSeats;
        return str;
    }
}
