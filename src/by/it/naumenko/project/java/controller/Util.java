package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Users;
import by.it.naumenko.project.java.dao.MyDAO;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class Util {

    static void createCookie(HttpServletResponse response, String login, String password) throws LoginException, NoSuchAlgorithmException {
        Cookie cookieLogin = new Cookie("login",login);
        Cookie cookiePassword = new Cookie("password",Util.hashMD5(password));
        cookieLogin.setMaxAge(60*60*24*30);
        cookiePassword.setMaxAge(60*60*24*30);
        response.addCookie(cookieLogin);
        response.addCookie(cookiePassword);
    }

    static void deleteCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie cookieLogin = new Cookie("login","");
        Cookie cookiePassword = new Cookie("password","");

        cookieLogin.setMaxAge(20);
        cookiePassword.setMaxAge(20);
        response.addCookie(cookieLogin);
        response.addCookie(cookiePassword);
        request.getSession().invalidate();
    }


    static Boolean checkCookie(HttpServletRequest req) throws SQLException {
        Cookie[] cookies = req.getCookies();
        String userCookie = "login";
        String passwordCookie = "password";
        Cookie cookie = null;
        String pasw = "";
        String log = "";
        boolean UC = false;
        boolean PC = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (userCookie.equals(c.getName())) {
                    cookie = c;
                    log = cookie.getValue();
                    UC = true;
                    //System.out.printf("кука %s найдена value=%s", userCookie, cookie.getValue());
                }
            }
        }

        cookie = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (passwordCookie.equals(c.getName())) {
                    cookie = c;
                    pasw = cookie.getValue();
                    PC = true;
                    //System.out.printf("кука %s найдена value=%s", passwordCookie, cookie.getValue());
                }
            }
        }
        if (UC && PC) {
            String where = String.format(" WHERE hashpas = '%s' and login='%s' LIMIT 0,1", pasw, log);
            MyDAO<Users> myDAO = new MyDAO<>(new Users(), "users");
            List<Users> users = myDAO.getAll(where);
            System.out.println(where);
            if (users.size() == 1) {
                Users user = users.get(0);
                req.getSession().setAttribute("user", user);

                return true;
            }
        }
        return false;
    }


    static String hashMD5(String str) throws LoginException, NoSuchAlgorithmException {
        String salt = "java";
        char[] saltC = salt.toCharArray();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        StringBuilder rezulrtString = new StringBuilder();
        for (int i = 0; i < salt.length(); i++) {
            rezulrtString.append(str).append(saltC[i]);
        }
        System.out.println(rezulrtString.toString());
        byte[] bytes = md5.digest(rezulrtString.toString().getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(String.format("%02x", aByte));
        }
        return stringBuilder.toString();
    }

    static boolean checkUser(HttpServletRequest req) {
        return (findUser(req) != null);
    }

    static Users findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Users) oUser;
            }
        }
        return null;
    }
}
