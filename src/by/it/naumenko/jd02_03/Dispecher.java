package by.it.naumenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispecher {

    //private static final Object localMOnitor = new Object();
    static final int buyerPlan = 100;
    static AtomicInteger buyerInShop = new AtomicInteger(0);
    static AtomicInteger buyerCounter = new AtomicInteger(0);


    static boolean shopCloosed() {

            return buyerCounter.get() >= buyerPlan && buyerInShop.get()==0;
    }

    static int getBuyerCounter() {
        return buyerCounter.get();
    }

    static boolean shopOpened() {

            //return !shopCloosed();
            return buyerCounter.get() <=buyerPlan;
    }

    static void  addBuyer() {

            buyerCounter.incrementAndGet();
            buyerInShop.incrementAndGet();
    }

    static void  removeBuyer() {

            buyerInShop.decrementAndGet();

    }
}

