package by.it.nickgrudnitsky.project.java.filters;

import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;
import by.it.nickgrudnitsky.project.java.dao.MyDao;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CookieControl implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getSession(false) == null) {
            Cookie[] cookies = req.getCookies();
            String password = "";
            String nickname = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                    if (cookie.getName().equals("nickname")) {
                        nickname = cookie.getValue();
                    }
                }
            }
            String whereV = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", password, nickname);
            String whereS = String.format(" WHERE password='%s' and channelname='%s' LIMIT 0,1", password, nickname);
            MyDao dao = MyDao.getDao();
            try {
                List<Viewer> viewers = dao.viewer.getAll(whereV);
                if (viewers.size()==1) {
                    Viewer viewer = viewers.get(0);
                    req.getSession(true).setAttribute("user", viewer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                List<Streamer> streamers = dao.streamer.getAll(whereS);
                if (streamers.size()==1) {
                    Streamer streamer = streamers.get(0);
                    req.getSession(true).setAttribute("user", streamer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(req, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
