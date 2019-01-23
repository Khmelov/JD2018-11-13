package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.ShoeName;
import by.it.markelov.jd03_02.crud.ShoeNameCRUD;

import java.sql.SQLException;

public class TestShoeName {
    public static void main(String[] args) {
        ShoeNameCRUD shoeNameCRUD = new ShoeNameCRUD();
        ShoeName shoeName = new ShoeName(0, "SNTest", 1);
        try {
//==================CREATE=========================
            shoeNameCRUD.create(shoeName);

//==================READ===========================
            //System.out.println(shoeNameCRUD.read(5));

//===================UPDATE========================
            //shoeName = new ShoeName(5, "SNTest+++",1);
            //shoeNameCRUD.update(shoeName);

//===================DELETE========================
            //shoeNameCRUD.delete(shoeName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
