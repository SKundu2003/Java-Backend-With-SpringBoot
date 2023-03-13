package com.example.Application2;

import java.util.ArrayList;
import java.util.List;

public class DBuserData {
    private ArrayList<userClass> userTable = new ArrayList<>();
    public DBuserData(){
        userTable.add(new userClass("user name 1",1,983162286));
        userTable.add(new userClass("user name 2",2,983262286));
        userTable.add(new userClass("user name 3",3,983362286));
        userTable.add(new userClass("user name 4",4,983462286));
    }
    public userClass addNewUser(String name, int id,long phone)
    {
        userClass user = new userClass(name,id,phone);
        userTable.add(user);
        return user;
    }
    public ArrayList<userClass> getAllUsers()
    {
        return userTable;
    }
    public userClass getOneUserDetail(int id)
    {
        for (userClass i:userTable) {
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }
    public boolean deleteAuser(int id)
    {
        for (userClass i:userTable) {
            if (i.getId() == id){
                userTable.remove(i);
                return true;
            }
        }
        return false;
    }
}
