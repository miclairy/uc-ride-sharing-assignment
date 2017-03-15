package model;

import java.util.ArrayList;

/**
 * Driver user class that can register cars and driver passengers around
 */
public class Driver {

    private String name;
    private ArrayList<Car> cars = new ArrayList<>();

    public Driver(String name) {
        this.name = name;
    }


}
