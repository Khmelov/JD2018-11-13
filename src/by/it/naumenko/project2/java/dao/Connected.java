package by.it.naumenko.project2.java.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connected {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String portDB = "jdbc:mysql://127.0.0.1:2016/";
    private final static String CREATE_TABLE_ROLES = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/create/create roles.sql";
    private final static String CREATE_TABLE_CAKE = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/create/create cake.sql";
    private final static String CREATE_TABLE_USERS = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/create/create users1.sql";
    private final static String CREATE_TABLE_ZAKAZ = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/create/create zakaz.sql";
    private final static String INSERT_TABLE_CAKE = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/insert/insert cake.sql";
    private final static String INSERT_TABLE_ROLES = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/insert/insert roles.sql";
    private final static String INSERT_TABLE_USERS = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/insert/insert users.sql";
    private final static String INSERT_TABLE_ZAKAZ = System.getProperty("user.dir") + "/src/by/it/naumenko/project/java/dao/sql/insert/insert zakaz.sql";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (Connected.class) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(Conect.URL, Conect.USER, Conect.PASSWORD);

            }
        }
        return connection;
    }


    static String getSQLFile(String filename) throws IOException {
        FileReader fin = new FileReader(filename);
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = fin.read()) != -1)
            sb.append((char) c);
        return sb.toString();
    }

    // подсчет сколько строк в insert файле
    static int getSQLFileInsertCount(String filename) throws IOException {
        List<String> insertLIst = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            insertLIst.add(line);
        }
        return insertLIst.size();
    }

    //запись insert файла построчно в list
    static String getSQLFileInsert(String filename, int i) throws IOException {
        List<String> insertLIst = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            insertLIst.add(line);
        }
        return insertLIst.get(i);
    }



    public void create() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(portDB, "root", "")
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `naumenko`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `naumenko` DEFAULT CHARACTER SET utf8");

            //Table `naumenko`.`roles`
            statement.executeUpdate(getSQLFile(CREATE_TABLE_ROLES));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_CAKE));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_USERS));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_ZAKAZ));

            int count = getSQLFileInsertCount(INSERT_TABLE_CAKE);
            for (int i = 0; i < count; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_CAKE, i));
            }

            count = getSQLFileInsertCount(INSERT_TABLE_ROLES);
            for (int i = 0; i < count; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_ROLES, i));
            }

            count = getSQLFileInsertCount(INSERT_TABLE_USERS);
            for (int i = 0; i < count; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_USERS, i));
            }

            count = getSQLFileInsertCount(INSERT_TABLE_ZAKAZ);
            for (int i = 0; i < count; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_ZAKAZ, i));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.err.println("драйвер не найден");
        }
    }
}
