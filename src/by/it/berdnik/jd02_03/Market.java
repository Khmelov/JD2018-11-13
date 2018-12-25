package by.it.berdnik.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {
        List<Thread> thBuyers = new ArrayList<>();
        System.out.println("Market opened");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Cashier(1));
        executorService.execute(new Cashier(2));
        executorService.shutdown();

        for (; Dispatcher.marketOpened(); ) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()) {
                    Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                    thBuyers.add(buyer);
                    buyer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread thread : thBuyers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!executorService.isTerminated())
            Util.sleep(1);
        System.out.println("Market closed");
    }

}
