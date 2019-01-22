package by.it.zhivov.jd03_03;

import by.it.zhivov.jd03_03.beans.Ad;
import by.it.zhivov.jd03_03.beans.Role;
import by.it.zhivov.jd03_03.beans.User;

public class Dao {
    private static volatile Dao dao;

    InterfaceDao<User> user;
    InterfaceDao<Role> role;
    InterfaceDao<Ad> ad;


    private Dao() {
//        role = new UniversalDAO<>(new Role(),"roles");
//        role = new UniversalDAO<>(new User(),"user");
//        role = new UniversalDAO<>(new Ad(),"ad");
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
