package by.it.kovalyova.project04.java.controller;

public enum  Action {

    INDEX {
        {
        cmd=new CmdIndex();
        jsp="/index.jsp";
        }
    },   LOGIN {
        {
            cmd=new CmdLogin();
            jsp="/login.jsp";
        }
    },  LOGOUT{
        {
            cmd=new CmdLogout();
            jsp="/logout.jsp";
        }
    },   SIGNUP{
        {
            cmd=new CmdSignup();
            jsp="/signup.jsp";
        }
    },ERROR{
        {
            cmd=new CmdError();
            jsp="/error.jsp";
        }
    };

    Cmd cmd = new CmdError();
    String jsp="/error.jsp";

}
