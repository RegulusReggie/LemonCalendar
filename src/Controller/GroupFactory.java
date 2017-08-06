package Controller;
import Entity.Groups;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Util.DBAccess;
import Util.Commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GroupFactory {

    public static Groups searchGroups (int gpid) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM GROUPS WHERE GROUP_ID = " +gpid+ ";";

        try {
            ResultSet rsGp = DBAccess.getDBA().executeQuery(selectStmt);

            return getGroupFromResultSet(rsGp);
        } catch (SQLException e) {
            System.out.println("While searching a group with " + gpid + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static Groups getGroupFromResultSet(ResultSet rs) throws SQLException {
        Groups gp = null;
        if (rs.next()) {
            gp = new Groups();
            gp.setGroupId(rs.getInt("GROUP_ID"));
            gp.setGroupName(rs.getString("GROUPNAME"));
            gp.setMembersId(Commons.convertStringToList(rs.getString("MEMBERS_ID")));
            gp.setOwnersId(Commons.convertStringToList(rs.getString("OWNERS_ID")));
            gp.setGroupCalendarId(rs.getInt("GPCALENDAR_ID"));
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
            gp.setGroupName(rs.getString("GROUPNAME"));
            gp.setMembersId(Commons.convertStringToList(rs.getString("MEMBERS_ID")));
            gp.setOwnersId(Commons.convertStringToList(rs.getString("OWNERS_ID")));
            gp.setGroupCalendarId(rs.getInt("GPCALENDAR_ID"));
        }
        return gpList;
    }

    public static void updateGpMember (int gpId, List<String> memberID) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "UPDATE GROUPS" +
                        "   SET MEMBERS_ID = '" +Commons.convertListToString(memberID)+ "' WHERE GROUP_ID = " + gpId + ";";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void insertGp (String name, List<String> members, List<String> owners, int calendarid) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO GROUPS" + "(GROUPNAME, MEMBERS_ID, OWNERS_ID, GPCALENDAR_ID)" +
                        "VALUES" +
                        "('"+name+"', '"+Commons.convertListToString(members)+"', '"
                        +Commons.convertListToString(owners)+"', '"+calendarid+"');";
        DBAccess.getDBA().executeUpdate(updateStmt);
    }
}
