package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Profil;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class CommandProfile extends Command {

    @Override
    Actions exequit(HttpServletRequest req, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {
        MyDAO<Profil> myDAO = new MyDAO<>(new Profil(),"profil");
        String where = String.format(" WHERE id_user = '%d' LIMIT 0,1",2);
        List<Profil> profilList = myDAO.getAll(where);
        System.out.println(where);
        if(profilList.size()==1){
            Profil profil=profilList.get(0);
            System.out.println(profil);
            req.getSession().setAttribute("profil", profil);
        }

        if(Util.checkCookie(req))
            return Actions.PROFILE;

        if (!Util.checkUser(req))
            return Actions.LOGIN;

        return Actions.PROFILE;
    }
}
