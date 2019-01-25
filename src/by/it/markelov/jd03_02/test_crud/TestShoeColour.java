package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.ShoeColour;
import by.it.markelov.jd03_02.crud.ShoeColourCRUD;

import java.sql.SQLException;

public class TestShoeColour {
    public static void main(String[] args) {
        ShoeColourCRUD shoeColourCRUD = new ShoeColourCRUD();
        ShoeColour shoeColour = new ShoeColour(0, "SCTest", 2);
        try {
//==================CREATE=========================
            shoeColourCRUD.create(shoeColour);

//==================READ===========================
            System.out.println(shoeColourCRUD.read(3));

//===================UPDATE========================
            shoeColour = new ShoeColour(6, "SCTest+++", 2);
            shoeColourCRUD.update(shoeColour);

//===================DELETE========================
            shoeColourCRUD.delete(shoeColour);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
