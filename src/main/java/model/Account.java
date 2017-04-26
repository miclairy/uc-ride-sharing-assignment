package model;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by clbmi on 26/04/2017.
 */
public class Account {

    private String name;
    private String address;
    private long phone;
    private String email;
    private byte[] password;
    private byte[] salt;
    private String ucId;

    public boolean verifyEmail(String email){
        for (Account account: Data.drivers){
            if (account.email.equals(email)){
                return false;
            }
        }
        for (Account account: Data.drivers){
            if (account.email.equals(email)){
                return false;
            }
        }
        return email.endsWith("@uclive.ac.nz") || email.endsWith("@canterbury.ac.nz");
    }

    public boolean verifyPassword(String password, String passwordCheck){
        return password.equals(passwordCheck);
    }

    public void setDetails(Map<String, Object> store) {
        ucId = (String) store.get("ucId");
        name = (String) store.get("name");
        address = (String) store.get("address");
        phone = (long) store.get("phone");
        email = (String) store.get("email");
    }

    public Map<String, Object> getDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("ucId", ucId);
        details.put("name", name);
        details.put("address", address);
        details.put("phone", phone);
        details.put("email", email);
        return Collections.unmodifiableMap(details);
    }

    public void storePassword(String password) {
        salt = PasswordUtils.getNextSalt();
        this.password = PasswordUtils.hashPassword(password.toCharArray(), salt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }
}
