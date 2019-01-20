package by.it.seroglazov.jd03_02;

import by.it.seroglazov.jd03_02.beans.Ingredient;
import by.it.seroglazov.jd03_02.beans.Itag;
import by.it.seroglazov.jd03_02.crud.DatabaseCRUD;
import by.it.seroglazov.jd03_02.crud.ItagCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Создаю БД...");
        if (!DatabaseCRUD.createDatabase()) {
            System.out.println("БД не создана.");
        }
        System.out.println("БД успешно создана.");

        // Заполняем

        Itag alcoholic_beverage = new Itag("alcoholic beverage");
        Itag non_alcoholic_beverage = new Itag("non-alcoholic beverage");
        Itag liqueur = new Itag("liqueur");
        Itag whisky = new Itag("whisky");
        Itag bitter = new Itag("bitter");
        Itag citrus = new Itag("citrus");

        ItagCRUD itagCRUD = new ItagCRUD();
        itagCRUD.create(alcoholic_beverage);
        itagCRUD.create(non_alcoholic_beverage);
        itagCRUD.create(liqueur);
        itagCRUD.create(whisky);
        itagCRUD.create(bitter);
        itagCRUD.create(citrus);

        Ingredient gin = new Ingredient("gin", alcoholic_beverage);
        Ingredient white_rum = new Ingredient("white rum", alcoholic_beverage);
        Ingredient vodka = new Ingredient("vodka", alcoholic_beverage);
        Ingredient triple_sec = new Ingredient("triple sec", alcoholic_beverage, liqueur);
        Ingredient fresh_lemon_juice = new Ingredient("fresh lemon juice", citrus);
        Ingredient bourbon_whiskey = new Ingredient("bourbon whiskey", alcoholic_beverage, whisky);
        Ingredient plain_water = new Ingredient("plain water", non_alcoholic_beverage);
        Ingredient angostura_aromatic_bitters = new Ingredient("angostura aromatic bitters", alcoholic_beverage, bitter);
        Ingredient sugar = new Ingredient("sugar");

    }
}
