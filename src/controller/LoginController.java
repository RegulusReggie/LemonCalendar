package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    public TextField username;
    public PasswordField pw;
    public Text actiontarget;
    public void btn_signin(ActionEvent actionEvent) {
        if ((username.getText() != null) && !username.getText().isEmpty()) {
            actiontarget.setText("Username: " + username.getText());

            //check if usrname exist;
            //check if usrname and pw match;
            //if no, actiontarget.setText("do not match");
            //if yes, open new window.
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../UI/calendar.fxml"));
                Parent loginParent = fxmlLoader.load();
                CalendarController controller = fxmlLoader.getController();
                controller.setUserId(0);
                Stage stage=(Stage) username.getScene().getWindow();
                stage.setTitle("Calendar");
                stage.setScene(new Scene(loginParent));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            actiontarget.setText("plz put ur usrname.");
        }
    }
    public void btn_signup(ActionEvent actionEvent) {



    }
}
