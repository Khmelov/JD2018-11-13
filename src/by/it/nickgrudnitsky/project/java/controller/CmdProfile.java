package by.it.nickgrudnitsky.project.java.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdProfile extends Cmd {
   @Override
   Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException {

       if (!Util.checkViewer(req)){
           return Action.LOGIN;
       }

       if (Form.isPost(req)){
        if (Form.getString(req, "logout")!=null){
            req.getSession().invalidate();
            return Action.LOGIN;
        }
    }
    return Action.PROFILE;
   }
}
