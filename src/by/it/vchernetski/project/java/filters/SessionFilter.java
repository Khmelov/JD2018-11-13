package by.it.vchernetski.project.java.filters;

import by.it.vchernetski.project.java.beans.User;
import by.it.vchernetski.project.java.dao.MyDAO;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        String login = "";
        String password="";
        if(session==null&&request!=null){
            Cookie[] cookies = request.getCookies();
            if(cookies.length>0) {
                for (Cookie cook : cookies) {
                    if (cook.getName().equals("password")){
                        Base64.Decoder decoder = Base64.getDecoder();
                        byte[] decode = decoder.decode(cook.getValue());
                        password=new String(decode);
                    }
                    if(cook.getName().equals("login")){
                        login = cook.getValue();
                    }
                }
            }
            User user = new User();
            MyDAO<User> dao  = MyDAO.getDao();
            dao.setBean(user);
            List<User> list= null;
            try {
            list =dao.getAll(" WHERE password = '" + password + "' and nickname = '" + login + "' LIMIT 0,1");
            if(list.size()==1){
                session = request.getSession();
                user=list.get(0);
                session.setAttribute("user",user);
            }
            }
            catch (Exception e){}
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
