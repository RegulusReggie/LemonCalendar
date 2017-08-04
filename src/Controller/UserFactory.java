package Controller;

import Entity.Calendar;
import Entity.User;
import Util.Commons;
import Util.DBAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserFactory {
    private UserFactory() {}

    public static User getUserById (int uid) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM users WHERE USERS_ID =" + uid + ";";

        try {
            ResultSet rs = DBAccess.getDBA().executeQuery(selectStmt);
            return getUserFromResultSet(rs);
        } catch (SQLException e) {
            System.out.println("While searching a user with " + uid + " ID, an error occurred: " +e);
            throw e;
        }
    }
    private static User getUserFromResultSet(ResultSet rs) throws SQLException {
        User u = null;
        if (rs.next()) {
            u = new User();
            u.setUserId(rs.getInt("USER_ID"));
            u.setUserName(rs.getString("USERNAME"));
            u.setPassword(rs.getString("PASSWORD"));
        }
        return u;
    }

    public static int insertUser (String username, String password
                                   // , List<String> gpbelongid, List<String> gpownid, int calendarid
                                   ) throws SQLException, ClassNotFoundException {
        String updateStmt =
                        "INSERT INTO `lemoncalendar`.`USERS`\n" +
                        "(`USERNAME`, `PASSWORD`, `ONLINE`)\n" +
                        "VALUES\n" +
                        "('" + username +"', '" + password + "'," + 0 + ");";

        Statement stmt = DBAccess.getDBA().getConnection().createStatement();
        stmt.executeUpdate(updateStmt, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        int id = -1;
        if (generatedKeys.next()) {
            id = generatedKeys.getInt(1);
        }
        return id;
    }

    public static int checkLogin(String username, String password) throws SQLException {
        Statement stmt = DBAccess.getDBA().getConnection().createStatement();
        String selectStmt = "SELECT * FROM users WHERE username ='"+username + "';";
        int uid = -1;
        try {
            ResultSet rs = DBAccess.getDBA().executeQuery(selectStmt);
            if (!rs.next()) {
                System.out.println("No user match");
            } else if (!rs.getString("PASSWORD").equals(password)) {
                System.out.println("Password doesn't match");
            } else {
                uid = rs.getInt("USERS_ID");
            }
        } catch (SQLException e) {
            System.out.println("While searching a user with " + username + " username, an error occurred: " +e);
            throw e;
        }
        return uid;
    }
}
