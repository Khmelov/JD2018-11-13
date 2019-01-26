package by.it.nickgrudnitsky.jd03_03;

import by.it.nickgrudnitsky.jd03_03.beans.Role;
import by.it.nickgrudnitsky.jd03_03.beans.Streamer;
import by.it.nickgrudnitsky.jd03_03.beans.Viewer;
import by.it.nickgrudnitsky.jd03_03.dao.MyDao;


import java.sql.SQLException;

public class TaskC {
    public static void main(String[] args) throws SQLException {
        MyDao myDao = MyDao.getDao();

        Viewer viewer = new Viewer();
        viewer.setEmail("test");
        viewer.setPassword("test");
        viewer.setNickname("test");
        viewer.setRoles_id(2);

        if(myDao.viewer.create(viewer)){
            System.out.println("Create " + viewer);
        }

        Viewer viewer1 = myDao.viewer.read(2);
        System.out.println("Read " + viewer1);

        viewer1.setNickname("test2");
        if(myDao.viewer.update(viewer1)){
            System.out.println("Update " + viewer1);
        }

        if (myDao.viewer.delete(viewer)){
            System.out.println("Delete " + viewer);
        }

        Streamer streamer = new Streamer();

        streamer.setEmail("test");
        streamer.setPassword("test");
        streamer.setChannelname("test");
        streamer.setRoles_id(2);

        if(myDao.streamer.create(streamer)){
            System.out.println("Create " + streamer);
        }

        streamer.setChannelname("test2");
        if(myDao.streamer.update(streamer)){
            System.out.println("Update " + streamer);
        }
        Streamer streamer1 = myDao.streamer.read(streamer.getId());
        System.out.println("Read " + streamer1);
        if (myDao.streamer.delete(streamer)){
            System.out.println("Delete " + streamer);
        }

        Role role = new Role();

        role.setRole("Test");

        if(myDao.role.create(role)){
            System.out.println("Create " + role);
        }

        role.setRole("test2");
        if(myDao.role.update(role)){
            System.out.println("Update " + role);
        }
        Role role1 = myDao.role.read(role.getId());
        System.out.println("Read " + role1);
        if (myDao.role.delete(role)){
            System.out.println("Delete " + role);
        }
    }
}
