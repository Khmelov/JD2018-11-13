package by.it.naumenko.project.java.dao;

import by.it.naumenko.project.java.beens.Zakaz ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ZakazDAO implements InterfaceDao<Zakaz> {

    public boolean create(Zakaz zakaz) throws SQLException {
//        String sql = String.format(Locale.ENGLISH,
//                "INSERT INTO `zakaz`(`id_zakaz`,`date_zakaz`, `koltort`, `price_zakaz`, " +
//                        "`users_id_users`, `cake_id_cake`) " +
//                        "VALUES ('%d','%s',%d,%f,%d,%d)",
//                zakaz.getId_zakaz(),zakaz.getDate_zakazS(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
//                zakaz.getId_user(), zakaz.getId_cake());
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `zakaz`(`date_zakaz`, `koltort`, `price_zakaz`, " +
                        "`id_user`, `id_cake`) " +
                        "VALUES ('%s',%d,%f,%d,%d)",
                zakaz.getDate_zakaz(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
                zakaz.getId_user(), zakaz.getId_cake());
        System.out.println(sql);
        long id = Dao.executeCreateAndGetId(sql);
        zakaz.setId_zakaz(id);
        return (id>0);
    }


    public boolean delete(Zakaz zakaz) throws SQLException {
        String sql = String.format("DELETE FROM `zakaz` WHERE " +
                "`zakaz`.`id_zakaz` = %d", zakaz.getId_zakaz());
        System.out.println(sql);

        return Dao.executeUpdate(sql);
    }

    public boolean update(Zakaz zakaz) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `zakaz` SET `date_zakaz` = '%s', " +
                        "`koltort` = '%d', `price_zakaz` = '%f', `id_user` = '%d', " +
                        "`id_cake` = '%d'" +
                        " WHERE `zakaz`.`id_zakaz` = %d",
                zakaz.getDate_zakaz(),zakaz.getKoltort(),zakaz.getPrice_zakaz(),
                zakaz.getId_user(), zakaz.getId_cake(),zakaz.getId_zakaz());
        System.out.println(zakaz.getId_zakaz());
        System.out.println(sql);
        return Dao.executeUpdate(sql);
    }


    public Zakaz read(long id_zakaz) throws SQLException {
        String sqlSuffix = String.format("WHERE `id_zakaz`=%d", id_zakaz);
        List<Zakaz> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }


    @Override
    public List<Zakaz> getAll(String sqlSuffix) throws SQLException {
        List<Zakaz> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `zakaz` %s", sqlSuffix);
        System.out.println(sql);
        System.out.println(sqlSuffix);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(sql);
            System.out.println(sqlSuffix);
            while (resultSet.next()) {
                //id ok
                long id_zakaz = resultSet.getLong("id_zakaz");
                String date_zakazS = resultSet.getString("date_zakaz");
                int koltort = resultSet.getInt("koltort");
                double price_zakaz = resultSet.getDouble("price_zakaz");
                long id_user = resultSet.getLong("id_user");
                long id_cake = resultSet.getLong("id_cake");
                Zakaz zakaz = new Zakaz(id_zakaz, date_zakazS, koltort, price_zakaz, id_user, id_cake);
                result.add(zakaz);
            }
            return result;
        }
    }

    @Override
    public List<Zakaz> getAll() throws SQLException {
            List<Zakaz> result = new ArrayList<>();
            String sql = String.format("SELECT * FROM `zakaz`");

            try (Connection connection = Connected.getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    //id ok
                    long id_zakaz = resultSet.getLong("id_zakaz");
                    String date_zakazS = resultSet.getString("date_zakaz");
                    int koltort = resultSet.getInt("koltort");
                    double price_zakaz = resultSet.getDouble("price_zakaz");
                    long id_user = resultSet.getLong("id_user");
                    long id_cake = resultSet.getLong("id_cake");
                    Zakaz zakaz = new Zakaz(id_zakaz, date_zakazS, koltort, price_zakaz, id_user, id_cake);
                    result.add(zakaz);
                }
                return result;
            }
    }
}

