package Entity;

public class Event {
    private String eid;
    private int year;
    private int month;
    private int day;
    private String description;
    public Event(String id, int y, int m, int d, String desc) {
        eid = id;
        year = y;
        month = m;
        day = d;
        description = desc;
    }
    public String getEventDate() {
        return String.format("%d-%d-%d", year, month, day);
    }
    public String getID() { return eid; }
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public String getDescription() { return description; }
}
