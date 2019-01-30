package by.it.karnilava.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[] args) {

      // STATE -  (1, 'Open')(2, 'Blocked')(3, 'Closed')
        // type - (1, 'Credit');(2, 'Deposit');(3, 'Current');

        try  (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", ""); Statement statement =  connection.createStatement())
        {
            statement.executeUpdate(
                    "INSERT INTO `karnilava`.`Account features` ( `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES ( '3014123456002', '1350', 2, 3, 1);");
            statement.executeUpdate(
                    "INSERT INTO `karnilava`.`Account features` ( `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES ( '3011123456001', '20000', 2, 1, 1);");
            statement.executeUpdate(
                    "INSERT INTO `karnilava`.`Account features` ( `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`) VALUES ( '3011123456001', '0', 2, 2, 3);");



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
