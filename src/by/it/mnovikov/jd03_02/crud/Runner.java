package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.User;

/**
 * Created by user on 19.01.2019.
 */
public class Runner {
    public static void main(String[] args) {
        User user = new User();
        user.setLogin("LLLLLLL");
        user.setPassword("adsfasd");
        user.setEmail("dasfas@mail.ru");
        user.setRoles_ID(2);

//        if (UserCRUD.update(user)){
//            System.out.println(user);
//        }
    }
}
