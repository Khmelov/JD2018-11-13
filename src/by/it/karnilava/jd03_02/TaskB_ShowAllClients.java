package by.it.karnilava.jd03_02;

import by.it.karnilava.jd03_02.CRUD.Connect;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

public class TaskB_ShowAllClients {
    public static void main(String[] args)  {
        try (
                Connection connection = Connect.getConnection();
                Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select*from `karnilava`.`Client`;");
            while (resultSet.next()) {
                String out = resultSet.getString("first name") + " " + resultSet.getString("last name");
                int idRole = Integer.parseInt(resultSet.getString("Roles_idRoles"));
                System.out.print(out + " ");

                ResultSet resultRole = statement.getConnection().createStatement()
                        .executeQuery("select*from `karnilava`.`Roles` where `Roles`.`idRoles`=" + idRole);
                String role = "";
                while (resultRole.next()) {
                    role = resultRole.getString("Roles");
                }
                System.out.println(role);
            }

            String countClient = "SELECT COUNT(*) FROM client";
           ResultSet resultCount = statement.executeQuery(countClient);
           if (resultCount.next()){
               System.out.println("Clients number is "+resultCount.getString(1));
           }
           String countRoles = "SELECT COUNT(*) FROM roles";
           resultCount = statement.executeQuery(countRoles);
           if (resultCount.next()){
               System.out.println("Roles number is "+resultCount.getString(1 ));
           }



        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
