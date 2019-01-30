package by.it.vchernetski.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        if(!Util.checkUser(request)){
            return Action.LOGIN;
        }
        if(!Form.isPost(request)){
            request.getSession(false).invalidate();
            return Action.LOGIN;
        }
        return Action.PROFILE;
    }
}
