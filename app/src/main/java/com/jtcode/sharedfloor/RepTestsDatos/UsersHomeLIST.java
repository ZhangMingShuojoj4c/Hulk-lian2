package com.jtcode.sharedfloor.RepTestsDatos;


import com.jtcode.sharedfloor.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersHomeLIST  {

    private static List<User> listUsers;

    private static UsersHomeLIST ourInstance = new UsersHomeLIST();

    public static UsersHomeLIST getInstance() {
        return ourInstance;
    }

    private UsersHomeLIST() {
        listUsers= new ArrayList<User>();
        listUsers.add(new User("Ambrosio","DonalDuck@sheep.com","upcuoeslaclave"));
        listUsers.add(new User("Usuario","DonalDuck@sheep.com","upcuoeslaclave"));
        listUsers.add(new User("Usuarido","DonalDuck@sheep.com","upcuoeslaclave"));
    }
    public static List<User> getAll(){
        return listUsers;
    }
    public static int getNumber(){
        return listUsers.size();
    }
}
