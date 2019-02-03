package by.it.kovalyova.project04.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (Form.isPost(req)) {
            //create ad etc
        }
            return null;
        }
    }
