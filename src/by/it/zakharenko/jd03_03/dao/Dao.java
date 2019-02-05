package by.it.zakharenko.jd03_03.dao;
import by.it.zakharenko.jd03_03.beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

    private static volatile Dao dao;
    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Item> item;
    public InterfaceDao<Order> order;

    public void reset(){
        Connect.reset();
    }

    private Dao() {
        role = new RoleDao();
        user = new UserDao();
        order = new OrderDao();
        item = new ItemDao();
        //как делать при помощи UniversalDAO:
        //order=new UniversalDAO<>(new Order(),"orders");
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
