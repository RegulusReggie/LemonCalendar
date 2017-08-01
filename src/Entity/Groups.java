package Entity;
import javafx.beans.property.*;

public class Groups {
    private IntegerProperty groupid;
    private String groupname;
    private String membersid;
    private String ownersid;
    private IntegerProperty gpcalendarid;

    public Groups() {
        this.groupid = new SimpleIntegerProperty();
        this.groupname = new String();
        this.membersid = new String();
        this.ownersid = new String();
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
        return groupname;
    }
    public void setGroupName(String groupName) {
        groupname = groupName;
    }

    //membersid
    public String getMembersId() {
        return membersid;
    }
    public void setMembersId(String membersId) {
        membersid = membersId;
    }

    //ownersid
    public String getOwnersId() {
        return ownersid;
    }
    public void setOwnersId(String ownersId) {
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