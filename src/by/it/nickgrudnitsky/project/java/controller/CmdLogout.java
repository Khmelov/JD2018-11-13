package by.it.nickgrudnitsky.project.java.controller;





import javax.servlet.http.HttpServletRequest;



class CmdLogout extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
            /*if (Form.getString(req, "login")!=null){*/
                req.getSession().invalidate();
                return Action.LOGIN;
            }
        /*}*/
        return Action.PROFILE;
    }
}
