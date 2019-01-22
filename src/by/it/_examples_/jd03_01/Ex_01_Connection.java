package by.it._examples_.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex_01_Connection {


    public static void main(String[ ] args) {
        //наиболее надежный способ загрузки драйвера
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
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)){
                if (!connection.isClosed())
                    System.out.println("Соединение установлено");
                connection.close();
                if (connection.isClosed())
                    System.out.println("Соединение прервано");
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
