package by.it.karnilava.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class B_ShowUsers {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "");
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery( "select*from `karnilava`.`Client`;");
            while (resultSet.next()){
                String out = resultSet.getString("first name")+" "+ resultSet.getString("last name");
                int idRole = Integer.parseInt(resultSet.getString("Roles_idRoles"));
                System.out.print(out+" ");

                ResultSet resultRole = statement.getConnection().createStatement()
                        .executeQuery("select*from `karnilava`.`Roles` where `Roles`.`idRoles`=" + idRole);
                String role = "";
                while (resultRole.next()) {
                    role = resultRole.getString("Roles");
                }
                System.out.println(role);

//                SELECT `client`.`first+name`, `client`.`last+name`, `roles`.`Roles`
//                FROM `roles`
//                LEFT JOIN `client` ON `roles`.`idRoles` = `client`.`Roles_idRoles`

            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
