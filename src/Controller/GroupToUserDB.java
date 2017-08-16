package Controller;

import Connection.Client;
import Util.Commons;
import Util.JSONObject;

import java.sql.SQLException;
import java.util.List;

public class GroupToUserDB {

    private GroupToUserDB() {}

    public static void insertG2U (int gid, int uid) throws SQLException, ClassNotFoundException {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERTG2U));
        reqobj.putField(Commons.USER_ID, String.valueOf(uid));
        reqobj.putField(Commons.GROUP_ID, String.valueOf(gid));
        Client.requestHanlder(reqobj);
    }

    public static List<Integer> getGroupsByUserId(int uid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_GET_GROUPS_BY_USER_ID));
        reqobj.putField(Commons.USER_ID, String.valueOf(uid));
        return Commons.convertStringToList((String) Client.requestHanlder(reqobj));
    }
}