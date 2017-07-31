package controller;
import entity.Groups;

import java.io.Serializable;

public class GroupFactory implements Serializable {
    private int uid;
    private Groups userGroup;
    public GroupFactory (int username) {
        uid = username;
    }
    @Override
    public String toString() { return "user is " + uid; }
    public String UserGroup() {
        boolean sig1 = false;
        boolean sig2 = false;
        for (int i = 0 ; i < userGroup.getMembers().length ; i++) {
            if (uid == userGroup.getMembers()[i]) {
                sig1 = true;
                break;
            }
        }
        for (int j = 0 ; j < userGroup.getOwners().length ; j++) {
            if (uid == userGroup.getOwners()[j]) {
                sig2 = true;
                break;
            }
        }
        if (sig1 || sig2) {
            return userGroup.toString();
        }
        else {
            return "user group not found!";
        }
    }
    public int getUid() {return uid;}
}
