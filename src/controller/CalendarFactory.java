package controller;
import Entity.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CalendarFactory {

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

    public static Calendar searchCalendar (String cid) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM calendar WHERE cid ="+cid;

        try {
            ResultSet rsCal = DBAccess.getDBA().executeQuery(selectStmt);

            Calendar cal = getCalendarFromResultSet(rsCal);

            return cal;
        } catch (SQLException e) {
            System.out.println("While searching a calendar with " + cid + " id, an error occurred: " +e);
            throw e;
        }
    }
    private static Calendar getCalendarFromResultSet(ResultSet rs) throws SQLException {
        Calendar cal = null;
        if (rs.next()) {
            cal = new Calendar();
            cal.setCalendarId(rs.getInt("CALENDAR_ID"));
            cal.setUserId(convertStringToList(rs.getString("USER_ID"), " "));
            cal.setGroupId(rs.getInt("GROUP_ID"));
            cal.setEventId(convertStringToList(rs.getString("EVENT_ID"), " "));
            cal.setYearId(rs.getInt("YEAR"));
            cal.setMonthId(rs.getInt("MONTH"));
        }
        return cal;
    }

    public static ObservableList<Calendar> searchCalendars () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM CALENDAR";

        try {
            ResultSet rsCals = DBAccess.getDBA().executeQuery(selectStmt);

            ObservableList<Calendar> calList = (ObservableList<Calendar>) getCalendarFromResultSet(rsCals);

            return calList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has failed: "+ e);
            throw e;
        }
    }

    private static ObservableList<Calendar> getCalendarList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Calendar> calList = FXCollections.observableArrayList();

        while (rs.next()) {
            Calendar cal = new Calendar();
            cal.setCalendarId(rs.getInt("CALENDAR_ID"));
            cal.setUserId(convertStringToList(rs.getString("USER_ID"), " "));
            cal.setGroupId(rs.getInt("GROUP_ID"));
            cal.setEventId(convertStringToList(rs.getString("EVENT_ID"), " "));
            cal.setYearId(rs.getInt("YEAR"));
            cal.setMonthId(rs.getInt("MONTH"));

            calList.add(cal);
        }
        return calList;
    }

    public static void updateCalEvent (int calId, String calEvent) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE CALENDAR\n" +
                        "   SET EVENT_ID = '" + calEvent + "'\n" +
                        "   WHERE CALENDAR_ID = " + calId + ";\n" +
                        "   COMMIT;\n" +
                        "END;";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void deleteCalWithId (int calId) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM CALENDAR\n" +
                        "       WHERE CALENDAR_ID =" + calId +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void insertCal (List<String> userid, int groupid, List<String> eventid, int year, int month) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO CALENDAR\n" +
                        "(CALENDAR_ID, USER_ID, GROUP_ID, EVENT_ID, YEAR, MONTH)\n" +
                        "VALUES\n" +
                        "(sequence_calendar.nextval, '"+convertListToString(userid, " ")+"', '"+convertListToString(eventid, " ")+"', '"+year+"', '"+month+"');\n" +
                        "END;";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }
}
