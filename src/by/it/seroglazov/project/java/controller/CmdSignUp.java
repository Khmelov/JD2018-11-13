package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.Ingredient;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {
        Dao<Ingredient> ingDao = new MyDao<>(new Ingredient());
        //ingDao.create(new Ingredient("pervak"));
        Ingredient ing = ingDao.read(1);
        req.setAttribute("ingredient1", ing.getName());
        return null;
    }
}
