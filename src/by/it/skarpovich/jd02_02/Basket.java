package by.it.skarpovich.jd02_02;

import java.util.*;

public class Basket {
    static String goods(int rndCount) {     //Создаем метод, который принимает к-во покупок(rnd) и возвращает строку - список покупок.
        StringBuilder sb=new StringBuilder(50);
        HashMap<String, Double> hashMap = new HashMap<>(4);   //Создаем hashMap всех(4-х) товаров

        hashMap.put("пиво", 2.0);
        hashMap.put("чипсы", 1.5);
        hashMap.put("лимон", 0.75);
        hashMap.put("текилла", 14.99);

        Set<String> keySet = hashMap.keySet();                    // Получаем множество ключей
        List<String> listOfKeys = new ArrayList<>(keySet);        // Создаем List из ключей (покупок)
        //System.out.println(listOfKeys);
        Collections.shuffle(listOfKeys);                          // Тасуем покупки
        List<String> goodsList = listOfKeys.subList(0, rndCount); // Обрезаем List до случайного количества(rndCount) с помощью Sublist
        //System.out.println(listOfKeys);

        /*Создаем список покупок с ценами и добавляем в StringBuilder: выводим покупку(=ключ) из саблиста и
        получаем значение(цену) для него из hashMap*/
        for (int i = 0; i < rndCount; i++) {
            sb.append(goodsList.get(i)).append(" - ").append(hashMap.get(goodsList.get(i))).append("р. ");
        }
        return sb.toString();
    }
}
