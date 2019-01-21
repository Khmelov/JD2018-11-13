package by.it.skarpovich.jd03_02.crud;

import by.it.skarpovich.jd03_02.beans.User;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD=new UserCRUD();
        User user=new User();
        user.setUsername("agl2225");
        user.setPassword("john15");
        user.setEmail("agl@tut.by52");
        user.setFullname("Mike Jordan25");
        user.setPhone("11125");
        user.setAddress("Drozdy 125");
        user.setRoles_id(2);

        if (userCRUD.create(user))
            System.out.println("USER PROFILE CREATED: "+user);
        user.setUsername("AGL22");

        if (userCRUD.update(user))
            System.out.println("Username has been updated to: "+user);
        user=userCRUD.read(user.getId());
        System.out.println("USER PROFILE: "+user);

//       if (userCRUD.delete(user))
//           System.out.println("USER PROFILE DELETED: "+user);

    }
}
