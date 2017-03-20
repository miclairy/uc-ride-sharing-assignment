package model;

/**
 * Created by clbmi on 18/03/2017.
 */
public class StopPoint {

    private int streetNumber;
    private String suburb;
    private String streetName;

    public StopPoint(int streetNumber, String streetName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
    }

    public StopPoint(int streetNumber, String streetName, String suburb) {
        this.streetNumber = streetNumber;
        this.suburb = suburb;
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopPoint stopPoint = (StopPoint) o;

        if (streetNumber != stopPoint.streetNumber) return false;
        if (suburb != null ? !suburb.equals(stopPoint.suburb) : stopPoint.suburb != null) return false;
        return streetName != null ? streetName.equals(stopPoint.streetName) : stopPoint.streetName == null;

    }

    @Override
    public int hashCode() {
        int result = streetNumber;
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String str = streetNumber + " " +
                streetName + " \n";
        if (!(suburb == null)) {
            str += " " + suburb;
        }
        return str;
    }
}
