package by.it.markelov.project.java.dao;

public class DAO {

    private static DAO instance;

    public RoleDAO role;
    public UserDAO user;
    public OrderDAO order;
    public ShoeNameDAO shoeName;
    public ShoeSizeDAO shoeSize;
    public ShoeColourDAO shoeColour;



    private DAO() {
    }

    public static DAO getInstance (){
        if (instance ==null){
            synchronized (DAO.class) {
                if (instance ==null) {
                    instance =new DAO();

                    instance.role=new RoleDAO();
                    instance.user=new UserDAO();
                    instance.order=new OrderDAO();
                    instance.shoeName=new ShoeNameDAO();
                    instance.shoeSize=new ShoeSizeDAO();
                    instance.shoeColour=new ShoeColourDAO();
                }
            }
        }
        return instance;
    }
}
