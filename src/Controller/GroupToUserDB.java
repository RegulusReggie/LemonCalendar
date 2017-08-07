package Controller;

import Util.DBAccess;

import java.sql.SQLException;

public class GroupToUserDB {

    private GroupToUserDB() {}

    public static void insertG2U (int gid, int uid) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO `lemoncalendar`.`GROUPTOUSER`\n" +
                        "(`GROUP_ID`, `USER_ID`)\n" +
                        "VALUES\n" +
                        "(" + gid +", " + uid + ");";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }
}
