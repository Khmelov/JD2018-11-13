package by.it.skarpovich.project.java.controller;
import by.it.skarpovich.project.java.beans.User;
import by.it.skarpovich.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if (Util.checkUser(req)) {
            Dao dao = Dao.getDao();

            if (Form.isPost(req)) {
                int id = Form.getInteger(req,"id");
                String username = Form.getString(req,"username", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
                String password = Form.getString(req,"password", "[a-zA-Zа-яёА-ЯЁ0-9_]{4,}");
                String email = Form.getString(req,"email");
                String fullname = Form.getString(req,"fullname");
                String phone = Form.getString(req,"phone");
                String address = Form.getString(req,"address");
                int roles_id = Form.getInteger(req,"roles_id");
                User user = new User(id, username, password, email, fullname, phone, address, roles_id);

                if (req.getParameter("Update") != null)
                    dao.user.update(user);
                else if (req.getParameter("Delete") != null)
                    dao.user.delete(user);
            }
            List<User> users = dao.user.getAll();
            System.out.println("-------------\n"+users);
            req.setAttribute("users", users);
        }
        return Action.EDITUSERS;
    }
}