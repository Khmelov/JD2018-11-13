package by.it.naumenko.project.java.controller;

enum Actions {
    SIGNUP{
        {
            this.command = new CommandSignup();
        }
    },
    LOGIN{
        {
            this.command = new CommandLogin();
        }
    },
    LOGOUT{
        {
            this.command = new CommandLogOut();
        }
    },
    ERROR{
        {
            this.command = new CommandError();
        }
    };

    public String jsp = "/error.jsp";
    public ICommand command;
    public ICommand getCommand(){
        return command;
    }
}
