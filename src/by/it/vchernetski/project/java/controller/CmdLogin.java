package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdLogin implements Cmd{
    @Override
    public Action execute(HttpServletRequest request)throws Exception {
        if (Form.isPost(request)) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if(!login.matches("[a-zA-Z0-9]{3,}")) throw new MyException("invalid login");
            if(!password.matches("[a-zA-Z0-9_\\-]{4,}")) throw new MyException("invalid password");
            User user = new User();
            MyDAO<User> dao = MyDAO.getDao();
            dao.setBean(user);
            List<User> list = dao.getAll(" WHERE password = '"+password+"' and nickname = '"+login+"' LIMIT 0,1");
            if(list.size()==1){
                user = list.get(0);
                request.getSession().setAttribute("user",user);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
