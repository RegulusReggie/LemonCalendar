package UI;

import javafx.event.ActionEvent;
import javafx.scene.text.Text;

public class LoginController {

    public Text actiontarget;
    public void btn_signin(ActionEvent actionEvent) {
        actiontarget.setText("Open the main window or \"wrong pw\"");
    }

    public void btn_signup(ActionEvent actionEvent) {



    }
}
