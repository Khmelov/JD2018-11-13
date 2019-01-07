package by.it.denisova.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public int id;
    private static int counter = 0;

    public List<good> goods = new ArrayList<>();

    public Basket() {
        this.id = counter;
        counter++;
    }
}
