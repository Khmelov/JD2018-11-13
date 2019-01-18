package by.it._examples_.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_02__Users {


    public static void main(String[ ] args) {
        //наболее надежный способ загрузки драйвера
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        //второй способ загрузки драйвера
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        //в некоторых случаях можно вообще ничего не загружать (например при запуске в IDEA)
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(`Login`,`Password`,`Email`,`FK_ROLES`)"+
                            " values('ТестАдминистратор4','admin3','admin2@tut.by',1);"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_ROLES)"+
                            " values('avkhmeleva4','pavkhmeleva3','avkhmeleva5@tut.by',2);"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
