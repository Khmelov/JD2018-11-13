package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.List;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if(Util.checkUser(request)) {
            return Action.PROFILE;
        }
        if (Form.isPost(request)) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (!Form.checkInputData(login, "[a-zA-Z0-9]{3,}")) throw new MyException("invalid login");
            if (!Form.checkInputData(password, "[a-zA-Z0-9_\\-]{4,}")) throw new MyException("invalid password");
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encode = encoder.encode(password.getBytes());
            String encodepassword = new String(encode);
            Cookie pas = new Cookie("password", encodepassword);
            Cookie log = new Cookie("login", login);
            pas.setMaxAge(300);
            log.setMaxAge(300);
            FrontController.response.addCookie(pas);
            FrontController.response.addCookie(log);
            User user = new User();
            MyDAO<User> dao = MyDAO.getDao();
            dao.setBean(user);
            List<User> list = dao.getAll(" WHERE password = '" + password + "' and nickname = '" + login + "' LIMIT 0,1");
            if (list.size() == 1) {
                user = list.get(0);
                user.setPassword(encodepassword);
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(15);
                session.setAttribute("user", user);
                return Action.PROFILE;
            } else throw new MyException("There is no such user");
        }
        return Action.LOGIN;
    }
}
