package entity;

import java.io.Serializable;

public class NewGroupMemberInfo implements Serializable {
    private int group_id;
    private String member_name;
    public NewGroupMemberInfo(int id, String name){
        group_id = id;
        member_name = name;
    }
    @Override
    public String toString(){
        return "group is " + group_id + ", member is " + member_name;
    }
    public String getMember_name(){
        return member_name;
    }
    public int getGroup_id(){
        return group_id;
    }
}
