package by.it.naumenko.project2.java.controller;

import by.it.naumenko.project2.java.beens.Profil;
import by.it.naumenko.project2.java.beens.Users;
import by.it.naumenko.project2.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class CommandProfil extends Command {

    @Override
    public Actions exequit(HttpServletRequest req, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {


        if (Util.checkCookie(req) || Util.checkUser(req)) {
            Users user = Util.findUser(req);
            MyDAO<Profil> myDAO = new MyDAO<>(new Profil(), "profil");
            String where = String.format(" WHERE id_user = '%d' LIMIT 0,1", user.getId_user());
            List<Profil> profilList = myDAO.getAll(where);
            if (profilList.size() == 1) {
                Profil profil = profilList.get(0);
                System.out.println(profil);
                req.getSession().setAttribute("profil", profil);
            }
            return Actions.PROFILE;
        }
        if (!Util.checkUser(req))
            return Actions.LOGIN;

        return Actions.PROFILE;
    }
}
