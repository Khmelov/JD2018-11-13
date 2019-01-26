package by.it.naumenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionDefiner {

    static Actions define(HttpServletRequest request){
        Actions resultat = Actions.ERROR;
        String command = request.getParameter("command");
        if (command!=null && !command.isEmpty()){
            try {
                resultat = Actions.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException ignored){

            }
        }
        return resultat;
    }


}
