package by.it.seroglazov.jd03_03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDao<T> implements Dao<T> {

    private T tObject;

    public MyDao(T tObject) {
        this.tObject = tObject;
    }

    @Override
    public boolean create(T t) throws Exception {
        Class cl = t.getClass();
        String tableName = cl.getSimpleName().toLowerCase().concat("s");
        Field[] fields = cl.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        StringBuilder values = new StringBuilder();
        sb.append("INSERT INTO `").append(tableName).append("` (");
        values.append("VALUES (");
        Field idField = null;
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName().toLowerCase();
            sb.append('`').append(name).append("`, ");
            if (name.equalsIgnoreCase("id")) {
                idField = field;
                values.append("DEFAULT, ");
            } else {
                values.append("'");
                Class type = field.getType();
                if (type == String.class)
                    values.append((String) field.get(t));
                else if (type == long.class)
                    values.append(field.getLong(t));
                else if (type == int.class)
                    values.append(field.getInt(t));
                else
                    throw new Exception("Unexpected field type: " + type + ". Expected types are int, long and String");
                values.append("', ");
            }

        }
        sb.delete(sb.length() - 2, sb.length() - 1); // delete last ", " symbols
        values.delete(values.length() - 2, values.length() - 1);
        sb.append(") ");
        values.append("); ");
        sb.append(values);
        String sql = sb.toString();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                if (idField != null) {
                    ResultSet keys = statement.getGeneratedKeys();
                    if (keys.next()) {
                        idField.setLong(t, keys.getLong(1));
                    }
                }
            } else
                return false;
        }
        return true;
    }

    @Override
    public boolean delete(T t) throws SQLException {
        return false;
    }

    @Override
    public boolean update(T t) throws SQLException {
        return false;
    }

    @Override
    public T read(long id) throws Exception {
        List<T> list = getAll("WHERE id='" + id + "'");
        if (list.size() > 0) {
            return list.get(0);
        } else
            return null;
    }

    @Override
    public List<T> getAll(String sqlCondition) throws Exception {
        List<T> list = new ArrayList<>();
        Class cl = tObject.getClass();
        String tableName = cl.getSimpleName().toLowerCase().concat("s");
        String sql = "SELECT * FROM `" + tableName + "` " + sqlCondition + " ;";
        Field[] fields = cl.getDeclaredFields();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet results = statement.executeQuery(sql);
            while (results.next()) {
                @SuppressWarnings("unchecked")
                T t = (T) cl.getConstructor().newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName().toLowerCase();
                    Class<?> type = field.getType();
                    if (type == String.class)
                        field.set(t, results.getString(name));
                    else if (type == long.class)
                        field.set(t, results.getLong(name));
                    else if (type == int.class)
                        field.set(t, results.getInt(name));
                    else
                        throw new Exception("Unexpected field type: " + type + ". Expected types are int, long and String");
                }
                list.add(t);
            }
        }
        return list;
    }
}
