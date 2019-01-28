package by.it.kovalyova.jd03_03.dao;



import by.it.kovalyova.jd03_03.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDao implements InterfaceDao<Ad>{
    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(
                " INSERT INTO `ads`(" +
                        "`price`, `users_id`," +
                        " `flats_id`)" +
                        " VALUES (" +
                        "'%f','%d','%d')",

                ad.getPrice(),ad.getUsers_id()
        );
        long id = Dao.executeCreateAndGetId(sql);
        ad.setId(id);
           return  (id > 0);


    }

   public boolean delete(Ad ad) throws SQLException {
        String sql = String.format(
               "DELETE FROM `ads` WHERE `ads`.`id` = %d",
               ad.getId()
       );
       return Dao.executeUpdate(sql);
    }

    public boolean update(Ad ad) throws SQLException {
        String sql = String.format(
                "UPDATE `ads` SET" +
                        " `price`='%f]," +
                        "`users_id`='%d',`flats_id`='%d'" +
                        " WHERE `id`='%d',",
               ad.getPrice(), ad.getUsers_id()
        );
        return Dao.executeUpdate(sql);
        }


   public Ad read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id=%d", id);
       List<Ad> all = getAll(sqlSuffix);
       return all.size() > 0 ? all.get(0) : null;
          }

    @Override
    public List<Ad> getAll(String sqlSuffix) throws SQLException {
        List<Ad> result=new ArrayList<>();
        String sql = String.format("SELECT * " +
                "FROM `users` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // id ok
                //SELECT `id`, `price`, `users_id`, `flats_id` FROM `ads` WHERE 1
                Long id = resultSet.getLong("id");
                Double price = resultSet.getDouble("price");
                Long users_id = resultSet.getLong("users_id");
                Long flats_id = resultSet.getLong("flats_id");



               //  Ad ad = new Ad(id, price, users_id, flats_id);
               //  result.add(ad);
            }

                return result;
        }
    }
}
