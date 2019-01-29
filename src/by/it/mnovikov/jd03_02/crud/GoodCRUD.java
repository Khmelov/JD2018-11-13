package by.it.mnovikov.jd03_02.crud;

import by.it.mnovikov.jd03_02.beans.Good;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class GoodCRUD {

    public boolean create(Good good) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `goods`(" +
                        "`title`, `discription`, `type`," +
                        "`productivity`, `price`)" +
                        "VALUES ('%s', '%s', '%s','%f','%f')",
                good.getTitle(), good.getDiscription(), good.getType(),
                good.getProductivity(), good.getPrice());
        try (Statement statement = Connect_DB.getConnection().createStatement()) {

            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    good.setId(keys.getInt(1));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Good good) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `goods` WHERE `goods`.`id`='%d'", good.getId());
        try (Statement statement = Connect_DB.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean update(Good good) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `goods` SET" +
                        "`title`='%s',`discription`='%s',`type`='%s'," +
                        "`productivity`='%f',`price`='%f' WHERE `goods`.`id`='%d'",
                good.getTitle(), good.getDiscription(), good.getType(),
                good.getProductivity(), good.getPrice(),good.getId());
        try(Statement statement = Connect_DB.getConnection().createStatement()){
            return 1 == statement.executeUpdate(sql);
        }
    }

    public Good good(int id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT `ID`, `title`, `discription`, `type`, `productivity`," +
                        "`price` FROM `goods` WHERE `goods`.`id`='%d'", id);
        try(Statement statement = Connect_DB.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                String title = resultSet.getString("title");
                String discription = resultSet.getString("discription");
                String type = resultSet.getString("type");
                float productivity = resultSet.getFloat("productivity");
                float price = resultSet.getFloat("price");
                return new Good(id, title, discription, type, productivity, price);
            } else return null;
        }
    }

}
