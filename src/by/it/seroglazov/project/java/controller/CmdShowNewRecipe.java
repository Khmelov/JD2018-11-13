package by.it.seroglazov.project.java.controller;

import by.it.seroglazov.project.java.beans.*;
import by.it.seroglazov.project.java.dao.Dao;
import by.it.seroglazov.project.java.dao.MyDao;

import javax.servlet.http.HttpServletRequest;

class CmdShowNewRecipe extends Cmd {

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        return Action.SHOWNEWRECIPE;
    }
}
