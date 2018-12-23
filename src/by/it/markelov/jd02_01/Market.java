package by.it.markelov.jd02_01;

import java.util.HashMap;

import static by.it.markelov.jd02_01.Dispatcher.*;
import static by.it.markelov.jd02_01.Goods.pricelist;

public class Market {

    public static void main(String[] args) {
        pricelist.put("Хлеб", 1);
        pricelist.put("Масло", 3);
        pricelist.put("Молоко", 2);
        pricelist.put("Сыр", 4);
        pricelist.put("Сок", 2);
        pricelist.put("Батон", 1);
        pricelist.put("Вода", 2);
        pricelist.put("Сметана", 3);


        for (int i = 0; i < 120; i++) {
            int random = Util.random(0, 2);
            for (int j = 1; j <= random; j++) {
                buyersIn++;
                Buyer buyer = new Buyer("Покупатель № " + buyersIn);
            }
            try {
                Thread.sleep(1000 / K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (buyersOut >= buyersIn)
            System.out.println("Магазин закрылся");
    }

}
