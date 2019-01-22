//package by.it.mnovikov.jd03_03.dao;
//
//import by.it.mnovikov.jd03_03.beans.Role;
//import by.it.mnovikov.jd03_03.beans.User;
//
///**
// * Created by user on 22.01.2019.
// */
//public class Dao {
//
//    private static volatile Dao dao;
//
//    Interface_DAO<Role> role;
//    Interface_DAO<User> user;
////    Interface_DAO<Ad> ad;
//
//    private Dao() {
//    }
//
//    private Dao(Role role, User user){
//        role = new UniversalDAO<>(new Role(),"roles");
//        user = new UniversalDAO<>(new User(), "users");
//    }
//
//
//    public static Dao getDao(){
//        if (dao == null) {
//            synchronized (Dao.class) {
//                if (dao == null){
//                    dao = new Dao();
//                }
//            }
//        }
//        return dao;
//    }
//}
