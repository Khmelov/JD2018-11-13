package by.it.mnovikov.jd03_03.dao;

import by.it.mnovikov.jd03_03.beans.*;

import java.sql.SQLException;

/**
 * Created by user on 22.01.2019.
 */
public class Dao {

    private static volatile Dao dao;

    public Interface_DAO<Role> role;
    public Interface_DAO<User> user;
    public Interface_DAO<Order> order;
    public Interface_DAO<Good> good;
    public Interface_DAO<Order_Good> order_good;

    private Dao() {
        role = new UniversalDAO<>(new Role(), "roles");
        user = new UniversalDAO<>(new User(), "users");
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

    public void reset() {
        Connect.resetDB();
    }
}
