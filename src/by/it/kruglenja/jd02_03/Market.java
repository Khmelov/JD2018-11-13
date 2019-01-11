package by.it.kruglenja.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Магазин открыт");

        for (int time = 0; Dispathcer.marketOpen(); time++) {
            CashierDispatcher.runChasier();
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispathcer.marketOpen()) {
                    Buyer buyer = new Buyer(Dispathcer.getBuyerCounter());
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
        System.out.println("Магазин закрыт");
        System.out.println(CashierDispatcher.cashierList.toString());
        System.out.println(CashierDispatcher.cashierList.size());

    }
}
