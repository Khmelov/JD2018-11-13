package by.it._examples_.jd03_03;

import by.it._examples_.jd03_03.beans.User;
import by.it._examples_.jd03_03.generics_dao.UniversalDAO;

import java.sql.SQLException;

public class V2_UniversalRunner {
    public static void main(String[] args) throws SQLException {
        UniversalDAO<User> dao=new UniversalDAO<>(new User(),"users");
        User user=new User(0,"ТестовыйЛогин","ТестовыйПароль","Тестовый Email",1);

        dao.create(user);
        System.out.println("Создан: " + user);

        dao.update(user);
        user.setEmail("Новый Email");
        System.out.println("Обновлен: "+user);

        if (dao.delete(user))
            System.out.println("Удален: " + user);

        System.out.println("\nСписок всех записей:");
        for (User current: dao.getAll("")) {
            System.out.println(current);
        }
    }
}
