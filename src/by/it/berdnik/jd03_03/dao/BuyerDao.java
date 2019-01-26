package by.it.berdnik.jd03_03.dao;

import by.it.berdnik.jd03_03.beans.Buyer;

import java.sql.SQLException;
import java.util.List;

public class BuyerDao implements InterfaceDao<Buyer> {
    @Override
    public boolean create(Buyer bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Buyer bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Buyer bean) throws SQLException {
        return false;
    }

    @Override
    public Buyer read(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Buyer> getAll(String sqlSuffix) throws SQLException {
        return null;
    }
}
