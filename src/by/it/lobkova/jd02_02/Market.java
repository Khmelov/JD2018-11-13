package by.it.lobkova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static List<Basket> basketList = new ArrayList<>();
    static List<Good> goodList = new ArrayList<>();

    public static void main(String[] args) {
        initialSetup();
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market is open");

        for (int num = 1; num <= 2; num++) {
            Cashier cashier = new Cashier(num);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        for (; ;) {
            if (!Dispatcher.marketOpened()) break;

            if (QueueBuyer.getDeque().size() > 5 && Dispatcher.getCashierCount() != 5) {
                for (int num = 3; num <= 5; num++) {
                    Cashier cashier = new Cashier(num);
                    Thread thread = new Thread(cashier);
                    thread.start();
                    threads.add(thread);
                }
                Dispatcher.setCashierCount(5);
            }

            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                threads.add(buyer);
                buyer.start();
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
        System.out.println("Market is closed");
    }
    private static void initialSetup() {
        for (int i = 0; i < 100; i++) {
            goodList.add(new Good());
        }

        for (int i = 0; i < 3; i++) {
            basketList.add(new Basket());
        }
    }

    public static void giveSomeBaskets() {
        System.out.println("----------- added 2 baskets ------------");
        for (int counter = 0; counter < 2; counter++) {
            basketList.add(new Basket());
        }
    }
}
