package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Profil;
import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

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
            System.out.println(where);
            if (profilList.size() == 1) {
                Profil profil = profilList.get(0);
                System.out.println(profil);
                req.getSession().setAttribute("profil", profil);
            }

           /* if (Form.isPost(req)) {
                String name_profile = Form.getString(req, "name_profile");
                String lastName_profil = Form.getString(req, "lastName_profil");
                int dayBirth = Form.getInteger(req, "dayBirth");
                String mountBirth = Form.getString(req,"mountBirth");
                int yearBirth = Form.getInteger(req,"yearBirth");
                String pol = Form.getString(req,"pol");
                String city = Form.getString(req,"city");
                String street = Form.getString(req,"street");
                int home = Form.getInteger(req, "home");
                int korpus = Form.getInteger(req,"korpus");
                int kvartira = Form.getInteger(req,"kvartira");
                String tel = Form.getString(req,"tel");
                String about = Form.getString(req,"about");
                Profil profil=new Profil(0,name_profile,lastName_profil,dayBirth,mountBirth,
                        yearBirth, pol, city,street,home,korpus,kvartira,
                                tel,3,about, user.getId_user());
//                if(req.getParameter("save")!=null) {
                    myDAO.update(profil);
                    return Actions.EDITPROFIL;

//                }
//                profilList=myDAO.getAll();
//                req.setAttribute("profile",profilList);

            }*/
            return Actions.PROFILE;
        }
        if (!Util.checkUser(req))
            return Actions.LOGIN;

        return Actions.PROFILE;
    }
}
