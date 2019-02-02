package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Profil;
import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class CommandEditProfil extends Command {
    @Override
    Actions exequit(HttpServletRequest req, HttpServletResponse response) throws SQLException, SiteException, LoginException, NoSuchAlgorithmException {
        if (Util.checkUser(req)) {
            Users user = Util.findUser(req);
            System.out.println(user.getId_user());
            if (Form.isPost(req)) {
                String name_profile = Form.getString(req, "name_profile");
                String lastName_profil = Form.getString(req, "lastName_profil");
                int dayBirth = (int) Form.getLong(req, "dayBirth");
                String mountBirth = Form.getString(req, "mountBirth");
                int yearBirth = (int) Form.getLong(req, "yearBirth");
                //String pol = Form.getString(req, "pol");
                String city = Form.getString(req, "city");
                String street = Form.getString(req, "street");
                int home = (int) Form.getLong(req, "home");
                int korpus = (int) Form.getLong(req, "korpus");
                int kvartira = (int) Form.getLong(req, "kvartira");
                String tel = Form.getString(req, "tel");
                String about = Form.getString(req, "about");
                Profil profil = new Profil(user.getId_user(), name_profile, lastName_profil, dayBirth, mountBirth,
                        yearBirth, "men", city, street, home, korpus, kvartira,
                        tel, 3, about, user.getId_user());
//                if(req.getParameter("save")!=null) {
                MyDAO<Profil> dao = new MyDAO<>(new Profil(), "profil");
                if (dao.update(profil))
                    return Actions.PROFILE;
                else
                    return Actions.ERROR;
            }
        }
        return Actions.ERROR;
    }
}
