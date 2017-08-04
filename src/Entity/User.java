package Entity;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private IntegerProperty uid;
    private String username;
    private String password;
    //private List<String> gpbelongid;
    //private List<String> gpownid;
    //private IntegerProperty calendarid;
    public User() {
        this.uid = new SimpleIntegerProperty();
        this.username = new String();
        this.password = new String();
        //this.gpbelongid = new ArrayList<>();
        //this.gpownid = new ArrayList<>();
        //this.calendarid = new SimpleIntegerProperty();
    }

    // uid
    public int getUserId() {
        return uid.get();
    }
    public void setUserId(int userId) {
        this.uid.set(userId);
    }
    public IntegerProperty userIdProperty() {
        return uid;
    }

    // username
    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    // gpbelongid
    public List<String> getGpBelongId() {
        return gpbelongid;
    }

    public void setGpBelongId(List<String> ids) {
        this.gpbelongid = ids;
    }

    // gpownid
    public List<String> getGpOwnId() {
        return gpownid;
    }

    public void setGpOwnId(List<String> ids) {
        this.gpownid = ids;
    }

    // calendarid
    public int getCalendarId() {
        return calendarid.get();
    }
    public void setCalendarId(int calendarId) {
        this.calendarid.set(calendarId);
    }
    public IntegerProperty calendarIdProperty() {
        return calendarid;
    }
    */
}
