package entity;
import java.io.Serializable;

public class LogInfo implements Serializable{
    private String account;
    private String password;
    public LogInfo(String name, String pass) {
        account = name;
        password = pass;
    }
    @Override
    public String toString() { return "account is " + account + ", password is " + password; }
    public String getAccount() { return account; }
    public String getPassword() { return password; }
}
