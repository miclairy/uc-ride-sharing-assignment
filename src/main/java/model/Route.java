package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by cba62 on 22/03/17.
 */
public class Route {

    private List<StopPoint> stops = new ArrayList<>();
    private String name;

    public Route(List<StopPoint> stops, String name) {
        this.stops = stops;
        this.name = name;
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

    public List<StopPoint> getStops() {
        return stops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
