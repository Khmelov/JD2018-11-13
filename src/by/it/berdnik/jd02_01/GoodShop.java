package by.it.berdnik.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class GoodShop {

    static Map<String, Double> product = new HashMap<>();

    public static void products() {
        product.put("Product 1", 1.1);
        product.put("Product 2", 2.2);
        product.put("Product 3", 3.13);
        product.put("Product 4", 4.4);
        product.put("Product 5", 15.1);
        product.put("Product 6", 1.16);
        product.put("Product 7", 1.71);
        product.put("Product 8", 18.1);
        product.put("Product 9", 19.1);
        product.put("Product 10", 10.1);
        product.put("Product 11", 11.11);
        product.put("Product 12", 12.1);
        product.put("Product 13", 13.1);
        product.put("Product 14", 14.1);
        product.put("Product 15", 1.51);
        product.put("Product 16", 16.1);
        product.put("Product 17", 17.1);
        product.put("Product 18", 1.81);
        product.put("Product 19", 19.1);
        product.put("Product 20", 20.1);
        product.put("Product 21", 21.1);
    }

    static void getPosition(HashMap map, int position) {
        Object[] key = map.keySet().toArray();
        System.out.println(key[position] + "=" + map.get(key[position]));
    }

}
