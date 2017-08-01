package Entity;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private IntegerProperty calendarid;
    private List<String> userids;
    private IntegerProperty groupid;
    private List<String> eventids;
    private IntegerProperty year;
    private IntegerProperty month;

    public Calendar() {
        this.calendarid = new SimpleIntegerProperty();
        this.userids = new ArrayList<String>();
        this.groupid = new SimpleIntegerProperty();
        this.eventids = new ArrayList<String>();
        this.year = new SimpleIntegerProperty();
        this.month = new SimpleIntegerProperty();
    }
    //calendarid
    public int getCalendarId() {
        return calendarid.get();
    }
    public void setCalendarId(int calendarId) {
        this.calendarid.set(calendarId);
    }
    public IntegerProperty calendarIdProperty() {
        return calendarid;
    }

    //userid
    public List<String> getUserIds() {
        return userids;
    }

    public void setUserId(List<String> userId) {
        userids = userId;
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

    //eventid
    public List<String> getEventId() {
        return eventids;
    }
    public void setEventId(List<String> eventId) {
        eventids = eventId;
    }


    //year
    public int getYearId() {
        return year.get();
    }
    public void setYearId(int yearId) {
        this.year.set(yearId);
    }
    public IntegerProperty yearIdProperty() {
        return year;
    }

    //month
    public int getMonthId() {
        return month.get();
    }
    public void setMonthId(int monthId) {
        this.month.set(monthId);
    }
    public IntegerProperty monthIdProperty() {
        return month;
    }
}