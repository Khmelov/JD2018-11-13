package by.it.berdnik.jd02_02;

import java.util.LinkedList;

public class Backet {

    private LinkedList<String> product;

    public Backet() {
        product = new LinkedList<>();
    }

    public void putGoodsToBacket(String name) {
        product.add(name);
    }

}
