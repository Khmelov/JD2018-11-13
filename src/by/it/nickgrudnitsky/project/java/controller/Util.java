package by.it.nickgrudnitsky.project.java.controller;


import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;

public class Util {

    static boolean checkViewer(HttpServletRequest req) {
        return findViewer(req) != null;
    }

    private static Viewer findViewer(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Viewer) oUser;
            }
        }

        /*if (req.getSession(false) == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                String password = "";
                String nickname = "";
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                    if (cookie.getName().equals("nickname")) {
                        nickname = cookie.getValue();
                    }
                }
                if (password.length() > 0 && nickname.length() > 0) {
                    String where = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", password, nickname);
                    MyDao dao = MyDao.getDao();
                    List<Viewer> viewers = null;
                    try {
                        viewers = dao.viewer.getAll(where);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (viewers.size() == 1) {
                        Viewer viewer = viewers.get(0);
                        String decodePassword = Util.deCode(viewer.getPassword());
                        viewer.setPassword(decodePassword);
                        req.getSession().setAttribute("user", viewer);
                        return viewer;
                    }
                }
            }
        }*/
        return null;
    }

    static boolean checkStreamer(HttpServletRequest req) {
        return findStreamer(req) != null;
    }

    private static Streamer findStreamer(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object oUser = session.getAttribute("user");
            if (oUser != null) {
                return (Streamer) oUser;
            }
        }

        /*if (req.getSession(false) == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                String password = "";
                String nickname = "";

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("password")) {
                        password = cookie.getValue();
                    }
                    if (cookie.getName().equals("nickname")) {
                        nickname = cookie.getValue();
                    }
                }
                if (password.length() > 0 && nickname.length() > 0) {
                    String where = String.format(" WHERE password='%s' and nickname='%s' LIMIT 0,1", password, nickname);
                    MyDao dao = MyDao.getDao();
                    List<Streamer> streamers = null;
                    try {
                        streamers = dao.streamer.getAll(where);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (streamers.size() == 1) {
                        Streamer streamer = streamers.get(0);
                        String decodePassword = Util.deCode(streamer.getPassword());
                        streamer.setPassword(decodePassword);
                        req.getSession().setAttribute("user", streamer);
                        return streamer;
                    }
                }
            }
        }*/
        return null;
    }


    static String enCode(String value) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(value.getBytes());
        return new String(encode);
    }

    public static String deCode(String value) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(value.getBytes());
        return new String(decode);
    }

}
