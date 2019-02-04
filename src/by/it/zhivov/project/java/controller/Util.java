package by.it.zhivov.project.java.controller;

import by.it.zhivov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;


public class Util {
    static boolean checkUser(HttpServletRequest req) {
        return findUser(req) != null;
    }

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object objUser = session.getAttribute("user");
            if (objUser != null) {
                return (User) objUser;
            }
        }
        return null;
    }

    static boolean isAdmin(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        User user = Util.findUser(req);
        if (user != null) {
            return user.getRoles_Id() == 1;
        }
        return false;
    }

    public static void sendTg(String brnd, String model, int year, double price) throws IOException {
        String url = String.format("https://api.telegram.org/bot727115180:AAHUY8LHssKtuiuN4e0Mice9f4u7S3sS_gM/sendMessage?chat_id=433820982&parse_mode=html&text=%s %s %dг. %dруб.",
                brnd, model, year, (int) price);

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while (( inputLine = in.readLine() ) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
//        Desktop d = Desktop.getDesktop();
//
//        d.browse(new URI(
//                String.format(
//    "https://api.telegram.org/bot682142809:AAHCbD525IioM1g6Mi6wCNhrCca-eitkbAA/sendMessage?chat_id=433820982&parse_mode=html&text=www")));


    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        sendTg("bb", "mm", 25, 600);

    }
}
