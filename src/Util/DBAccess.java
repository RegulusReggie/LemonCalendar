package Util;
import java.sql.*;

public class DBAccess {
    private static DBAccess dba;
    private Connection connection = null;
    private String mName;
    private String mPass;
    private DBAccess(){
        try{
//            Scanner in = new Scanner(System.in);
//            System.out.print("please enter your mysql root name: ");
//            mName = in.nextLine();
//            System.out.print("please enter your mysql root password: ");
            mName = "root";
            mPass = "Passw0rd";
//            mPass = new String(System.console().readPassword());
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        getConnection();
    }

    public static DBAccess getDBA(){
        if (dba == null){
            dba = new DBAccess();
        }
        return dba;
    }
    public Connection getConnection(){
        String mUrl = "jdbc:mysql://localhost:3306/lemoncalendar";
        try{
            connection = DriverManager.getConnection(mUrl,mName,mPass);
            System.out.println("Success to connect to " + connection);
        }catch (SQLException e){
            e.printStackTrace();
            if(connection == null){
                System.out.println("not found this db.Start to init!");
                initDataBase();
            }
        }
        return connection;
    }
    private void initDataBase(){
        Connection connection = null;
        String mUrl = "jdbc:mysql://localhost:3306/mysql";
        String mNewUrl = "jdbc:mysql://localhost:3306/lemoncalendar";
        try{
            connection = DriverManager.getConnection(mUrl,mName,mPass);
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE lemoncalendar;");
            System.out.println("Success to connect to create lemoncalendar!" );
            connection = DriverManager.getConnection(mNewUrl,mName,mPass);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE  TABLE EVENT(" +
                    "EVENT_ID INT(11) NOT NULL PRIMARY KEY," +
                    "YEAR INT(11) NOT NULL," +
                    "MONTH INT(11) NOT NULL, " +
                    "DAY INT(11) NOT NULL," +
                    "DESCRIPTION VARCHAR(256) NOT NULL);");
            statement.executeUpdate("CREATE  TABLE CALENDAR(" +
                    "CALENDAR_ID INT(11) NOT NULL PRIMARY KEY," +
                    "GROUP_ID INT(11) NOT NULL," +
                    "YEAR INT(11) NOT NULL, " +
                    "MONTH INT(11) NOT NULL," +
                    "USER_ID VARCHAR(256) NOT NULL," +
                    "EVENT_ID INT(11) NOT NULL," +
                    "FOREIGN KEY (EVENT_ID) REFERENCES EVENT(EVENT_ID)," +
                    "FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID));");
            statement.executeUpdate("CREATE  TABLE USERS(" +
                    "USERS_ID INT(11) NOT NULL PRIMARY KEY," +
                    "USERNAME VARCHAR(45) NOT NULL," +
                    "PASSWORD VARCHAR(45) NOT NULL, " +
                    "ONLINE TINYINT(4) NOT NULL);");
            statement.executeUpdate("CREATE  TABLE GROUPS(" +
                    "GROUP_ID INT(11) NOT NULL PRIMARY KEY," +
                    "GROUPNAME VARCHAR(45) NOT NULL," +
                    "MEMBERS_ID VARCHAR(256) NOT NULL," +
                    "OWNERS_ID VARCHAR(256) NOT NULL," +
                    "GPCALENDAR_ID INT(11) NOT NULL" +
                    "FOREIGN KEY (GPCALENDAR_ID) REFERENCES CALENDAR(CALENDAR_ID));");
            getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void execute(String sqlExecute){
        try{
            PreparedStatement statement = connection.prepareStatement(sqlExecute);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sqlExecute){
        ResultSet rs = null;
        try{
            PreparedStatement statement = connection.prepareStatement(sqlExecute);
            rs = statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate(String sqlExecute){
        try{
            PreparedStatement statement = connection.prepareStatement(sqlExecute);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
