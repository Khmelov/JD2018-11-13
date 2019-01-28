package by.it.naumenko.jd03_02.CRUD;

import by.it.naumenko.jd03_02.beens.Cake;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class CakeCRUD {

    boolean create(Cake cake) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `cake`(`name_cake`, `size_cake`, `weight_cake`, " +
                        "`bescuit`, `decoration`, `cream`, `price_cake`) VALUES " +
                        "('%s',%d,%f,'%s','%s','%s',%f)",
                cake.getName_cake(),cake.getSize_cake(),cake.getWeight_cake(),
                cake.getBescuit(), cake.getDecoration(), cake.getCream(),cake.getPrice_cake());
       // System.out.println(sql);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cake.setId_cake(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }


    boolean delete(Cake cake) throws SQLException {
        String sql = String.format("DELETE FROM `cake` WHERE `cake`.`id_cake` = %d", cake.getId_cake());


        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Cake cake) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `cake` SET `name_cake` = '%s', `size_cake` = %d, " +
                        "`weight_cake` = %f, `bescuit` = '%s', `decoration` = '%s', " +
                        "`cream` = '%s', `price_cake` = %f WHERE `cake`.`id_cake` = %d",
                cake.getName_cake(),cake.getSize_cake(),cake.getWeight_cake(),
                cake.getBescuit(), cake.getDecoration(), cake.getCream(),cake.getPrice_cake(),cake.getId_cake());
        //System.out.println(sql);
        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }


    Cake read(long id_cake) throws SQLException {
        String sql = String.format("SELECT * FROM `cake` WHERE `id_cake`=%d", id_cake);


        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String name_cake = resultSet.getString("name_cake");
                int size_cake = resultSet.getInt("size_cake");
                float weight_cake = resultSet.getFloat("weight_cake");
                String bescuit = resultSet.getString("bescuit");
                String decoration = resultSet.getString("decoration");
                String cream = resultSet.getString("cream");
                double price_cake = resultSet.getDouble("price_cake");

                return new Cake(id_cake, name_cake, size_cake, weight_cake, bescuit,decoration,cream,price_cake);
            } else
                return null;
        }
    }
}

