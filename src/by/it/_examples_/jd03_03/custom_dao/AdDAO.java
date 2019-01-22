package by.it._examples_.jd03_03.custom_dao;

import by.it._examples_.jd03_03.beans.Ad;
import by.it._examples_.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDAO extends AbstractDAO implements InterfaceDAO<Ad> {
    @Override
    public Ad read(int id) {
        List<Ad> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Ad ad) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO ads (RoomCount,Price,Area,Floor,Floors,Address,Description,FK_Users)" +
                        "\n values('%d', '%.3f', '%.3f', '%d', '%d', '%s', '%s' ,'%d');",
                ad.getRoomCount(),
                ad.getPrice(),
                ad.getArea(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getAddress(),
                ad.getDescription(),
                ad.getFK_Users()
        );
        ad.setID(executeUpdate(sql));
        return (ad.getID() > 0);
    }

    @Override
    public boolean update(Ad ad) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ads` SET " +
                        "`RoomCount`=%d " +
                        ",`Price`='%.3f'" +
                        ",`Area`='%.3f'" +
                        ",`Floor`=%d" +
                        ",`Floors`=%d" +
                        ",`Address`='%s'" +
                        ",`Description`='%s'" +
                        ",`FK_Users`=%d " +
                        " WHERE `ad`.`ID` = %d",
                ad.getRoomCount(),
                ad.getPrice(),
                ad.getArea(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getAddress(),
                ad.getDescription(),
                ad.getFK_Users(),
                ad.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Ad ad) {
        String sql = String.format(
                "DELETE FROM `ads` WHERE `ad`.`ID`=%d;", ad.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Ad> getAll(String WHERE) {
        List<Ad> ads = new ArrayList<>();
        String sql = "SELECT * FROM ads " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Ad ad = new Ad();
                ad.setID(rs.getInt("ID"));
                ad.setAddress(rs.getString("Address"));
                ad.setArea(rs.getDouble("Area"));
                ad.setDescription(rs.getString("Description"));
                ad.setFK_Users(rs.getInt("FK_Users"));
                ad.setFloor(rs.getInt("Floor"));
                ad.setFloors(rs.getInt("Floors"));
                ad.setPrice(rs.getDouble("Price"));
                ad.setRoomCount(rs.getInt("RoomCount"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }
}
