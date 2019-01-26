package by.it.mnovikov.project.java.dao;

import by.it.mnovikov.project.java.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Order> order;
    public InterfaceDao<Good> good;
    public InterfaceDao<Order_Good> order_good;

    public void reset() {
        Connect.reset();
    }

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        order = new UniversalDAO<>(new Order(), "orders");
        good = new UniversalDAO<>(new Good(), "goods");
        order_good = new UniversalDAO<>(new Order_Good(), "orders_goods");
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

    static boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static int executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        return -1;
    }

}
