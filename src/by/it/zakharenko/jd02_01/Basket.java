package by.it.zakharenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public int id;
    private static int counter = 0;

    public List<Good> goods = new ArrayList<>();

    public Basket() {
        this.id = counter;
        counter++;
    }
}