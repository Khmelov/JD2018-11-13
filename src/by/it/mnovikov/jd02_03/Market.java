package by.it.mnovikov.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
//        Goods.setGoods();
//        System.out.println(Goods.goods.entrySet());
        System.out.println("Магазин открылся");

        for (int num = 1; num <= 2; num++) {
            Cashier cashier = new Cashier(num);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        for (int time = 0; Dispatcher.marketOpened(); time++) {
            int buyerCount = Util.random(0, 2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                    threads.add(buyer);
                    buyer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрылся");
    }
}

