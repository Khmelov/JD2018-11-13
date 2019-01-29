package by.it.nickgrudnitsky.project.java.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SiteException {
        if (Form.isPost(req)){
            HttpSession session = Session.getSession(req);
            session.removeAttribute("user");
            session.invalidate();
        }
        return Action.BROWSE;
    }
}
