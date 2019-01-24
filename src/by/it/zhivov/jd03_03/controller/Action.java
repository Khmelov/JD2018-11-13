package by.it.zhivov.jd03_03.controller;

public enum Action {
    INDEX {{
        cmd = new CmdIndex();
        String jsp = "/error.jsp";
    }}, LOGIN {
        cmd = new CmdLogin();
        String jsp = "/error.jsp";
    }, LOGOUT {
        cmd = new CmdLogout();
        String jsp = "/error.jsp";
    }, SIGNUP {
        cmd = new CmdSignUp();
        String jsp = "/error.jsp";
    }, ERROR {
        cmd = new CmdError();
        String jsp = "/error.jsp";
    }

    Cmd cmd;
}
