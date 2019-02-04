package by.it.kovalyova.project04.java.controller;


import by.it.kovalyova.project04.java.beans.Ad;
import by.it.kovalyova.project04.java.beans.Flat;
import by.it.kovalyova.project04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class СmdTable implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        List<Ad> ads = Dao.getDao().ad.getAll();
        List<Flat> flats = new ArrayList<>();
        for (Ad ad: ads) {
            Flat flat = Dao.getDao().flat.read(ad.getFlats_id());
            flats.add(flat);
        }
        req.setAttribute("ads",ads);
        req.setAttribute("flats",flats);
        return null;
    }
}
