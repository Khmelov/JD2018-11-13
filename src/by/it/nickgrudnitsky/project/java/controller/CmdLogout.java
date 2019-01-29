package by.it.nickgrudnitsky.project.java.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            session.invalidate();
        }
        return Action.LOGIN;
    }
}
