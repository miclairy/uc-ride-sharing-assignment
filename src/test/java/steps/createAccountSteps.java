package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.*;
import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by clbmi on 26/04/2017.
 */
public class createAccountSteps {

    private Driver jo;
    private String password;
    private String passwordP;
    private Map<String, String> store = new HashMap<>();
    private Map<String, String> passengerStore = new HashMap<>();
    private License license;
    private Passenger sally;

    @Given("^jo clicked become driver$")
    public void joClickedBecomeDriver() {
        jo = new Driver("");
    }

    @When("^jo enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" and he uploads a photo and enters the password \"([^\"]*)\" twice$")
    public void joEntersAndAndHeUploadsAPhotoAndEntersThePasswordTwice(String ucid, String name, String address, String phone, String email, String password) {
        this.password = password;
        store.put("ucId", ucid);
        store.put("name", name);
        store.put("address", address);
        store.put("phone", phone);
        store.put("email", email);
    }

    @Then("^the email and password are verified and he is asked for his drivers license information$")
    public void theEmailAndPasswordAreVerifiedAndHeIsAskedForHisDriversLicenseInformation() throws IOException {
        assert(jo.verifyEmail((String) store.get("email")));
        assert(jo.verifyPassword(password, password));
    }

    @When("^jo enters type \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void joEntersType(String type, String number, String issued, String expiry) throws ParseException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        license = new License(type,  number, LocalDate.parse(issued, df), LocalDate.parse(expiry, df));
    }

    @Then("^it is verified he can carry passengers$")
    public void itIsVerifiedHeCanCarryPassengers()  {
        assert(license.verify());
    }

    @Then("^his details are stored and account is created$")
    public void hisDetailsAreStoredAndAccountIsCreated() throws IOException {
        jo.setDetails(store);
        jo.setLicense(license);
        jo.storePassword(password);
        assertEquals(jo.getDetails(), store);
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String line = reader.readLine();
        String readEmail = line.split(",")[0];
        while (!(readEmail != null && readEmail.equals(store.get("email")))) {
            line = reader.readLine();
            readEmail = line.split(",")[0];
        }
        char[] encodedPassword = Hex.encodeHex(jo.getPassword());
        String strEncodedPassword = "";
        for (char c : encodedPassword){
            strEncodedPassword += c;
        }
        char[] encodedSalt = Hex.encodeHex(jo.getSalt());
        String strEncodedSalt = "";
        for (char ch : encodedSalt){
            strEncodedSalt += ch;
        }
        assertEquals(store.get("email") + "," + strEncodedPassword + "," + strEncodedSalt, line);

    }

    @Given("^sally clicked to become a passenger$")
    public void sallyClickedToBecomeAPassenger() {
        sally = new Passenger();
    }

    @When("^sally enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" and she uploads a photo and enters the password \"([^\"]*)\" twice$")
    public void sallyEntersAndAndSheUploadsAPhotoAndEntersThePasswordTwice(String ucid, String name, String address, String phone, String email, String password) {
        this.passwordP = password;
        passengerStore.put("ucId", ucid);
        passengerStore.put("name", name);
        passengerStore.put("address", address);
        passengerStore.put("phone", phone);
        passengerStore.put("email", email);
    }

    @Then("^the email and password are verified and her account is created$")
    public void theEmailAndPasswordAreVerifiedAndHerAccountIsCreated() throws IOException {
        assert(sally.verifyEmail((String) passengerStore.get("email")));
        assert(sally.verifyPassword(passwordP, passwordP));
        sally.setDetails(passengerStore);
        sally.storePassword(passwordP);
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String line = reader.readLine();
        String readEmail = line.split(",")[0];
        while (!(readEmail != null && readEmail.equals(passengerStore.get("email")))) {
            line = reader.readLine();
            readEmail = line.split(",")[0];
        }
        char[] encodedPassword = Hex.encodeHex(sally.getPassword());
        String strEncodedPassword = "";
        for (char c : encodedPassword){
            strEncodedPassword += c;
        }
        char[] encodedSalt = Hex.encodeHex(sally.getSalt());
        String strEncodedSalt = "";
        for (char ch : encodedSalt){
            strEncodedSalt += ch;
        }
        assertEquals(passengerStore.get("email") + "," + strEncodedPassword + "," + strEncodedSalt, line);
    }

    @Then("^the email fails verification and she is told the email is already in use$")
    public void theEmailFailsVerificationAndSheIsToldTheEmailIsAlreadyInUse() throws IOException {
        Passenger temp = new Passenger();
        assertFalse(temp.verifyEmail((String) passengerStore.get("email")));
        cleanUpFile((String) passengerStore.get("email"));
        cleanUpFile("jb34@uclive.ac.nz");
    }

    @Given("^sally is already signed up$")
    public void sallyIsAlreadySignedUp() throws Throwable {
        sally = new Passenger();
        this.passwordP = "liveLife";
        Map<String, String> passengerStore = new HashMap<>();
        passengerStore.put("ucId", "sal34");
        passengerStore.put("name", "sally");
        passengerStore.put("address", "23 bear street");
        passengerStore.put("phone", "1234568852");
        passengerStore.put("email", "sal34@canterbury.ac.nz");
        sally.setDetails(passengerStore);
        Data.addPassenger(sally);
    }

    private void cleanUpFile(String emailToRemove) throws IOException {
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
            if (!user.split(",")[0].equals(emailToRemove)){
                fileWriter.write(user);
            }
        }

        reader.close();
        fileWriter.close();
    }

}
