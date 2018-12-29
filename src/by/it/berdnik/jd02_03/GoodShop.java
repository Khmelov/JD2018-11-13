package by.it.berdnik.jd02_03;

import java.util.*;

public class GoodShop {

    static HashMap<String, Double> prodRandom;

    static HashMap<String, Double> products(int rnd) {
        HashMap<String, Double> hashMap = new HashMap<>(21);
        hashMap.put("Product 1", 1.1);
        hashMap.put("Product 2", 2.2);
        hashMap.put("Product 3", 3.3);
        hashMap.put("Product 4", 4.4);
        hashMap.put("Product 5", 15.1);
        hashMap.put("Product 6", 1.6);
        hashMap.put("Product 7", 1.7);
        hashMap.put("Product 8", 18.1);
        hashMap.put("Product 9", 19.1);
        hashMap.put("Product 10", 10.1);
        hashMap.put("Product 11", 11.1);
        hashMap.put("Product 12", 12.1);
        hashMap.put("Product 13", 13.1);
        hashMap.put("Product 14", 14.1);
        hashMap.put("Product 15", 1.5);
        hashMap.put("Product 16", 16.1);
        hashMap.put("Product 17", 17.1);
        hashMap.put("Product 18", 1.8);
        hashMap.put("Product 19", 19.1);
        hashMap.put("Product 20", 20.1);
        hashMap.put("Product 21", 21.1);

        Set<String> keySet = hashMap.keySet();
        List<String> listOfKeys = new ArrayList<>(keySet);
        Collections.shuffle(listOfKeys);
        prodRandom = new HashMap<>(rnd);
        for (int i = 0; i < rnd; i++) {
            prodRandom.put(listOfKeys.get(i), hashMap.get(listOfKeys.get(i)));
        }
        return prodRandom;
    }

    static double FinPrice() {
        double price = 0;
        for (double i : prodRandom.values()) {
            price += i;
        }
        return price;
    }

}

