package by.it.lobkova.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static List<Basket> basketList = new ArrayList<>();
    static List<Good> goodList = new ArrayList<>();
    static List<Cashier> threads = new ArrayList<>();
    static List<Buyer> buyers = new ArrayList<>();

    private static void initialSetup() {
        for (int i = 0; i < 100; i++) {
            goodList.add(new Good());
        }

        for (int i = 0; i < 3; i++) {
            basketList.add(new Basket());
        }
    }

    public static void main(String[] args) {
        initialSetup();

        System.out.println("Market is open");

//        for (int num = 1; num <= 2; num++) {
//            Cashier cashier = new Cashier(num);
//            Thread thread = new Thread(cashier);
//            threads.add(thread);
//            thread.start();
//        }

        for (; ;) {
            if (!Dispatcher.marketOpened()) break;

            if (QueueBuyer.getDeque().size() <= 5) {
                checkCashiers(1);
            } else if (QueueBuyer.getDeque().size() <= 10) {
                checkCashiers(2);
            } else if (QueueBuyer.getDeque().size() <= 15) {
                checkCashiers(3);
            } else if (QueueBuyer.getDeque().size() <= 20) {
                checkCashiers(4);
            } else {
                checkCashiers(5);
            }

            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                buyers.add(buyer);
                buyer.start();
            }
            Util.sleep(100);
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

    public static void giveSomeBaskets() {
        System.out.println("----------- added 2 baskets ------------");
        for (int counter = 0; counter < 2; counter++) {
            basketList.add(new Basket());
        }
    }

    public static void addCashier() {
        Cashier cashier = new Cashier(Dispatcher.getCashierCount() + 1);
        threads.add(cashier);
        cashier.start();
        System.out.println("@+++++++@@@@@@@@@@@ new cashier start");
    }

    public static void removeCashier() {
        Dispatcher.removeCashier();
        threads.remove(threads.size() - 1).kill();
        System.out.println("@+++++@@@@@@@@@@@ cashier stop");
    }

    static void checkCashiers(int count) {
        if (count > Dispatcher.getCashierCount()) {
            while (Dispatcher.getCashierCount() != count) {
                addCashier();
            }
        } else {
            while (Dispatcher.getCashierCount() != count) {
                removeCashier();
            }
        }
    }
}
