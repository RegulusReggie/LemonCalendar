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

public class SignUpController {
    public TextField newUser;
    public PasswordField newPassword;

    public void btn_submit(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../UI/Login.fxml"));
            Parent submitParent = fxmlLoader.load();
            Stage stage=(Stage) newUser.getScene().getWindow();
            stage.setScene(new Scene(submitParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
