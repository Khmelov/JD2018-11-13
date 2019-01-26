package by.it.zhivov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {
    abstract Action execute(HttpServletRequest req);

    @Override
    public String toString(){
        String simpleName=this.getClass().getSimpleName();
        String cmd = simpleName.replaceFirst("Cmd","");
        return cmd.toLowerCase();
    }
}
