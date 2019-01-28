package by.it.kovalyova.project.java.sample_controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

// @WebServlet("/do")
public class FrontController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        ActionFactory client = new ActionFactory(); // определение команды, пришедшей из JSP
        ActionCommand command = client.defineCommand(request);

        //вызов реализованного метода execute() и передача параметров
        //классу-обработчику конкретной команды. Обработчик должен вернуть адрес view
        String viewPage = null;
        try {
            viewPage = command.execute(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setHeader("Cache-Control", "no-store");

        //метод отправляет пользователю страницу ответа
        if (viewPage != null) {
            ServletContext servletContext=getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewPage);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
            //можно короче:
            //getServletContext().getRequestDispatcher(viewPage).forward(request,response);
        } else {
            // установка страницы c cообщением об ошибке
            viewPage = Actions.ERROR.jsp;
            response.sendRedirect(request.getContextPath() + viewPage);
        }
    }
}