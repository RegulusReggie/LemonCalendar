package UI;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;

public class LoginController {
    public TextField username;
    public PasswordField pw;
    public Text actiontarget;
    public void btn_signin(ActionEvent actionEvent) {
        if ((username.getText() != null) && !username.getText().isEmpty()) {
            actiontarget.setText("Username: " + username.getText());
            System.out.println("Username: " + username.getText());
            System.out.println("ps: "+ pw.getText());

            //check if usrname exist;
            //check if usrname and pw match;
            //if no, actiontarget.setText("do not match");
            //if yes, open new window.

        } else {
            actiontarget.setText("plz put ur usrname.");
        }
    }
    public void btn_signup(ActionEvent actionEvent) {



    }
}
