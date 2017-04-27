package model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    public boolean verifyEmail(String email) throws IOException {
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String readLine = reader.readLine();
        String readEmail;
         while (readLine != null) {
                readEmail = readLine.split(",")[0];
                if (readEmail.equals(email)) {
                    return false;
                }
                readLine = reader.readLine();
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

    public void storePassword(String password) throws IOException {
        salt = PasswordUtils.getNextSalt();
        this.password = PasswordUtils.hashPassword(password.toCharArray(), salt);
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        FileWriter fileWriter = new FileWriter(users, true);
        fileWriter.append(email + "," + this.password + "," + salt + "\n");
        fileWriter.close();
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

    public void setPassword(byte[] password) {
        this.password = password;
    }
}
