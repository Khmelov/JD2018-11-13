package by.it.naumenko.jd03_03;

//import com.mysql.jdbc.Field;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDAO<MyBeen> {

    private MyBeen myBeen;
    private String nameTable;
    Field[] fields;

    public MyDAO(MyBeen myBeen, String nameTable) {
        this.myBeen = myBeen;
        this.nameTable = nameTable;
        this.fields = myBeen.getClass().getDeclaredFields();
    }

    public boolean create(MyBeen been) throws SQLException {
//        INSERT INTO `cake`(`name_cake`, `size_cake`, `weight_cake`, " +
//        "`bescuit`, `decoration`, `cream`, `price_cake`) VALUES " +
//                "('%s',%d,%f,'%s','%s','%s',%f)

        String namesField = "";
        String value = "";
        String separator = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                namesField = namesField.concat(("`"+ field.getName()+"`"));
                if (i!=fields.length-1)
                    namesField=namesField.concat(",");
                value = value.concat(separator + "'" + field.get(been) + "'");
                separator = ",";
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        "INSERT INTO `roles`(`role`) VALUES ('%s')",
        String sql = "insert INTO `" + nameTable + "` (" + namesField + ") values(" + value + ")";
        System.out.println(sql);

        int id = executeUpdate(sql, true);
        if (id > 0)
            try {
                fields[0].setAccessible(true);
                fields[0].set(been, id);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return (id > 0);
    }


    public boolean update(MyBeen been) throws SQLException {
//
//        UPDATE `cake` SET `name_cake` = '%s', `size_cake` = %d, " +
//        "`weight_cake` = %f, `bescuit` = '%s', `decoration` = '%s', " +
//                "`cream` = '%s', `price_cake` = %f WHERE `cake`.`id_cake` = %d

        String sql = "update `" + nameTable + "` set ";

        String separator = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field field = fields[i];
                field.setAccessible(true);
                //добавляем `FieldName` = 'Value', в цикле
                sql = sql.concat(separator + "`" + field.getName() + "` = '" + field.get(been) + "'");
                separator = ", "; //добавим запятую перед каждым последующим полем
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(been) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        UPDATE `users` SET `login` = 'sehseth', `password` = 'sthetsh', `email` = 'thseth', `id_roles` = '5' WHERE `users`.`id_users` = 13
        System.out.println(sql);
        return (0 < executeUpdate(sql, true));

    }

    private static int executeUpdate(String sql, boolean b) throws SQLException {
        int rezult;

        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            rezult = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (rezult > 0 && b) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    rezult = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new SQLException();
        }
        return rezult;
    }


    public boolean delete(MyBeen been) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + nameTable + "` WHERE `" + nameTable +"`.`"+fields[0].getName()+ "` = '" + fields[0].get(been) + "'";
            System.out.println(sql);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }


    private MyBeen newBeen() {
        try {
            return (MyBeen) myBeen.getClass().getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MyBeen read(long id) throws SQLException {
        List<MyBeen> beens = getAll("where "+ fields[0].getName()+"=" + id);
        return beens.size() > 0 ? beens.get(0) : null;
    }

    public List<MyBeen> getAll(String where) throws SQLException {
        List<MyBeen> beens = new ArrayList<>();
        String sql = "select * from " + nameTable + " " + where + ";";
        try (
                Connection connection = Connected.getConnection();
                Statement statement = connection.createStatement()
        ) {
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                MyBeen newBeen = newBeen();
                for (int i = 1; i <= fields.length; i++) {
                    Field field = fields[i - 1];
                    field.setAccessible(true);
                    try {
                        if (field.getType() == Boolean.class || field.getType() == boolean.class)
                            field.set(newBeen, rs.getBoolean(field.getName()));
                        if (field.getType() == Byte.class || field.getType() == byte.class)
                            field.set(newBeen, rs.getByte(field.getName()));
                        if (field.getType() == Integer.class || field.getType() == int.class)
                            field.set(newBeen, rs.getInt(field.getName()));
                        if (field.getType() == Double.class || field.getType() == double.class)
                            field.set(newBeen, rs.getDouble(field.getName()));
                        if (field.getType() == Float.class || field.getType() == float.class)
                            field.set(newBeen, rs.getFloat(field.getName()));
                        if (field.getType() == Long.class || field.getType() == long.class)
                            field.set(newBeen, rs.getLong(field.getName()));
                        if (field.getType() == Short.class || field.getType() == short.class)
                            field.set(newBeen, rs.getShort(field.getName()));
                        if (field.getType() == String.class)
                            field.set(newBeen, rs.getString(field.getName()));
                        if (field.getType() == Timestamp.class)
                            field.set(newBeen, rs.getTimestamp(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(newBeen, rs.getDate(field.getName()));
                        //... и т.д. Но учтите, что протестированы только String int и Integer
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beens.add(newBeen);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beens;

    }







    public List<MyBeen> getAll() throws SQLException {
        List<MyBeen> beens = new ArrayList<>();
        String sql = "select * from " + nameTable;
        try (
                Connection connection = Connected.getConnection();
                Statement statement = connection.createStatement()
        ) {
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                MyBeen newBeen = newBeen();
                for (int i = 1; i <= fields.length; i++) {
                    Field field = fields[i - 1];
                    field.setAccessible(true);
                    try {
                        if (field.getType() == Boolean.class || field.getType() == boolean.class)
                            field.set(newBeen, rs.getBoolean(field.getName()));
                        if (field.getType() == Byte.class || field.getType() == byte.class)
                            field.set(newBeen, rs.getByte(field.getName()));
                        if (field.getType() == Integer.class || field.getType() == int.class)
                            field.set(newBeen, rs.getInt(field.getName()));
                        if (field.getType() == Double.class || field.getType() == double.class)
                            field.set(newBeen, rs.getDouble(field.getName()));
                        if (field.getType() == Float.class || field.getType() == float.class)
                            field.set(newBeen, rs.getFloat(field.getName()));
                        if (field.getType() == Long.class || field.getType() == long.class)
                            field.set(newBeen, rs.getLong(field.getName()));
                        if (field.getType() == Short.class || field.getType() == short.class)
                            field.set(newBeen, rs.getShort(field.getName()));
                        if (field.getType() == String.class)
                            field.set(newBeen, rs.getString(field.getName()));
                        if (field.getType() == Timestamp.class)
                            field.set(newBeen, rs.getTimestamp(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(newBeen, rs.getDate(field.getName()));
                        //... и т.д. Но учтите, что протестированы только String int и Integer
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beens.add(newBeen);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beens;

    }


}


