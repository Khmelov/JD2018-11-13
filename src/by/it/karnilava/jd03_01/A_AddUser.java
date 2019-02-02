package by.it.karnilava.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddUser {
    public static void main(String[] args) {
      try  (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", ""); Statement statement =  connection.createStatement())
         {
          statement.executeUpdate(

                  "INSERT INTO `karnilava`.`Client` (`ID passport`, `first name`, `last name`, `password`, `Roles_idRoles`) VALUES ('3060692E011PB0', 'Ivan', 'Petrov', '12345ivan', 1);");


      }
      catch (Exception e){
          e.printStackTrace();
      }

    }
}
