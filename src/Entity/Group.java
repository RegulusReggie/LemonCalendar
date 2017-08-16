package Entity;
import Util.Commons;
import Util.JSONObject;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private IntegerProperty groupid;
    private StringProperty groupname;
    private List<Integer> membersid;
    private IntegerProperty ownerid;

    public Group() {
        this.groupid = new SimpleIntegerProperty();
        this.groupname = new SimpleStringProperty();
        this.membersid = new ArrayList<Integer>();
        this.ownerid = new SimpleIntegerProperty();
    }
    //groupid
    public int getGroupId() {
        return groupid.get();
    }
    public void setGroupId(int groupId) {
        this.groupid.set(groupId);
    }
    public IntegerProperty groupIdProperty() {
        return groupid;
    }

    //groupname
    public String getGroupName() {
        return groupname.get();
    }
    public void setGroupName(String groupName) {
        this.groupname.set(groupName);
    }

    //membersid
    public List<Integer> getMembersId() {
        return membersid;
    }
    public void setMembersId(List<Integer> membersId) {
        membersid = membersId;
    }

    //ownersid
    public int getOwnerId() {
        return ownerid.get();
    }
    public void setOwnerId(int ownerId) {
        this.ownerid.set(ownerId);
    }
    public IntegerProperty ownerIdProperty() {
        return ownerid;
    }

    public static Group parseJSON(JSONObject obj) {
        Group group = new Group();
        group.setGroupId(Integer.valueOf(obj.getField(Commons.GROUP_ID)));
        group.setGroupName(obj.getField(Commons.GROUPNAME));
        group.setMembersId(Commons.convertStringToList(obj.getField(Commons.MEMBERS_ID)));
        group.setOwnerId(Integer.valueOf(obj.getField(Commons.OWNERS_ID)));
        return group;
    }
}