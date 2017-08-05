package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateGroupController {

    public TextField groupname;
    public TextArea  groupmember;
    public Button bt_create;
    public Button bt_cancel;

    public void btcreate(ActionEvent actionEvent) {
        System.out.println("group name is " +groupname.getText());
        System.out.println("group members are "+groupmember.getText());
        Stage stage=(Stage) bt_create.getScene().getWindow();
        stage.close();
    }

    public void btcancel(ActionEvent actionEvent) {
        Stage stage=(Stage) bt_cancel.getScene().getWindow();
        stage.close();
    }
}
