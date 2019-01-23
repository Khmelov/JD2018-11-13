package by.it.berdnik.jd03_02.crud;

import by.it.berdnik.jd03_02.beans.Buyer;
import by.it.berdnik.jd03_02.beans.Role;
import by.it.berdnik.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {


        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role();
        role.setRole("UUUUUU");
        if (roleCRUD.create(role))
            System.out.println("CREATE: " + role);

        role = roleCRUD.read(role.getId());
        System.out.println("READ: " + role);

        role.setRole("UUUUUU222");
        if (roleCRUD.update(role))
            System.out.println("UPDATE: " + role);

        if (roleCRUD.delete(role))
            System.out.println("DELETE: " + role);



        UserCRUD userCRUD = new UserCRUD();
        User user = new User();
        user.setNickname("LLLLLL");
        user.setPassword("PPPPPP");
        user.setEmail("EEEEEE");
        user.setRoles_Id(2);
        if (userCRUD.create(user))
            System.out.println("CREATE: " + user);

        user = userCRUD.read(user.getId());
        System.out.println("READ: " + user);

        user.setNickname("LLLL22222222");
        if (userCRUD.update(user))
            System.out.println("UPDATE: " + user);

        if (userCRUD.delete(user))
            System.out.println("DELETE: " + user);



        BuyerCRUD buyerCRUD = new BuyerCRUD();
        Buyer buyer = new Buyer();
        buyer.setItem("IIIIIII");
        buyer.setSpecif("SSSSSSS");
        buyer.setPrice(1234);
        buyer.setAddress("STREET");
        buyer.setUsers_Id(2);
        if (buyerCRUD.create(buyer))
            System.out.println("CREATE: " + buyer);

                buyer = buyerCRUD.read(buyer.getId());
        System.out.println("READ: " + buyer);

        if (buyerCRUD.update(buyer))
            System.out.println("UPDATE: " + buyer);

        if (buyerCRUD.delete(buyer))
            System.out.println("DELETE: " + buyer);
    }
}
