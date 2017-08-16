package Controller;

import Connection.Client;
import Util.Commons;
import Util.JSONObject;

public class GroupToCalendarDB {

    private GroupToCalendarDB() {}

    public static void insertG2C (int gid, int cid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERTG2C));
        reqobj.putField(Commons.CALENDAR_ID, String.valueOf(cid));
        reqobj.putField(Commons.GROUP_ID, String.valueOf(gid));
        Client.requestHanlder(reqobj);
    }
}
