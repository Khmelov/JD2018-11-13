package by.it._examples_.jd03_02.demo;

import by.it._examples_.jd03_02.demo.beans.Ad;
import by.it._examples_.jd03_02.demo.crud.AdCRUD;

import java.sql.SQLException;

public class AdTest {
    public static void main(String[] args) {
        Ad ad=new Ad(0,"Good room","Gikalo 11",2,5,45.5,55000,2,2);
        AdCRUD adCRUD=new AdCRUD();
        try {
            adCRUD.create(ad);
            System.out.println(ad);
            ad=adCRUD.read(ad.getId());
            System.out.println(ad);
            ad.setAddress("Gik 1");
            adCRUD.update(ad);
            System.out.println(ad);
            adCRUD.delete(ad);
            System.out.println(ad);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
