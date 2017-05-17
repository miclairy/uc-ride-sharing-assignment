package model;

import model.Car;
import model.Driver;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by clbmi on 7/05/2017.
 */
public class ExpiryNotifactions {

    public enum Expired{
        LICENSE, WOF, REGISTRATION;
    }

    public static boolean checkIfNotify(LocalDate expirationDate){

        if (expirationDate.equals(LocalDate.now().plusMonths(1))){
            return true;
        }
        if (expirationDate.equals(LocalDate.now().plusWeeks(1))){
            return true;
        }
        if (expirationDate.equals(LocalDate.now().plusWeeks(2))){
            return true;
        }

        return false;

    }

    public static Set<Expired> checkNotifyUser(Driver driver){
        Set<Expired> expired = new HashSet<>();

        LocalDate licenseExpiry = driver.getLicense().getExpiry();
        boolean licenseNotify = checkIfNotify(licenseExpiry);
        boolean wofNotify = false;
        boolean regoNotify = false;

        for (Car car : driver.getCars()){
            wofNotify = checkIfNotify(car.getWofExpiry());
            regoNotify = checkIfNotify(car.getRegistrationExpiry());
        }

        if (licenseNotify){
            expired.add(Expired.LICENSE);
        }
        if (regoNotify){
            expired.add(Expired.REGISTRATION);
        }
        if (wofNotify){
            expired.add(Expired.WOF);
        }

        return expired;
    }
}
