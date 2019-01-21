package by.it._examples_.jd03_03;

import by.it._examples_.jd03_03.beans.Ad;
import by.it._examples_.jd03_03.custom_dao.DAO;

import java.sql.SQLException;

public class V3_DemoWithAD {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getDAO();
        Ad ad=new Ad(0,3,50000,60,1,2,"Скрыганова","Super",2);
        System.out.println("All-------------------------");
        System.out.println(dao.ad.getAll(""));

        dao.ad.create(ad);
        System.out.println("-------- Create ------------");
        System.out.println(dao.ad.getAll(""));

        ad.setAddress("!!!!");
        dao.ad.update(ad);
        System.out.println("-------- Update ------------");
        System.out.println(dao.ad.getAll(""));

        dao.ad.delete(ad);
        System.out.println("-------- Delete ------------");
        System.out.println(dao.ad.getAll(""));

    }
}
