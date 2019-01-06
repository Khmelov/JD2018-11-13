package by.it.skarpovich.jd02_02;

import java.util.*;

class Basket {
    static HashMap<String, Double> hashMapShuffled;

    static HashMap<String, Double> goods(int rndCount) {     //Создаем метод, который принимает к-во покупок(rnd) и возвращает строку - список покупок.
        HashMap<String, Double> hashMap = new HashMap<>(4);   //Создаем hashMap всех(4-х) товаров
        hashMap.put("пиво", 2.0);
        hashMap.put("чипсы", 1.5);
        hashMap.put("лимон", 1.0);
        hashMap.put("текилла", 15.0);

        Set<String> keySet = hashMap.keySet();                    // Получаем множество ключей
        List<String> listOfKeys = new ArrayList<>(keySet);        // Создаем List из ключей (покупок)
        Collections.shuffle(listOfKeys);                          // Тасуем покупки
        //List<String> goodsList = listOfKeys.subList(0, rndCount); // Обрезаем List до случайного количества(rndCount) с помощью Sublist

        hashMapShuffled = new HashMap<>(rndCount);
        for (int i = 0; i < rndCount; i++) {
            hashMapShuffled.put(listOfKeys.get(i), hashMap.get(listOfKeys.get(i)));
            //hashMapShuffled.put(goodsList.get(i), hashMap.get(goodsList.get(i)));
        }
        return hashMapShuffled;
    }

    static double BasketSum() {
        double total = 0;
        for (double d : hashMapShuffled.values()) {
            total += d;
        } return total;
    }
}

