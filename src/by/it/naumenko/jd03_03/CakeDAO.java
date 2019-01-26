package by.it.naumenko.jd03_03;

import by.it.naumenko.jd03_03.beens.Cake;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CakeDAO implements InterfaceDao<Cake> {

    public boolean create(Cake cake) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `cake`(`name_cake`, `size_cake`, `weight_cake`, " +
                        "`bescuit`, `decoration`, `cream`, `price_cake`) VALUES " +
                        "('%s',%d,%f,'%s','%s','%s',%f)",
                cake.getName_cake(), cake.getSize_cake(), cake.getWeight_cake(),
                cake.getBescuit(), cake.getDecoration(), cake.getCream(), cake.getPrice_cake());
        long id = Dao.executeCreateAndGetId(sql);
        cake.setId_cake(id);
        return (id > 0);
    }


    public boolean delete(Cake cake) throws SQLException {
        String sql = String.format("DELETE FROM `cake` WHERE " +
                "`cake`.`id_cake` = %d", cake.getId_cake());
        return Dao.executeUpdate(sql);
    }

    public boolean update(Cake cake) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `cake` SET `name_cake` = '%s', `size_cake` = %d, " +
                        "`weight_cake` = %f, `bescuit` = '%s', `decoration` = '%s', " +
                        "`cream` = '%s', `price_cake` = %f WHERE `cake`.`id_cake` = %d",
                cake.getName_cake(), cake.getSize_cake(), cake.getWeight_cake(),
                cake.getBescuit(), cake.getDecoration(), cake.getCream(),
                cake.getPrice_cake(), cake.getId_cake());
        return Dao.executeUpdate(sql);
    }


    public Cake read(long id_cake) throws SQLException {
        String sqlSuffix = String.format("WHERE `id_cake`=%d", id_cake);
        List<Cake> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Cake> getAll(String sqlSuffix) throws SQLException {
        List<Cake> result = new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `cake` %s", sqlSuffix);
        System.out.println(sql);
        System.out.println(sqlSuffix);
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(sql);
            System.out.println(sqlSuffix);
            while (resultSet.next()) {
                //id ok
                long id_cake = resultSet.getLong("id_cake");
                String name_cake = resultSet.getString("name_cake");
                int size_cake = resultSet.getInt("size_cake");
                float weight_cake = resultSet.getFloat("weight_cake");
                String bescuit = resultSet.getString("bescuit");
                String decoration = resultSet.getString("decoration");
                String cream = resultSet.getString("cream");
                double price_cake = resultSet.getDouble("price_cake");
                Cake cake = new Cake(id_cake, name_cake, size_cake, weight_cake, bescuit, decoration, cream, price_cake);
                result.add(cake);
            }
            return result;
        }
    }

    @Override
    public List<Cake> getAll() throws SQLException {
        List<Cake> result = new ArrayList<>();
        String sql = String.format("SELECT * FROM `cake`");
        try (Connection connection = Connected.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //id ok
                long id_cake = resultSet.getLong("id_cake");
                String name_cake = resultSet.getString("name_cake");
                int size_cake = resultSet.getInt("size_cake");
                float weight_cake = resultSet.getFloat("weight_cake");
                String bescuit = resultSet.getString("bescuit");
                String decoration = resultSet.getString("decoration");
                String cream = resultSet.getString("cream");
                double price_cake = resultSet.getDouble("price_cake");
                Cake cake = new Cake(id_cake, name_cake, size_cake, weight_cake, bescuit, decoration, cream, price_cake);
                result.add(cake);
            }
            return result;
        }
    }
}


