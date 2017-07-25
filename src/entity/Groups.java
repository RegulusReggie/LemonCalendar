package entity;
import java.io.Serializable;

public class Groups implements Serializable{
    private int gid;
    private String groupname;
    private int[] membersid;
    private int[] ownersid;
    private int gpcalendarid;
    public Groups(int groupid, String name, int[] members, int[] owners, int groupcalendar) {
        gid = groupid;
        groupname = name;
        membersid = members;
        ownersid = owners;
        gpcalendarid = groupcalendar;
    }
    @Override
    public String toString() { return "group name is " + groupname + ", id is " + gid; }
    public int getGid() { return gid; }
    public String getName() { return groupname; }
    public int[] getMembers() { return membersid; }
    public int[] getOwners() { return ownersid; }
    public int getCalendar() { return gpcalendarid; }
}