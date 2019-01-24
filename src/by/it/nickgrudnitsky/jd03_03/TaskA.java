package by.it.nickgrudnitsky.jd03_03;

import by.it.nickgrudnitsky.jd03_03.beans.Role;
import by.it.nickgrudnitsky.jd03_03.beans.Streamer;
import by.it.nickgrudnitsky.jd03_03.beans.Viewer;
import by.it.nickgrudnitsky.jd03_03.dao.Dao;

import java.sql.SQLException;

public class TaskA {
    public static void main(String[] args) throws SQLException {

        Dao dao = Dao.getDao();

        Viewer viewer = new Viewer();
        viewer.setEmail("test");
        viewer.setPassword("test");
        viewer.setNickname("test");
        viewer.setRoles_id(2);

        if(dao.viewer.create(viewer)){
            System.out.println("Create " + viewer);
        }

        viewer.setNickname("test2");
        if(dao.viewer.update(viewer)){
            System.out.println("Update " + viewer);
        }
        Viewer viewer1 = dao.viewer.read(viewer.getId());
        System.out.println("Read " + viewer1);
        if (dao.viewer.delete(viewer)){
            System.out.println("Delete " + viewer);
        }


        Streamer streamer = new Streamer();

        streamer.setEmail("test");
        streamer.setPassword("test");
        streamer.setChannelname("test");
        streamer.setRoles_id(2);

        if(dao.streamer.create(streamer)){
            System.out.println("Create " + streamer);
        }

        streamer.setChannelname("test2");
        if(dao.streamer.update(streamer)){
            System.out.println("Update " + streamer);
        }
        Streamer streamer1 = dao.streamer.read(streamer.getId());
        System.out.println("Read " + streamer1);
        if (dao.streamer.delete(streamer)){
            System.out.println("Delete " + streamer);
        }

        Role role = new Role();

        role.setRole("Test");

        if(dao.role.create(role)){
            System.out.println("Create " + role);
        }

        role.setRole("test2");
        if(dao.role.update(role)){
            System.out.println("Update " + role);
        }
        Role role1 = dao.role.read(role.getId());
        System.out.println("Read " + role1);
        if (dao.role.delete(role)){
            System.out.println("Delete " + role);
        }
    }

}
