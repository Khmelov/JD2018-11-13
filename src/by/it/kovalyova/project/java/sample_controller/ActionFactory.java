package by.it.kovalyova.project.java.sample_controller;

import by.it._examples_.jd03_04.java.sample_controller.ActionCommand;
import by.it._examples_.jd03_04.java.sample_controller.Actions;
import by.it._examples_.jd03_04.java.sample_controller.CommandError;
import by.it._examples_.jd03_04.java.sample_controller.Messages;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    by.it._examples_.jd03_04.java.sample_controller.ActionCommand defineCommand(HttpServletRequest request) {
        by.it._examples_.jd03_04.java.sample_controller.ActionCommand current = new by.it._examples_.jd03_04.java.sample_controller.CommandError();
        // извлечение имени команды из запроса ?command=action_name
        String action = request.getParameter("command");
        // получение объекта, соответствующего команде
        if (action != null && !action.isEmpty()) {
            try {
                by.it._examples_.jd03_04.java.sample_controller.Actions currentEnum = by.it._examples_.jd03_04.java.sample_controller.Actions.valueOf(action.toUpperCase());
                current = currentEnum.getCurrentCommand();
            } catch (IllegalArgumentException e) {
                request.setAttribute(by.it._examples_.jd03_04.java.sample_controller.Messages.msgError, "<b>Unknown command: "+action+"</b>");
                request.setAttribute(Messages.msgMessage, "<b>Unknown command: "+action+"</b>");
            }
        }
        //если команда не найдена, то вернем пустую.
        //иначе вернем команду для выполнения
        return current;
    }
}