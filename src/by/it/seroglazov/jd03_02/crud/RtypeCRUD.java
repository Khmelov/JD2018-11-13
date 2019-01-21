package by.it.seroglazov.jd03_02.crud;

import by.it.seroglazov.jd03_02.MyDatabaseConnector;
import by.it.seroglazov.jd03_02.beans.Rtype;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RtypeCRUD {
    public boolean create(Rtype... ingredients) throws SQLException {
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `rtypes` (`id`, `text`) VALUES ");
            String value = "(DEFAULT, '%s'), ";
            for (Rtype rtype : ingredients) {
                sb.append(String.format(value, rtype.getText()));
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append(';');
            String sql = sb.toString();
            if (ingredients.length == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                for (Rtype rtype : ingredients) {
                    if (generatedKeys.next()) {
                        rtype.setId(generatedKeys.getLong(1));
                    }
                }
                return true;
            } else
                return false;
        }
    }

    public boolean delete(Rtype rtype) throws SQLException {
        String sql = String.format("DELETE FROM `rtypes` WHERE `rtypes`.`id` = %d ", rtype.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            return (1 == statement.executeUpdate(sql));

        }
    }

    public boolean update(Rtype rtype) throws SQLException {
        String sql = String.format("UPDATE `rtypes` SET `text` = '%s' WHERE `rtypes`.`id` = %d;",
                rtype.getText(), rtype.getId());
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public Rtype read(long id) throws SQLException {
        String sql = String.format("SELECT `text` FROM `rtypes` WHERE id=%d", id);
        try (Connection connection = MyDatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Rtype unit = new Rtype();
                unit.setId(id);
                unit.setText(resultSet.getString(1));
                return unit;
            } else
                return null;
        }
    }
}
