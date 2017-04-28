package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Data;
import model.PasswordUtils;
import org.apache.commons.codec.DecoderException;

import java.io.IOException;

/**
 * Created by clbmi on 26/04/2017.
 */
public class LoginController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    public void submit() throws IOException, DecoderException {
       boolean valid = PasswordUtils.login(email.getText(), password.getText());
       if (valid){
           Data.openAccount(email.getText());
       }
    }

}
