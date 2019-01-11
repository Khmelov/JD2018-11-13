package by.it.mnovikov.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {
        List<Thread> threadBuyers = new ArrayList<>();
        System.out.println("Магазин открылся");

        ExecutorService excServ = Executors.newFixedThreadPool(5);
        excServ.execute(new Cashier(1));
        excServ.execute(new Cashier(2));
        excServ.shutdown();

        for (; Dispatcher.marketOpened(); ) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                    threadBuyers.add(buyer);
                    buyer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread thread : threadBuyers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!excServ.isTerminated())
            Util.sleep(1);
        System.out.println("Магазин закрылся");
    }
}

