package entity;
import java.io.Serializable;

public class Calendar implements Serializable{
    private int calendarid;
    private int[] userid;
    private int[] groupid;
    public Calendar(int cid, int[] uid, int[] gid) {
        calendarid = cid;
        userid = uid;
        groupid = gid;
    }
    @Override
    public String toString() { return "Calendar id is " + calendarid + ", users are " + userid + ", groups are " + groupid; }
    public int getCalendarid() { return calendarid; }
    public int[] getUsers() { return userid; }
    public int[] getGroups() { return groupid; }
}