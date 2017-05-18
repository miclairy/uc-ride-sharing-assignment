package model;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by clbmi on 26/04/2017.
 */
public class License {

    private String type; //todo enum of license types????????
    private String number;
    private LocalDate issued;
    private LocalDate expiry;


    public License(String type, String number, LocalDate issued, LocalDate expiry) {
        this.type = type;
        this.number = number;
        this.issued = issued;
        this.expiry = expiry;
    }

    public boolean verify(){
        if (issued.isBefore(expiry) && expiry.isAfter(LocalDate.now())){
            return type.toLowerCase().equals("full") || type.equals("full for 2 years");
        }
        return false;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        License license = (License) o;

        return number.equals(license.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public void upDateExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getIssued() {
        return issued;
    }
}
