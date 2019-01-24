package by.it.nickgrudnitsky.jd03_03.dao;

import by.it.nickgrudnitsky.jd03_03.beans.Role;
import by.it.nickgrudnitsky.jd03_03.beans.Streamer;
import by.it.nickgrudnitsky.jd03_03.beans.Viewer;

public class Dao {

    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<Viewer> viewer;
    public InterfaceDao<Streamer> streamer;


    private Dao() {
        role = new UniversalDAO<>(new Role(), "roles");
        viewer = new UniversalDAO<>(new Viewer(), "viewers");
        streamer = new UniversalDAO<>(new Streamer(), "streamers");
    }

    public static Dao getDao() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }
}
