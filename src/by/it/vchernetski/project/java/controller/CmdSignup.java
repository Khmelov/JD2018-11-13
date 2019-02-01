package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;

class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if (Form.isPost(request)) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String fio = request.getParameter("fio");
            int ng = Integer.parseInt(request.getParameter("numberofgarages"));
            User user = new User();
            if(email.matches("[a-zA-Z0-9/.]{3,}@[a-zA-Z0-9/.]{3,}")){
                user.setEmail(email);

            }
            else
                throw new MyException("invalid email");
            if(login.matches("[a-zA-Z0-9]{3,}")) {
                user.setNickname(login);
            }
            else throw new MyException("invalid login");
            if(password.matches("[a-zA-Z0-9_\\-]{4,}")){
                user.setPassword(password);
            }
            else
                throw new MyException("invalid password");
            if(fio.matches("[a-zA-Z ]{6,}")) {
                user.setFio(fio);
            }
            else
                throw new MyException("invalid fio");
            if(ng>0||ng<11) {
                user.setNumbergarages(ng);
            }
            else
                throw new MyException("invalid number of garages");
            user.setRoles_id(1);
            MyDAO<User> dao = MyDAO.getDao();
            dao.setBean(user);
            if (dao.create())
                request.getSession().setAttribute("user",user);
                return Action.PROFILE;
        }
        return Action.SIGNUP;
    }
}

