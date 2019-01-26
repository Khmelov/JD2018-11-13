package by.it.vchernetski.jd03_03;



import by.it.vchernetski.jd03_02.beans.Car;
import by.it.vchernetski.jd03_03.beans.User;
import by.it.vchernetski.jd03_03.beans.Role;
import by.it.vchernetski.jd03_03.beans.Garage;
import by.it.vchernetski.jd03_03.dao.Connect;
import by.it.vchernetski.jd03_03.dao.MyDAO;

import java.util.List;


public class Runner {
    public static void main(String[] args) throws Exception {
        Connect.resetSCHEMA();
        Garage garage = new Garage();
        garage.setAdress("minsk");
        garage.setCarplaces(2);
        garage.setUsers_id(2);
        MyDAO<Garage> daoGarage = MyDAO.getDao(garage);
        if(daoGarage.create()) System.out.println("create: "+ garage);
        garage.setAdress("MMMMMMMMMMM");
        if(daoGarage.update()) System.out.println("update: "+garage);
        garage = (Garage) daoGarage.read(garage.getId());
        System.out.println("read: "+garage);
        if(daoGarage.delete()) System.out.println("delete: "+garage);

        Role role = new Role();
        role.setRole("rrrrrr");
        MyDAO<Role> daoRole = MyDAO.getDao(role);
        if(daoRole.create()) System.out.println("create: "+ role);
        role.setRole("MMMMMMMMMMM");
        if(daoRole.update()) System.out.println("update: "+role);
        role = (Role) daoRole.read(role.getId());
        System.out.println("read: "+role);
        if(daoRole.delete()) System.out.println("delete: "+role);

        User user = new User();
        user.setEmail("EEEEE");
        user.setFio("FFFFFFF");
        user.setNickname("NNNN");
        user.setNumbergarages(2);
        user.setPassword("PPPPPPPPP");
        user.setRoles_id(1);
        MyDAO<User> daoUser = MyDAO.getDao(user);
        if(daoUser.create()) System.out.println("create: "+ user);
        user.setEmail("MMMMMMMMMMM");
        if(daoUser.update()) System.out.println("update: "+user);
        user = (User) daoUser.read(user.getId());
        System.out.println("read: "+user);
        if(daoUser.delete()) System.out.println("delete: "+user);

        Car car = new Car();
        car.setColor("CCCCCCC");
        car.setGarages_id(1);
        car.setModel("MMMMMMMMMMMMMM");
        car.setYear(2000);
        MyDAO<Car> daoCar = MyDAO.getDao(car);
        if(daoCar.create()) System.out.println("create: "+ car);
        car.setColor("MMMMMMMMMMM");
        if(daoCar.update()) System.out.println("update: "+car);
        car =  daoCar.read(car.getId());
        System.out.println("read: "+car);
        if(daoCar.delete()) System.out.println("delete: "+car);
//        Connect.getUsersWithRoles();
    }
}
