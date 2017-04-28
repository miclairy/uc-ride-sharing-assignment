package model;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

/**
 * Created by clbmi on 26/04/2017.
 */
public class PasswordUtils {

    private static final Random randomSalt = new SecureRandom();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * gets next 16 bit random salt
     * @return 16 bit salt
     */
    public static byte[] getNextSalt(){
        byte[] salt = new byte[16];
        randomSalt.nextBytes(salt);
        return salt;
    }

    public static byte[] hashPassword( final char[] password, final byte[] salt) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            byte[] result = key.getEncoded();
            return result;

        } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }

    public static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) {
        byte[] pwdHash = hashPassword(password, salt);
        if (pwdHash.length != expectedHash.length) return false;
        for (int i = 0; i < pwdHash.length; i++) {
            if (pwdHash[i] != expectedHash[i]) return false;
        }
        return true;
    }

    public static boolean login(String email, String password) throws IOException, DecoderException {
        String users = new File("src/main/resources/users.csv").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(users));
        String readLine = reader.readLine();
        String readEmail;
        while (readLine != null) {
            readEmail = readLine.split(",")[0];
            if (readEmail.equals(email)) {
                String expectedHash = readLine.split(",")[1];
                String readSalt = readLine.split(",")[2];
                if (isExpectedPassword(password.toCharArray(), Hex.decodeHex(readSalt.toCharArray()), Hex.decodeHex(expectedHash.toCharArray()))){
                    return true;
                } else{
                    return false;
                }
            }
            readLine = reader.readLine();
        }
        return false;
    }
}
