package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.Ad;
import by.it.zhivov.project.java.dao.AdDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdSearchResult implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteExeption {
        if (Form.isPost(req)) {
            String searchWord = Form.getString(req, "search", "[a-zA-Zа-яА-Я0-9- ]{0,45}");
            List<Ad> ads = AdDao.searchAd(searchWord);
            req.setAttribute("ads", ads);
            if (req.getParameter("gosearch") != null) {
                return Action.SEARCHRESULT;
            }
        }
        return Action.LOGIN;
    }
}
