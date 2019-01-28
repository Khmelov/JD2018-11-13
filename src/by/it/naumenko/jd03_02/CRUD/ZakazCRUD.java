package by.it.naumenko.jd03_02.CRUD;

import by.it.naumenko.jd03_02.beens.Zakaz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class ZakazCRUD {

    boolean create(Zakaz zakaz) throws SQLException {
//        String sql = String.format(Locale.ENGLISH,
//                "INSERT INTO `zakaz`(`id_zakaz`,`date_zakaz`, `koltort`, `price_zakaz`, " +
//                        "`users_id_users`, `cake_id_cake`) " +
//                        "VALUES ('%d','%s',%d,%f,%d,%d)",
//                zakaz.getId_zakaz(),zakaz.getDate_zakazS(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
//                zakaz.getId_user(), zakaz.getId_cake());
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `zakaz`(`date_zakaz`, `koltort`, `price_zakaz`, " +
                        "`users_id_users`, `cake_id_cake`) " +
                        "VALUES ('%s',%d,%f,%d,%d)",
                zakaz.getDate_zakazS(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
                zakaz.getId_user(), zakaz.getId_cake());
        System.out.println(sql);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    zakaz.setId_cake(generatedKeys.getLong(1));
                }
                return true;
            }
        }
        return false;
    }


    boolean delete(Zakaz zakaz) throws SQLException {
        String sql = String.format("DELETE FROM `zakaz` WHERE `zakaz`.`id_zakaz` = %d", zakaz.getId_zakaz());
        System.out.println(sql);

        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean update(Zakaz zakaz) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `zakaz` SET `date_zakaz` = '%s', " +
                        "`koltort` = '%d', `price_zakaz` = '%f', `users_id_users` = '%d', " +
                        "`cake_id_cake` = '%d'" +
                        " WHERE `zakaz`.`id_zakaz` = %d",
                zakaz.getDate_zakazS(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
                zakaz.getId_user(), zakaz.getId_cake(),zakaz.getId_zakaz());
        System.out.println(zakaz.getId_zakaz());
        System.out.println(sql);
        try (Connection connection = Connected.getConnection()) {
            Statement statement = connection.createStatement();
            return (1 == statement.executeUpdate(sql));
        }
    }


    Zakaz read(long id_zakaz) throws SQLException {
        String sql = String.format("SELECT * FROM `zakaz` WHERE `id_zakaz`=%d", id_zakaz);

        System.out.println(sql);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String date_zakazS  = resultSet.getString("date_zakaz");
                int koltort = resultSet.getInt("koltort");
                double price_zakaz = resultSet.getDouble("price_zakaz");
                long id_user = resultSet.getLong("users_id_users");
                long id_cake = resultSet.getLong("cake_id_cake");

                return new Zakaz(id_zakaz,date_zakazS,koltort,price_zakaz,id_user,id_cake );
            } else
                return null;
        }
    }
}

