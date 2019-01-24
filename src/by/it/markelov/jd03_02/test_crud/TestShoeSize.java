package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.ShoeSize;
import by.it.markelov.jd03_02.crud.ShoeSizeCRUD;

import java.sql.SQLException;

public class TestShoeSize {
    public static void main(String[] args) {
        ShoeSizeCRUD shoeSizeCRUD = new ShoeSizeCRUD();
        ShoeSize shoeSize = new ShoeSize(0, 45, 1);
        try {
//==================CREATE=========================
            shoeSizeCRUD.create(shoeSize);

//==================READ===========================
            //System.out.println(shoeSizeCRUD.read(3));

//===================UPDATE========================
            //shoeSize = new ShoeSize(5, 29,1);
            //shoeSizeCRUD.update(shoeSize);

//===================DELETE========================
            //shoeSizeCRUD.delete(shoeSize);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
