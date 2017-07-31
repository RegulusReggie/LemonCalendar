package controller;
import entity.Calendar;

import java.io.Serializable;

public class CalendarFactory implements Serializable {
    private int uid;
    private int gid;
    private Calendar userCalendar;
    public CalendarFactory (int username, int groupname) {
        uid = username;
        gid = groupname;
    }
    @Override
    public String toString() { return "user is " + uid + ", group is " + gid; }
    public String UserCalendar() {
        boolean sig1 = false;
        boolean sig2 = false;
        for (int i = 0 ; i < userCalendar.getGroups().length ; i++) {
            if (gid == userCalendar.getGroups()[i]) {
                sig1 = true;
                break;
            }
        }
        for (int j = 0 ; j < userCalendar.getUsers().length ; j++) {
            if (uid == userCalendar.getUsers()[j]) {
                sig2 = true;
                break;
            }
        }
        if (sig1 || sig2) {
            return userCalendar.toString();
        }
        else {
            return "user or group calendar not found!";
        }
    }
}
