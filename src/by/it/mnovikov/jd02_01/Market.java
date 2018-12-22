package by.it.mnovikov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        Goods.setGoods();
        System.out.println(Goods.goods.entrySet());
        System.out.println("Магазин открылся");

        for (int time = 0; time < 120; time++) {
            int buyerCount = Rnd.random(0, 2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                buyerList.add(buyer);
                buyer.start();
            }
            Rnd.sleep(1000);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрылся");
    }
}

