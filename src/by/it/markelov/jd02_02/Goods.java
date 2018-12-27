package by.it.markelov.jd02_02;

import java.util.HashMap;

public class Goods {
    public static HashMap<String, Integer> pricelist=new HashMap<>();

    public static void fillPricelist () {
        pricelist.put("Хлеб", 1);
        pricelist.put("Масло", 3);
        pricelist.put("Молоко", 2);
        pricelist.put("Сыр", 4);
        pricelist.put("Сок", 2);
        pricelist.put("Батон", 1);
        pricelist.put("Вода", 2);
        pricelist.put("Сметана", 3);
    }
}
