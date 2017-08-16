package Controller;
import Connection.Client;
import Entity.Group;
import Util.JSONObject;
import Util.Commons;

import java.util.List;

public class GroupFactory {

    public static Group searchGroup (int gpid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_GROUP_BY_ID));
        reqobj.putField(Commons.GROUP_ID, String.valueOf(gpid));
        return (Group) Client.requestHanlder(reqobj);
    }

    public static Group searchGroup (String name) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_GROUP_BY_NAME));
        reqobj.putField(Commons.GROUPNAME, name);
        return (Group) Client.requestHanlder(reqobj);
    }

    public static int insertGp (String name, List<Integer> members, int owner) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERT_GROUP));
        reqobj.putField(Commons.GROUPNAME, name);
        reqobj.putField(Commons.OWNERS_ID, String.valueOf(owner));
        reqobj.putField(Commons.MEMBERS_ID, Commons.convertListToString(members));
        return (Integer) Client.requestHanlder(reqobj);
    }
}
