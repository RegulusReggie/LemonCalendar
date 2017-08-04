package Controller;
import Entity.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Util.DBAccess;
import Util.Commons;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class CalendarFactory {

    private static Map<Integer, Calendar> calMap = new HashMap<>();

    private CalendarFactory() {}

    public static Calendar searchCalendar (int cid) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM calendar WHERE CALENDAR_ID ="+cid+";";

        try {
            ResultSet rsCal = DBAccess.getDBA().executeQuery(selectStmt);
            return getCalendarFromResultSet(rsCal);
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
            cal.setUserId(Commons.convertStringToList(rs.getString("USER_ID")));
            cal.setGroupId(rs.getInt("GROUP_ID"));
            cal.setEventId(Commons.convertStringToList(rs.getString("EVENT_ID")));
            cal.setYear(rs.getInt("YEAR"));
            cal.setMonth(rs.getInt("MONTH"));
        }
        return cal;
    }

    public static ObservableList<Calendar> searchCalendars () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM CALENDAR";

        try {
            ResultSet rsCals = DBAccess.getDBA().executeQuery(selectStmt);
            return (ObservableList<Calendar>) getCalendarFromResultSet(rsCals);
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
            cal.setUserId(Commons.convertStringToList(rs.getString("USER_ID")));
            cal.setGroupId(rs.getInt("GROUP_ID"));
            cal.setEventId(Commons.convertStringToList(rs.getString("EVENT_ID")));
            cal.setYear(rs.getInt("YEAR"));
            cal.setMonth(rs.getInt("MONTH"));

            calList.add(cal);
        }
        return calList;
    }

    public static void updateCalEvent (int calId, String calEvent) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "UPDATE CALENDAR SET EVENT_ID = '" + calEvent + "' " + "WHERE CALENDAR_ID = " + calId + ";";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void deleteCalWithId (int calId) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "DELETE FROM CALENDAR WHERE CALENDAR_ID =" + calId +";";
        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static void insertCal (List<String> userid, int groupid, List<String> eventid, int year, int month) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "INSERT INTO CALENDAR (CALENDAR_ID, USER_ID, GROUP_ID, EVENT_ID, YEAR, MONTH) VALUES (AUTO_INCREMENT, '"+Commons.convertListToString(userid)+"', '"
                        +groupid+"', '"+Commons.convertListToString(eventid)+"', '"+year+"', '"+month+"');";

        DBAccess.getDBA().executeUpdate(updateStmt);
    }

    public static Calendar generateTestingCalendar(int cid) {
        Calendar cal = new Calendar();
        cal.setCalendarId(0);
        cal.setUserId(Commons.convertStringToList("0"));
        cal.setGroupId(-1);
        cal.setEventId(Commons.convertStringToList("0 1 2"));
        cal.setYear(2017);
        cal.setMonth(8);
        calMap.put(0, cal);

        Calendar cal1 = new Calendar();
        cal1.setCalendarId(1);
        cal1.setUserId(Commons.convertStringToList("0 1 2"));
        cal1.setGroupId(1);
        cal1.setEventId(Commons.convertStringToList("3 4 5 6"));
        cal1.setYear(2017);
        cal1.setMonth(8);
        calMap.put(1, cal1);

        Calendar cal2 = new Calendar();
        cal2.setCalendarId(2);
        cal2.setUserId(Commons.convertStringToList("0 3 4"));
        cal2.setGroupId(2);
        cal2.setEventId(Commons.convertStringToList("7"));
        cal2.setYear(2017);
        cal2.setMonth(8);
        calMap.put(2, cal2);

        Calendar cal3 = new Calendar();
        cal3.setCalendarId(3);
        cal3.setUserId(Commons.convertStringToList("0 6 7"));
        cal3.setGroupId(3);
        cal3.setEventId(Commons.convertStringToList("8 9 10 13 51"));
        cal3.setYear(2017);
        cal3.setMonth(8);
        calMap.put(3, cal3);
        return calMap.get(cid);
    }
}
