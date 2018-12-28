package by.it.markelov.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {
    HashMap<String, Integer> basket = new HashMap<>();

    int total = 0;

    public void basketContent() {
        Set<Map.Entry<String, Integer>> entries = basket.entrySet();
        System.out.println("Чек:");
        for (Map.Entry<String, Integer> entry : entries) {
            String product = entry.getKey();
            Integer price = entry.getValue();
            total += price;
            System.out.println("    " + product + " " + price);
        }
        System.out.println("Итого: " + total);
    }
}
