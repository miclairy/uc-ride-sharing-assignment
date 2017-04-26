package model;

import java.util.Date;

/**
 * Created by clbmi on 26/04/2017.
 */
public class License {

    private String type; //todo enum of license types????????
    private String number;
    private Date issued;
    private Date expiry;


    public License(String type, String number, Date issued, Date expiry) {
        this.type = type;
        this.number = number;
        this.issued = issued;
        this.expiry = expiry;
    }

    public boolean verify(){
        if (issued.before(expiry) && expiry.after(new Date())){
            return type.equals("full") || type.equals("full for 2 years");
        }
        return false;
    }
}
