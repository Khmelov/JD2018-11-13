package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.Theme;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ThemeDao implements InterfaceDao<Theme> {

    public boolean create(Theme theme) throws SQLException {
        String sql = String.format(
                "INSERT INTO `themes` (`id_theme`, `theme`) " +
                        "VALUES ('%d', '%s')",
                theme.getId(), theme.getTheme()
        );
        long id = Dao.executeCreateAndGetId(sql);
        theme.setId(id);
        return (id > 0);
    }

    public boolean delete(Theme theme) throws SQLException {
        String sql = String.format(
                "  DELETE FROM `themes` WHERE `themes`.`id_theme` = %d",
                theme.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public boolean update(Theme theme) throws SQLException {
        String sql = String.format(
                "UPDATE `themes` SET " +
                        "`theme` = '%s' " +
                        "WHERE `themes`.`id_theme` = %d",
                theme.getTheme(), theme.getId()
        );
        return Dao.executeUpdate(sql);
    }

    public Theme read(long id) throws SQLException {
        String sqlSuffix = String.format("WHERE id_type = %d", id);
        List<Theme> all = getAll(sqlSuffix);
        return all.size() > 0 ? all.get(0) : null;
    }

    @Override
    public List<Theme> getAll(String sqlSuffix) throws SQLException {
        List<Theme> result=new ArrayList<>();
        String sql = String.format("SELECT `id_theme`, `theme` " +
                "FROM `themes` %s",sqlSuffix);
        try (Connection connection = Connect.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {

                long id = resultSet.getLong("id_theme");
                String theme = resultSet.getString("theme");
                Theme theme1 = new Theme(id,theme);
                result.add(theme1);
            }
            return result;
        }
    }
}
