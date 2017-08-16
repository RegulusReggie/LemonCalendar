package Controller;
import Connection.Client;
import Entity.Calendar;
import Util.JSONObject;
import Util.Commons;

import java.util.*;


public class CalendarFactory {

    private CalendarFactory() {}

    public static Calendar searchCalendar (int cid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_CALENDAR_BY_ID));
        reqobj.putField(Commons.CALENDAR_ID, String.valueOf(cid));
        return (Calendar) Client.requestHanlder(reqobj);
    }

    public static Calendar searchCalendar (int gid, int year, int month) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_CALENDAR_BY_GROUP_YEAR_MONTH));
        reqobj.putField(Commons.GROUP_ID, String.valueOf(gid));
        reqobj.putField(Commons.YEAR, String.valueOf(year));
        reqobj.putField(Commons.MONTH, String.valueOf(month));
        return (Calendar) Client.requestHanlder(reqobj);
    }

    public static void updateCalEvent (int calId, List<Integer> calEvent) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_UPDATE_CALENDAR_EVENT));
        reqobj.putField(Commons.CALENDAR_ID, String.valueOf(calId));
        reqobj.putField(Commons.CALENDAR_EVENT_IDS, Commons.convertListToString(calEvent));
        Client.requestHanlder(reqobj);
    }

    public static int insertCal (List<Integer> eventids, int year, int month) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERT_CALENDAR));
        reqobj.putField(Commons.CALENDAR_EVENT_IDS, Commons.convertListToString(eventids));
        reqobj.putField(Commons.YEAR, String.valueOf(year));
        reqobj.putField(Commons.MONTH, String.valueOf(month));
        return (Integer) Client.requestHanlder(reqobj);
    }
}
