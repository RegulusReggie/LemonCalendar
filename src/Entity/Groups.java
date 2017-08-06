package Entity;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Groups {
    private IntegerProperty groupid;
    private StringProperty groupname;
    private List<String> membersid;
    private List<String> ownersid;
    private IntegerProperty gpcalendarid;

    public Groups() {
        this.groupid = new SimpleIntegerProperty();
        this.groupname = new SimpleStringProperty();
        this.membersid = new ArrayList<String>();
        this.ownersid = new ArrayList<String>();
        this.gpcalendarid = new SimpleIntegerProperty();
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
    public List<String> getMembersId() {
        return membersid;
    }
    public void setMembersId(List<String> membersId) {
        membersid = membersId;
    }

    //ownersid
    public List<String> getOwnersId() {
        return ownersid;
    }
    public void setOwnersId(List<String> ownersId) {
        ownersid = ownersId;
    }

    //groupcalendarid
    public int getGroupCalendarId() {
        return gpcalendarid.get();
    }
    public void setGroupCalendarId(int groupcalendarId) {
        this.gpcalendarid.set(groupcalendarId);
    }
    public IntegerProperty groupcalendarIdProperty() {
        return gpcalendarid;
    }
}