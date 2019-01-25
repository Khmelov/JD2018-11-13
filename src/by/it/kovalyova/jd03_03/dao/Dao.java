package by.it.kovalyova.jd03_03.dao;

import by.it.kovalyova.jd03_03.beans.Ad;
import by.it.kovalyova.jd03_03.beans.Role;
import by.it.kovalyova.jd03_03.beans.User;

public class Dao {
    private static volatile Dao dao;

    public InterfaceDao<Role> role;
    public InterfaceDao<User> user;
    public InterfaceDao<Ad> ad;

    public void reset(){
        Connect.reset();
    }
    private Dao() {
        role=new UniversalDAO<>(new Role(), "roles");
        user=new UniversalDAO<>(new User(), "users");
        ad=new UniversalDAO<>(new Ad(), "ads");


    }

    public static Dao getDao(){
        if (dao==null) {
            synchronized (Dao.class){
                if (dao==null) {
                    dao=new Dao();
                }
            }
        }
        return dao;
    }
}
