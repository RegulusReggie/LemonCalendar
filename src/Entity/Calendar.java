package Entity;

import Controller.EventFactory;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private IntegerProperty calendarid;
    private List<String> userids;
    private IntegerProperty groupid;
    private List<String> eventids;
    private IntegerProperty year;
    private IntegerProperty month;
    private Map<Integer, List<Event>> eventsMap;

    public Calendar() {
        this.calendarid = new SimpleIntegerProperty();
        this.userids = new ArrayList<>();
        this.groupid = new SimpleIntegerProperty();
        this.eventids = new ArrayList<>();
        this.year = new SimpleIntegerProperty();
        this.month = new SimpleIntegerProperty();
        this.eventsMap = new HashMap<>();
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
    public List<String> getUserId() {
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
        for (String id : eventId) {
            Event e = EventFactory.getEventById(Integer.valueOf(id), year.get(), month.get(), calendarid.get());
            addEvent(e);
        }
    }

    //year
    public int getYear() {
        return year.get();
    }
    public void setYear(int year) {
        this.year.set(year);
    }
    public IntegerProperty yearProperty() {
        return year;
    }

    //month
    public int getMonth() {
        return month.get();
    }
    public void setMonth(int month) {
        this.month.set(month);
    }
    public IntegerProperty monthProperty() {
        return month;
    }

    public void addEvent(Event eve) {
        List<Event> eveList = eventsMap.get(eve.getDay());
        if (eveList == null) {
            eveList = new ArrayList<Event>();
            eveList.add(eve);
            eventsMap.put(eve.getDay(), eveList);
        } else {
            eveList.add(eve);
        }
    }

    public List<Event> getEventListByDay(int day) {
        return eventsMap.get(day);
    }
}