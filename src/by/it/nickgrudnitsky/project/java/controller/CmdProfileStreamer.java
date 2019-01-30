package by.it.nickgrudnitsky.project.java.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdProfileStreamer extends Cmd {
   @Override
   Action execute(HttpServletRequest req, HttpServletResponse resp) throws SiteException {

       if (!Util.checkStreamer(req, resp)){
           return Action.LOGINSTREAMER;
       }

       if (Form.isPost(req)){
        if (Form.getString(req, "logout")!=null){
            req.getSession().invalidate();
            return Action.LOGINSTREAMER;
        }
    }
    return Action.PROFILESTREAMER;
   }
}
