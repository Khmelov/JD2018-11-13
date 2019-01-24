package by.it._examples_.jd03_03.badpath;

public class DAO {

    private static DAO dao;

    UniversalDAO<User> user;
    UniversalDAO<Role> role;
    UniversalDAO<Ad> ad;

    private DAO() {
        role=new UniversalDAO<>(new Role(),"roles");
        user=new UniversalDAO<>(new User(),"users");
        ad=new UniversalDAO<>(new Ad(),"ads");
    }

    public static DAO getDAO(){
        if (dao==null)
            dao=new DAO();
        return dao;
    }

}
