package model;

import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.util.*;

/**
 * Created by clbmi on 26/04/2017.
 */
public class Passenger {

    private String name;
    private String address;
    private String phone;
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

    public void setDetails(Map<String, String> store) {

        if (ucId == null) {
            ucId = store.get("ucId");
        }
        if (store.get("name") != null) {
            name = store.get("name");
        }
        if (store.get("address") != null) {
            address = store.get("address");
        }
        if (store.get("phone") != null) {
            phone = store.get("phone");
        }
        if (email == null) {
            email = store.get("email");
        }
    }


    public Map<String, String> getDetails() {
        Map<String, String> details = new HashMap<>();
        details.put("ucId", ucId);
        details.put("name", name);
        details.put("address", address);
        details.put("phone", phone);
        details.put("email", email);
        return Collections.unmodifiableMap(details);
    }

    @Override
    public String toString(){
        return "Uc Id: " + ucId + "\nEmail: " + email + "\nName: " + name + "\nAddress: " + address +
                "\nPhone number: " + phone;
    }

    public void storePassword(String password) throws IOException {
        salt = PasswordUtils.getNextSalt();
        this.password = PasswordUtils.hashPassword(password.toCharArray(), salt);
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        FileWriter fileWriter = new FileWriter(users, true);
        char[] encodedPassword = Hex.encodeHex(this.password);
        String strEncodedPassword = "";
        for (char c : encodedPassword){
            strEncodedPassword += c;
        }
        char[] encodedSalt = Hex.encodeHex(salt);
        String strEncodedSalt = "";
        for (char ch : encodedSalt){
            strEncodedSalt += ch;
        }
        fileWriter.append(email + "," + strEncodedPassword + "," + strEncodedSalt + "\n");
        fileWriter.close();
    }

    public void changePassword(String password) throws IOException {

        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String line = reader.readLine();
        List<String> usersBuffer = new ArrayList<>();
        while (line != null){
            usersBuffer.add(line + "\n");
            line = reader.readLine();

        }
        FileWriter fileWriter = new FileWriter(users);
        for (String user: usersBuffer){
            if (!user.split(",")[0].equals(email)){
                fileWriter.write(user);
            }
        }

        reader.close();
        fileWriter.close();

        storePassword(password);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger account = (Passenger) o;

        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        return ucId != null ? ucId.equals(account.ucId) : account.ucId == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (ucId != null ? ucId.hashCode() : 0);
        return result;
    }
}
