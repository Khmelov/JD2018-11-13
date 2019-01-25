package by.it.vchernetski.jd03_02.crud;

import by.it.vchernetski.jd03_02.beans.Car;
import by.it.vchernetski.jd03_02.beans.Garage;
import by.it.vchernetski.jd03_02.beans.Role;
import by.it.vchernetski.jd03_02.beans.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String in;
        System.out.println("press 1 for check CRUD of User\n" +
                "press 2 for check CRUD of Role\n" +
                "press 3 for check CRUD of Garag\n" +
                "press 4 for check CRUD of Car\n"+
                "type \"end\" for exit");
        while (!((in = sc.nextLine()).equals("end"))) {
            int i = Integer.parseInt(in);
            switch (i) {
                case 1:
                    checkCRUDUser();
                    break;
                case 2:
                    chekCRUDRole();
                    break;
                case 3:
                    checkCRUDGarage();
                    break;
                case 4:
                    chekCRUDCar();
                    break;
                default:
                    continue;
            }
        }
    }

    private static void chekCRUDCar() throws SQLException {
        Car car = new Car();
        car.setColor("CCCCCCC");
        car.setGarages_id(1);
        car.setModel("MMMMMMMMMMMMMM");
        car.setYear(2000);
        CarCRUD carCrud = new CarCRUD();
        if (carCrud.create(car)) {
            System.out.println("create: " + car);
        }
        car.setYear(2019);
        if (carCrud.update(car)) {
            System.out.println("update: " + car);
        }
        car = carCrud.read(car.getId());
        System.out.println("read: " + car);
        if (carCrud.delete(car)) {
            System.out.println("delete: " + car);
        }
    }

    private static void checkCRUDGarage() throws SQLException {
        Garage garage = new Garage();
        garage.setAdress("minsk");
        garage.setCarplaces(2);
        garage.setUsers_id(2);
        GarageCRUD garageCRUD = new GarageCRUD();
        if (garageCRUD.create(garage)) System.out.println("create: " + garage);
        garage.setAdress("MMMMMMMM");
        if (garageCRUD.update(garage)) System.out.println("update: " + garage);
        garage = garageCRUD.read(garage.getId());
        System.out.println("read: " + garage);
        if (garageCRUD.delete(garage)) {
            System.out.println("delete: " + garage);
        }
    }

    private static void chekCRUDRole() throws SQLException {
        Role role = new Role();
        role.setRole("rrrrrr");
        RoleCRUD roleCRUD = new RoleCRUD();
        if (roleCRUD.create(role)) {
            System.out.println("create: " + role);
        }
        role.setRole("RRRRR");
        if (roleCRUD.update(role)) {
            System.out.println("update: " + role);
        }
        role = roleCRUD.read(role.getId());
        System.out.println("read: " + role);
        if (roleCRUD.delete(role)) {
            System.out.println("delete: " + role);
        }
    }

    private static void checkCRUDUser() throws SQLException {
        User user = new User();
        user.setEmail("EEEEE");
        user.setFio("FFFFFFF");
        user.setNickname("NNNN");
        user.setNumbergarages(2);
        user.setPassword("PPPPPPPPP");
        user.setRoles_id(1);
        UserCRUD crud = new UserCRUD();
        if (crud.create(user)) {
            System.out.println("create: " + user);
        }
        user.setFio("ffffffff");
        if (crud.update(user)) {
            System.out.println("update: " + user);
        }
        user = crud.read(user.getId());
        System.out.println("read: " + user);
        if (crud.delete(user)) {
            System.out.println("delete: " + user);
        }
    }
}
