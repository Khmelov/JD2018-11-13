package by.it.kruglenja.Project.java.dao;

import by.it.kruglenja.Project.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private static volatile Dao dao;

    public InterfaceDao<Roles> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Order> order;
    public InterfaceDao<Spareparts> spareparts;
    public InterfaceDao<CompletedOrder> completedOrder;

    private Dao() {
        role = new UniversalDao<>(new Roles(), "roles");
//        user = new UniversalDao<>(new User(), "users");
        user = new UserDao();
        order = new OrderDao();
        spareparts = new SparepartsDao();
        completedOrder = new CompletedOrderDao();
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }
    public void reset(){
        Connect.deleteDb();
        Connect.createDb();
    }
    public void delete(){
        Connect.deleteDb();
    }

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static long executeCrate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
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
}