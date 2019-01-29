package by.it.naumenko.project.java.dao;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDB {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String portDB = "jdbc:mysql://127.0.0.1:2016/";

    private final static String DROP_TABLE_CAKE =System.getProperty("user.dir")+"/src/by/it/naumenko/project/java/dao/sql/drop/drop cake.sql";
    private final static String DROP_TABLE_ROLES =System.getProperty("user.dir")+"/src/by/it/naumenko/project/java/dao/sql/drop/drop roles.sql";
    private final static String DROP_TABLE_USERS=System.getProperty("user.dir")+"/src/by/it/naumenko/project/java/dao/sql/drop/drop users.sql";
    private final static String DROP_TABLE_ZAKAZ=System.getProperty("user.dir")+"/src/by/it/naumenko/project/java/dao/sql/drop/drop zakaz.sql";

    static String getSQLFile(String filename) throws IOException {
        FileReader fin = new FileReader(filename);
        StringBuilder sb=new StringBuilder();
        int c;
        while ((c = fin.read()) != -1)
            sb.append((char) c);
        return sb.toString();
    }


    public void dropDB() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //System.err.println("драйвер не найден");
        }

        try (Connection connection = DriverManager.getConnection(portDB, "root", "")
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(getSQLFile(DROP_TABLE_ZAKAZ));
            statement.executeUpdate(getSQLFile(DROP_TABLE_CAKE));
            statement.executeUpdate(getSQLFile(DROP_TABLE_USERS));
            statement.executeUpdate(getSQLFile(DROP_TABLE_ROLES));
            statement.executeUpdate("DROP SCHEMA IF EXISTS `naumenko`");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            // System.err.println("драйвер не найден");
        }
    }
}
