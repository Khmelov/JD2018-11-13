package by.it.mnovikov.jd03_02;

import by.it.mnovikov.jd03_02.crud.Connect_DB;
import by.it.mnovikov.jd03_02.crud.ResetDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = Connect_DB.getConnection()){
            Statement statement = connection.createStatement();
            ResetDB.dropTables(statement);
            ResetDB.createDB(statement);
        }
    }
}
