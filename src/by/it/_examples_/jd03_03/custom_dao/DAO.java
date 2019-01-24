package by.it._examples_.jd03_03.custom_dao;

public class DAO {

    private static DAO dao; //синглтон для dao

    public UserDAO user;    //dao для пользователей
    public RoleDAO role;    //dao для ролей
    public AdDAO ad;        //dao для объявлений
    //...

    public static DAO getDAO() {   //метод, который создает dao или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.ad = new AdDAO();
                    //новые куски dao добавляются аналогично при расширении dao
                    //dao.ad = new AdDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
