package by.it.vchernetski.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED = 120;
    public static AtomicInteger buyerCounter = new AtomicInteger(0);
    public static AtomicInteger pensioneerBuyerInQueueu = new AtomicInteger(0);
    public static AtomicInteger buyerInShop = new AtomicInteger(0);
    private static final int buyerPlan = 100;
    private static Object monitor = new Object();
    public static Semaphore semaphoreBuyers = new Semaphore(20,true);
    public static BlockingDeque<Buyer> buyersWithBacket = new LinkedBlockingDeque<>(50);
    static int getBuyerCounter() {
        return buyerCounter.get();
    }

    static int getBuyerInShop() {
        return buyerInShop.get();
    }

    static void addBuyer() {
        buyerCounter.getAndAdd(1);
        buyerInShop.getAndAdd(1);
    }
    static void removeBuyer() {
        buyerInShop.getAndAdd(-1);
    }

    static boolean marketClosed() {
        synchronized (monitor) {
            return buyerCounter.get() >= buyerPlan && buyerInShop.get() == 0;
        }
    }

    static boolean marketOpened() {
        synchronized (monitor) {
            return buyerCounter.get() < buyerPlan;
        }
    }
}
