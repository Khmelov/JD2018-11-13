package by.it.naumenko.jd03_03;



import by.it.naumenko.jd03_03.beens.Cake;
import by.it.naumenko.jd03_03.beens.Roles;
import by.it.naumenko.jd03_03.beens.Users;
import by.it.naumenko.jd03_03.beens.Zakaz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    private static volatile Dao dao;

    public InterfaceDao<Roles> role;
    public InterfaceDao<Users> user;
    public InterfaceDao<Cake> cake;
    public InterfaceDao<Zakaz> zakaz;

//    public void reset(){
//        Connect.reset();
//    }

    private Dao() {
        role= new RoleDAO();
        user=new UserDAO();
        cake=new CakeDAO();
        zakaz = new ZakazDAO();

        //или так
        //ad=new UniversalDAO<>(new Ad(),"ads");
    }

    public static Dao getDao(){
        if (dao== null) {
            synchronized (Dao.class) {
                if (dao== null) {
                    dao=new Dao();
                }
            }
        }
        return dao;
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static long executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

    static List<Roles> executelist(String sql) throws SQLException {
        List<Roles> rolesList = new ArrayList<>();
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id = resultSet.getLong("id_roles");
                String strRole = resultSet.getString("role");
                Roles role = new Roles(id, strRole);
                rolesList.add(role);
            }
            return rolesList;
        }
    }
}
