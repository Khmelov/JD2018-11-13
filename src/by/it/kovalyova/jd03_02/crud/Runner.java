package by.it.kovalyova.jd03_02.crud;

import by.it.kovalyova.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD=new UserCRUD();
        User user=new User();
        user.setLogin("LLLLLL");
        user.setPassword("PPPPPP");
        user.setEmail("EEEEEE");
        user.setRoles_Id(2);
        if (userCRUD.create(user))
            System.out.println("CREATE: "+user);
        user.setLogin("LLLL2222222");
        if (userCRUD.update(user))
            System.out.println("UPDATE: "+user);
        user=userCRUD.read(user.getId());
        System.out.println("READ: "+user);
        // if(userCRUD.delete(user))
       // System.out.println("DELETE: "+user);
    }
}
