package by.it.skarpovich.jd03_02.crud;

import by.it.skarpovich.jd03_02.beans.Item;
import by.it.skarpovich.jd03_02.beans.Order;
import by.it.skarpovich.jd03_02.beans.Role;
import by.it.skarpovich.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User user = new User();
        user.setUsername("agl");
        user.setPassword("john");
        user.setEmail("agl@tut.by");
        user.setFullname("Sasha");
        user.setPhone("1111111");
        user.setAddress("Drozdy 111");
        user.setRoles_id(2);

        if (userCRUD.create(user))
            System.out.println("USER PROFILE CREATED: " + user);
        user.setUsername("kolya");

        if (userCRUD.update(user))
            System.out.println("Username has been updated to: " + user);
        user = userCRUD.read(user.getId());
        System.out.println("USER PROFILE: " + user);

//        if (userCRUD.delete(user))
//            System.out.println("USER PROFILE DELETED: " + user);

// ItemCRUD
        ItemCRUD itemCRUD = new ItemCRUD();
        Item item = new Item();
        item.setTitle("Zx214");
        item.setFloors(2);
        item.setSquare(200);
        item.setMaterials("brick");
        item.setPrice(125);
        if (itemCRUD.create(item))
            System.out.println("ITEM CREATED: " + item);
                                // set new title (or any other field)
        item.setTitle("Zx215");
        if (itemCRUD.update(item))
            System.out.println("Username has been updated to: " + item);

        item = itemCRUD.read(item.getId());
        System.out.println("USER PROFILE: " + item);

//        if (itemCRUD.delete(item))
//            System.out.println("ITEM DELETED: " + item);

        // OrderCRUD
        OrderCRUD orderCRUD = new OrderCRUD();
        Order order = new Order();
        order.setDate("2019-01-20");
        order.setTime("11:22:23");
        order.setUsers_id(2);
        order.setItems_id(2);
        if (orderCRUD.create(order))
            System.out.println("ORDER CREATED: " + order);

        order.setDate("2019-01-21");
        if (orderCRUD.update(order))
            System.out.println("ORDER has been updated to: " + order);
                                    // print order
        order = orderCRUD.read(order.getId());
        System.out.println("ORDER DETAILS: " + order);
//        if (orderCRUD.delete(order))
//            System.out.println("ORDER DELETED: " + order);

        // RoleCRUD
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role();
        role.setRole("Blocked");
        if (roleCRUD .create(role))
            System.out.println("ROLE CREATED: " + role);
                                // update role
        role.setRole("Moderators");
        if (roleCRUD.update(role))
            System.out.println("ROLE has been updated to: " + role);
                                // print role
        role = roleCRUD.read(role.getId());
        System.out.println("ROLE DETAILS: " + role);
                                // delete role
//        if (roleCRUD.delete(role))
//            System.out.println("ROLE DELETED: " + role);

    }
}
