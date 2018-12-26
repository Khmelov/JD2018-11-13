package by.it.akhmelev.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;

    private static AtomicInteger buyerCounter = new AtomicInteger(0);
    private static AtomicInteger buyerInShop = new AtomicInteger(0);
    private static final int buyerPlan = 100;

    static int getBuyerCounter() {
        return buyerCounter.get();
    }

    static void addBuyer() {
        buyerCounter.incrementAndGet();
        buyerInShop.incrementAndGet();
    }

    static void removeBuyer() {
        buyerInShop.decrementAndGet();
    }


    static boolean marketClosed() {
        return
                buyerCounter.get() >= buyerPlan
                        && buyerInShop.get() == 0;
    }

    static boolean marketOpened() {
        return buyerCounter.get() < buyerPlan;
    }


}
