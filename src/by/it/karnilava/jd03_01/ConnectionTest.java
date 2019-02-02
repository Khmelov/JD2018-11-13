package by.it.karnilava.jd03_01;

import java.sql.DriverManager;

public class ConnectionTest {

    public static void main(String[] args) {
        try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")){
            if (!connection.isClosed()){
                System.out.println("Соединение установлено");
                connection.close();}
                if (connection.isClosed())
                {
                    System.out.println("Соединение прервано");
                }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
