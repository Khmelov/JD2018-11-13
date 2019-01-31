package by.it.naumenko.project.java.controller;

import by.it.naumenko.project.java.beens.Users;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

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
