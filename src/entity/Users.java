package entity;
import java.io.Serializable;

public class Users implements Serializable{
    private int uid;
    private String account;
    private String password;
    private int[] gpbelongid;
    private int[] gpownid;
    private int calendarid;
    public Users(String name, String pass, int[] gpbid, int[] gpoid, int calid) {
        account = name;
        password = pass;
        gpbid = gpbelongid;
        gpoid = gpownid;
        calid = calendarid;
    }
    @Override
    public String toString() { return "account is " + account + ", password is " + password; }
    public String getAccount() { return account; }
    public String getPassword() { return password; }
    public int[] getGroupBelong() { return gpbelongid; }
    public int[] getGroupOwn() { return gpownid; }
    public int getCalendar() { return calendarid; }
}
