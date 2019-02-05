package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.Role;
import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        MyDAO<User> dao = MyDAO.getDao();
        if (Util.checkUser(request)) {
            if (Form.isPost(request)) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String fio = request.getParameter("fio");
                int ng = Integer.parseInt(request.getParameter("numbergarages"));
                long roles_id = Long.parseLong(request.getParameter("roles_id"));
                long id = Long.parseLong(request.getParameter("id"));
                User user = new User(id, fio, login, email, password, ng, roles_id);
                dao.setBean(user);
                if (request.getParameter("Update") != null) {
                    dao.update();
                }
                if(request.getParameter("Delete") != null){
                    dao.delete();
                }
            }
            dao.setBean(Util.findUser(request));
            List<User> users = dao.getAll();
            request.setAttribute("users", users);
            MyDAO<Role> daor = MyDAO.getDao();
            daor.setBean(new Role());
            List<User> roles = daor.getAll();
            request.getServletContext().setAttribute("roles", roles);
        }
        return Action.EDITUSERS;
    }
}
