package by.it.karnilava.jd03_03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {


    private static volatile DAO dao; //синглтон для ДАО
    public AccountDAO account;
    public ClientDAO client;
    public RoleDAO role;
    public StateDAO state;
    public TypeDAO type;

    public DAO() {
    }

    public static DAO getDao() {
        DAO localDao = dao;
        if (localDao == null) {
            synchronized (DAO.class) {
                localDao = dao;
                if (localDao == null) {
                    dao = localDao = new DAO();
                    dao.account = new AccountDAO();
                    dao.client = new ClientDAO();
                    dao.role = new RoleDAO();
                    dao.state = new StateDAO();
                    dao.type = new TypeDAO();
                }
            }
        }

        return localDao;

    }


    static boolean executeUpdate(String sql) throws SQLException {

        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }


    }

    static long executeCreateAndGetId(String sql) throws SQLException {
        try (Connection connection = by.it.karnilava.project05.java.dao.Connect.getConnection();
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

