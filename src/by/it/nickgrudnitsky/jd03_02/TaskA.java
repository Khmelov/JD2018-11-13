package by.it.nickgrudnitsky.jd03_02;

import by.it.nickgrudnitsky.jd03_02.CRUD.RoleCRUD;
import by.it.nickgrudnitsky.jd03_02.CRUD.StreamerCRUD;
import by.it.nickgrudnitsky.jd03_02.CRUD.ViewerCRUD;
import by.it.nickgrudnitsky.jd03_02.beans.Role;
import by.it.nickgrudnitsky.jd03_02.beans.Streamer;
import by.it.nickgrudnitsky.jd03_02.beans.Viewer;

import java.sql.SQLException;

public class TaskA {
    public static void main(String[] args) throws SQLException {
        Viewer viewer = new Viewer();
        ViewerCRUD viewerCRUD = new ViewerCRUD();
        viewer.setEmail("test");
        viewer.setPassword("test");
        viewer.setNickname("test");
        viewer.setRoles_id(2);

        if(viewerCRUD.create(viewer)){
            System.out.println("Create " + viewer);
        }

        viewer.setNickname("test2");
        if(viewerCRUD.update(viewer)){
            System.out.println("Update " + viewer);
        }
        Viewer viewer1 = viewerCRUD.read(viewer.getId());
        System.out.println("Read " + viewer1);
        if (viewerCRUD.delete(viewer)){
            System.out.println("Delete " + viewer);
        }


        Streamer streamer = new Streamer();
        StreamerCRUD streamerCRUD = new StreamerCRUD();
        streamer.setEmail("test");
        streamer.setPassword("test");
        streamer.setChannelname("test");
        streamer.setRoles_id(2);

        if(streamerCRUD.create(streamer)){
            System.out.println("Create " + streamer);
        }

        streamer.setChannelname("test2");
        if(streamerCRUD.update(streamer)){
            System.out.println("Update " + streamer);
        }
        Streamer streamer1 = streamerCRUD.read(streamer.getId());
        System.out.println("Read " + streamer1);
        if (streamerCRUD.delete(streamer)){
            System.out.println("Delete " + streamer);
        }

        Role role = new Role();
        RoleCRUD roleCRUD = new RoleCRUD();
        role.setRole("Test");

        if(roleCRUD.create(role)){
            System.out.println("Create " + role);
        }

        role.setRole("test2");
        if(roleCRUD.update(role)){
            System.out.println("Update " + role);
        }
        Role role1 = roleCRUD.read(role.getId());
        System.out.println("Read " + role1);
        if (roleCRUD.delete(role)){
            System.out.println("Delete " + role);
        }
    }
}
