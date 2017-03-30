package model;

import java.util.GregorianCalendar;

/**
 * Created by cba62 on 31/03/17.
 */
public class Ride {

    private Trip trip;
    private GregorianCalendar time;
    private int availableSeats;

    public Ride(Trip trip, GregorianCalendar time, int availableSeats) {
        this.trip = trip;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
