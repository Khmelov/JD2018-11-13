package by.it.kruglenja.Project.java.controller;

public enum  Action {
    INDEX{
        {
            cmd = new CmdIndex();
            jsp = "/index.jsp";
        }
    }, LOGIN{
        {
            cmd = new CmdIndex();
            jsp = "/login.jsp";
        }
    }, LOGUOT{
        {
            cmd = new CmdIndex();
            jsp = "/logout.jsp";
        }
    }, SIGNUP{
        {
            cmd = new CmdIndex();
            jsp = "/signup.jsp";
        }
    }, ERROR{
        {
            cmd = new CmdIndex();
            jsp = "/error.jsp";
        }
    };
    Cmd cmd = new CmdError();
    String jsp = "/error.jsp";

}
