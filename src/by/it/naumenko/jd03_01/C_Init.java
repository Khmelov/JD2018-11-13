package by.it.naumenko.jd03_01;

//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C_Init {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String portDB = "jdbc:mysql://127.0.0.1:2016/";
    private final static String CREATE_TABLE_ROLES =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create roles.sql";
    private final static String CREATE_TABLE_CAKE =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create cake.sql";
    private final static String CREATE_TABLE_USERS =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create users1.sql";
    private final static String CREATE_TABLE_ZAKAZ =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create zakaz.sql";
    private final static String CREATE_TABLE_PROFIL =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create profil.sql";
    private final static String CREATE_TABLE_BASKET =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/create/create basket.sql";
    private final static String DROP_TABLE_CAKE =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/drop/drop cake.sql";
    private final static String DROP_TABLE_ROLES =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/drop/drop roles.sql";
    private final static String DROP_TABLE_USERS=System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/drop/drop users.sql";
    private final static String DROP_TABLE_ZAKAZ=System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/drop/drop zakaz.sql";
    private final static String INSERT_TABLE_PROFIL =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/insert/insert profil.sql";
    private final static String INSERT_TABLE_CAKE =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/insert/insert cake.sql";
    private final static String INSERT_TABLE_ROLES =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/insert/insert roles.sql";
    private final static String INSERT_TABLE_USERS =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/insert/insert users.sql";
    private final static String INSERT_TABLE_ZAKAZ =System.getProperty("user.dir")+"/src/by/it/naumenko/jd03_01/sql/insert/insert zakaz.sql";


        //считать содержимое запроса из файла в строку
    static String getSQLFile(String filename) throws IOException {
        FileReader fin = new FileReader(filename);
        StringBuilder sb=new StringBuilder();
        int c;
        while ((c = fin.read()) != -1)
            sb.append((char) c);
        return sb.toString();
    }

    // подсчет сколько строк в insert файле
    static int getSQLFileInsertCount(String filename) throws IOException {
        List<String> insertLIst=new ArrayList<>();

        BufferedReader  reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            insertLIst.add(line);
        }
        return insertLIst.size();
    }

    //запись insert файла построчно в list
    static String getSQLFileInsert(String filename, int i) throws IOException {
        List<String> insertLIst=new ArrayList<>();

        BufferedReader  reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            insertLIst.add(line);
        }
        return insertLIst.get(i);
    }
// зоздание БД
public void create() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //System.err.println("драйвер не найден");
        }

        try (Connection connection = DriverManager.getConnection(portDB, "root", "")
        ) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `naumenko2`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `naumenko2` DEFAULT CHARACTER SET utf8");

            //Table `naumenko2`.`roles`
            statement.executeUpdate(getSQLFile(CREATE_TABLE_ROLES));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_CAKE));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_USERS));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_ZAKAZ));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_PROFIL));
            statement.executeUpdate(getSQLFile(CREATE_TABLE_BASKET));

            int count = getSQLFileInsertCount(INSERT_TABLE_CAKE);
            for (int i = 0; i <count ; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_CAKE,i));
            }

            count = getSQLFileInsertCount(INSERT_TABLE_ROLES);
            for (int i = 0; i <count ; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_ROLES,i));
            }
//
            count = getSQLFileInsertCount(INSERT_TABLE_USERS);
            for (int i = 0; i <count ; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_USERS,i));
            }

            count = getSQLFileInsertCount(INSERT_TABLE_ZAKAZ);
            for (int i = 0; i <count ; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_ZAKAZ,i));
            }
            count = getSQLFileInsertCount(INSERT_TABLE_PROFIL);
            for (int i = 0; i <count ; i++) {
                statement.executeUpdate(getSQLFileInsert(INSERT_TABLE_PROFIL,i));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
             System.err.println("драйвер не найден");
        }
    }
}
