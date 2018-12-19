package by.it.markelov.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        Goods.pricecurrant.put("Хлеб", 3);
        Goods.pricecurrant.put("Молоко", 5);
        Goods.pricecurrant.put("Сметана", 7);
        Goods.pricecurrant.put("Мясо", 9);

 /*       Set<Map.Entry<String, Integer>> entries = Goods.pricecurrant.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
*/

        Buyer buyer;
        int countBuyers = 0;//порядковый номер покупателя
        for (int i = 0; i < 120; i++) {

            int count = (int) (Math.random() * 3);//количество покупателей вошедших в магазин в 1 секунду (от 0 до 2)

            switch (count) {
                case 0:
                    break;
                case 1:
                case 2:
                    for (int j = 1; j <= count; j++) {
                        countBuyers++;
                        buyer = new Buyer("Покупатель " + countBuyers);//создаем покупателя и даем ему имя
                        buyer.start();
                    }
                    break;
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Магазин закрылся");

    }
}
