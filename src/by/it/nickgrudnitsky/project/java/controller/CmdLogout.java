package by.it.nickgrudnitsky.project.java.controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req, HttpServletResponse resp) {
                req.getSession().invalidate();
                return Action.LOGIN;
    }
}
