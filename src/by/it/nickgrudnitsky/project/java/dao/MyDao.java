package by.it.nickgrudnitsky.project.java.dao;

import by.it.nickgrudnitsky.project.java.beans.Role;
import by.it.nickgrudnitsky.project.java.beans.Streamer;
import by.it.nickgrudnitsky.project.java.beans.Viewer;


public class MyDao {
    private static volatile MyDao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<Viewer> viewer;
    public InterfaceDao<Streamer> streamer;


    private MyDao() {
        role = new MyUniversalDAO<>(new Role());
        viewer = new MyUniversalDAO<>(new Viewer());
        streamer = new MyUniversalDAO<>(new Streamer());
    }

    public static MyDao getDao() {
        if (dao == null) {
            synchronized (MyDao.class) {
                if (dao == null) {
                    dao = new MyDao();
                }
            }
        }
        return dao;
    }
}
