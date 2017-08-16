package Controller;

import Connection.Client;
import Entity.User;
import Util.Commons;
import Util.JSONObject;

public class UserFactory {
    private UserFactory() {}

    public static User getUserById (int uid) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_USER_BY_ID));
        reqobj.putField(Commons.USER_ID, String.valueOf(uid));
        return (User) Client.requestHanlder(reqobj);
    }

    public static User getUserByName (String username) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_USER_BY_NAME));
        reqobj.putField(Commons.USERNAME, username);
        return (User) Client.requestHanlder(reqobj);
    }

    public static int insertUser (String username, String password) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_INSERT_USER));
        reqobj.putField(Commons.USERNAME, username);
        reqobj.putField(Commons.PASSWORD, password);
        return (Integer) Client.requestHanlder(reqobj);
    }

    public static int checkLogin(String username, String password) {
        JSONObject reqobj = new JSONObject();
        reqobj.putField(Commons.TYPE, String.valueOf(Commons.REQ_SEARCH_USER_BY_NAME));
        reqobj.putField(Commons.USERNAME, username);
        User user = (User) Client.requestHanlder(reqobj);
        if (user == null)
            System.out.println("No user match");
        else if (!user.getPassword().equals(password))
            System.out.println("Password doesn't match");
        else
            return user.getUserId();
        return -1;
    }
}
