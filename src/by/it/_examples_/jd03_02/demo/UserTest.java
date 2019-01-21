package by.it._examples_.jd03_02.demo;

import by.it._examples_.jd03_02.demo.beans.User;
import by.it._examples_.jd03_02.demo.crud.UserCRUD;

import java.sql.SQLException;

public class UserTest {
    public static void main(String[] args) {
        User user = new User(0, "login", "pass", "email", 2);
        try {
            //проверка BeanCRUD для пользователей
            UserCRUD userCRUD = new UserCRUD();

            //создание
            user=userCRUD.create(user);
            System.out.print("create: "+user);

            //чтение
            System.out.print("read: "+userCRUD.read(user.getID()));

            //обновление
            user.setLogin("loginUpdate");
            user=userCRUD.update(user);

            System.out.print("update: "+userCRUD.read(user.getID()));
            //удаление
            if (userCRUD.delete(user))
                System.out.print("delete: "+user.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
