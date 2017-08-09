package Controller;

import Entity.Group;
import Entity.User;
import Util.Commons;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CreateGroupController {

    public TextField groupname;
    public TextArea  groupmember;
    public Label actionTarget;
    public Button bt_create;
    public Button bt_cancel;
    private int userId;
    private Consumer<Pair<String, Integer>> callback;

    void setCallback(Consumer<Pair<String, Integer>> callback) {
        this.callback = callback ;
    }

    void setUserId(int uid) {userId = uid; }

    public void btcreate(ActionEvent actionEvent) {
        if (groupname.getText().isEmpty()) {
            actionTarget.setText("Please enter a group name");
            return;
        }
        try {
            if (GroupFactory.searchGroup(groupname.getText()) != null) {
                actionTarget.setText("Group Name is taken, try another");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!groupmember.getText().matches("([A-Za-z]+ )*([A-Za-z]+)")) {
            actionTarget.setText("Please enter valid members.");
            return;
        }

        List<String> members = Commons.convertStringToStringList(groupmember.getText());
        List<Integer> memberIds = new ArrayList<>();
        for (String memberName : members) {
            User u;
            try {
                u = UserFactory.getUserByName(memberName);
                if (u == null) {
                    System.err.println("Cannot find user with name '" + memberName + "'.");
                } else {
                    memberIds.add(u.getUserId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            int gid = GroupFactory.insertGp(groupname.getText(), memberIds, userId);
            for (int id : memberIds) {
                GroupToUserDB.insertG2U(gid, id);
            }
            GroupToUserDB.insertG2U(gid, userId);

            if (callback != null) callback.accept(new Pair<>(groupname.getText(), gid));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage=(Stage) bt_create.getScene().getWindow();
        stage.close();
    }

    public void btcancel(ActionEvent actionEvent) {
        Stage stage=(Stage) bt_cancel.getScene().getWindow();
        stage.close();
    }
}
