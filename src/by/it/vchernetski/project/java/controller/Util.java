package by.it.vchernetski.project.java.controller;

import by.it.vchernetski.project.java.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {
    static User findUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object user = session.getAttribute("user");
            if (user != null) {
                return (User) user;
            }
        }
        return null;
    }

    static boolean checkUser(HttpServletRequest request) {
        return findUser(request) != null;
    }

    static void savephoto(HttpServletRequest request, String name) {
        try {
            Part filebutton = request.getPart("filebutton");
            String filename = request.getServletContext().getRealPath("/image/" + name);
            try (InputStream inputStream = filebutton.getInputStream();
                 OutputStream outputStream = new FileOutputStream(filename)) {
                byte[] buffer = new byte[100000];
                while (inputStream.available() > 0) {
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count);
                }
            }
        }
        catch (IOException|ServletException e){

        }
    }

}
