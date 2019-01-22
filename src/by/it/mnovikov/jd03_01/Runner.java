package by.it.mnovikov.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        try {
            Statement statement = Connect_DB.getConnection().createStatement();
            C_Reset.deleteTables(statement);
            C_Reset.deleteDB(statement);
            C_Init.createDB(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
