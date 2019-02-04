package by.it.denisova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {
    ANSWERQUESTION(new CmdAnswerQuestion()),
    RESET(new CmdReset()),
    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    LESSON(new CmdLesson()),
    EDITUSERS(new CmdEditUsers()),
    TEST(new CmdCreateTest());


    Cmd cmd;

    Action(Cmd cmdIndex) {
        cmd = cmdIndex;
    }

    String getJsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        Action result = Action.INDEX;
        String command = req.getParameter("command");
        if (command != null && !command.isEmpty()) {
            try {
                result = Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){
                //create our error
            }
        }
        return result;
    }

}
