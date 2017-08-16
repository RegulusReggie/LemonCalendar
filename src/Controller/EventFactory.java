package Controller;
import Connection.Client;
import Entity.Event;
import Util.JSONObject;

import Util.Commons;

public class EventFactory {
    private EventFactory() {}

    public static Event searchEventByEID (int eid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_EVENT_BY_ID));
        reqobj.putField(Commons.EVENT_ID, String.valueOf(eid));
        return (Event) Client.requestHanlder(reqobj);
    }

    public static Event searchEventByDate (int year, int month, int day) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_EVENT_BY_DATE));
        reqobj.putField(Commons.YEAR, String.valueOf(year));
        reqobj.putField(Commons.MONTH, String.valueOf(month));
        reqobj.putField(Commons.DAY, String.valueOf(day));
        return (Event) Client.requestHanlder(reqobj);
    }

    public static int insertEvent (int year, int month, int day, String description, int cid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERT_EVENT));
        reqobj.putField(Commons.YEAR, String.valueOf(year));
        reqobj.putField(Commons.MONTH, String.valueOf(month));
        reqobj.putField(Commons.DAY, String.valueOf(day));
        reqobj.putField(Commons.DESCRIPTION, description);
        reqobj.putField(Commons.CALENDAR_ID, String.valueOf(cid));
        return (Integer) Client.requestHanlder(reqobj);
    }
}
