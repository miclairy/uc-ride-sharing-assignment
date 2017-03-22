package model;

import java.util.ArrayList;

/**
 * Created by cba62 on 22/03/17.
 */
public class Route {

    ArrayList<StopPoint> stops = new ArrayList<>();

    public Route(ArrayList<StopPoint> stops) {
        this.stops = stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return stops != null ? stops.equals(route.stops) : route.stops == null;
    }

    @Override
    public int hashCode() {
        return stops != null ? stops.hashCode() : 0;
    }
}
