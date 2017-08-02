package controller;
import Entity.Groups;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupFactory {

    private static List<String> convertStringToList(String s, String delimiter) {
        if (s != null) {
            return Arrays.asList(s.split(delimiter));
        }
        else {
            return new ArrayList<>();
        }
    }

    private static String convertListToString(List<String> list, String delimiter) {
        String s = new String();
        for (String ele : list) {
            s = s + ele + delimiter;
        }
        return s;
    }

    public static Groups searchGroups (int gpid) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM GROUPS WHERE GROUPS_ID=" + gpid;

        try {
            ResultSet rsGp = DBAccess.getDBA().executeQuery(selectStmt);

            Groups group = getGroupFromResultSet(rsGp);

            return group;
        } catch (SQLException e) {
            System.out.println("While searching a group with " + gpid + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static Groups getGroupFromResultSet(ResultSet rs) throws SQLException {
        Groups gp = null;
        if (rs.next()) {
            gp.setGroupId(rs.getInt("GROUP_ID"));
            gp.getGroupName(rs.getString("GROUPNAME"));
            gp.getMembersId(convertStringToList(rs.getString("MEMBERS_ID"), " "));
            gp.getOwnersId(convertStringToList(rs.getString("OWNERS_ID"), " "));
            gp.getGroupCalendarId(rs.getInt("GPCALENDAR_ID"));
        }
        return gp;
    }

    public static ObservableList<Groups> searchGroups () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM GROUPS";

        try {
            ResultSet rsgp = DBAccess.getDBA().executeQuery(selectStmt);

            ObservableList<Groups> gpList = (ObservableList<Groups>) getGroupFromResultSet(rsgp);

            return gpList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " +e);

            throw e;
        }
    }

    private static ObservableList<Groups> getGroupsList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Groups> gpList = FXCollections.observableArrayList();

        while (rs.next()) {
            Groups gp = new Groups();
            gp.setGroupId(rs.getInt("GROUP_ID"));
            gp.getGroupName(rs.getString("GROUPNAME"));
            gp.getMembersId(convertStringToList(rs.getString("MEMBERS_ID"), " "));
            gp.getOwnersId(convertStringToList(rs.getString("OWNERS_ID"), " "));
            gp.getGroupCalendarId(rs.getInt("GPCALENDAR_ID"));
        }
        return gpList;
    }

    public static void updateGpMember (int gpId, List<String> memberID) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE GROUPS\n" +
                        "   SET MEMBERS_ID = '" + convertListToString(memberID, " ")+ "'\n" +
                        "   WHERE GROUP_ID = " + gpId + ";\n" +
                        "   COMMIT;\n" +
                        "  END;";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void insertGp (int groupid, String name, List<String> members, List<String> owners, int calendarid) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO　GROUPS\n" +
                        "(GROUP_ID, GROUPNAME, MEMBERS_ID, OWNERS_ID, GPCALENDAR_ID)\n" +
                        "VALUES\n" +
                        "('"+groupid+"', '"+name+"', '"+convertListToString(members, " ")+"', '"+convertListToString(owners, " ")+"', '"+calendarid+"');\n" +
                        "END;";
        DBAccess.getDBA().executeUpdate(updateStmt);
    }
}
