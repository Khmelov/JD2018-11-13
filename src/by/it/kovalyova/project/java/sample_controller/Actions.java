package by.it.kovalyova.project.java.sample_controller;


import by.it._examples_.jd03_04.java.sample_controller.ActionCommand;
import by.it._examples_.jd03_04.java.sample_controller.CommandLogin;
import by.it._examples_.jd03_04.java.sample_controller.CommandLogout;
import by.it._examples_.jd03_04.java.sample_controller.CommandSignUp;

enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.jsp ="/signup.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.jsp ="/login.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.jsp ="/profile.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    };
    public String jsp ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }


}