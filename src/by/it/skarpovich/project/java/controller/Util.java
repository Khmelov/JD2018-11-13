package by.it.skarpovich.project.java.controller;

import by.it.skarpovich.project.java.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objectUser = session.getAttribute("user");
            if (objectUser != null) {
                return (User) objectUser;
            }
        }
        return null;
    }

    static void saveFile(HttpServletRequest req, String fn) {
        try {
        Part part = req.getPart("filebutton");
        String fnout = req.getServletContext().getRealPath("/image/" + fn);

        try (InputStream input = part.getInputStream();
             OutputStream out = new FileOutputStream(fnout)
        ) {
            byte[] buffer = new byte[100000];
            while (input.available() > 0) {
                int count = input.read(buffer);
                out.write(buffer, 0, count);
            }
        }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}

