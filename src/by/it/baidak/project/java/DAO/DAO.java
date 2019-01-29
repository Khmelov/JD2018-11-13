package by.it.baidak.project.java.DAO;

public class DAO {

    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public PostDAO post;

    public static DAO getDAO(){
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.post = new PostDAO();
                }
            }
        }
        return dao;
    }
}
