package by.it._examples_.jd03_02;

import by.it._examples_.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.Statement;

public class Ex_01__Rus_Users {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement()) {

            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_Roles)"+
                            " values('проверка','админ3','admin3@tut.by',1);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
