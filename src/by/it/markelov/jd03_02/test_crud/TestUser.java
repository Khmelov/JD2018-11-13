package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.User;
import by.it.markelov.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class TestUser {
    public static void main(String[] args) {
        UserCRUD userCRUD=new UserCRUD();
        User user=new User(0, "LTest", "PTest", "ETest", 2);

        try {
            userCRUD.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
