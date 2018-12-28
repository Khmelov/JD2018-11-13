package by.it.markelov.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    public static final int K_ACCELERATION=1000;

    public static AtomicInteger buyersCreated =new AtomicInteger(0);

    public static AtomicInteger buyersInMarketNow =new AtomicInteger(0);

    private static final int buyerPlan = 100;

    private static final Object monitor = new Object();

    public static final Semaphore semaphore=new Semaphore(20);

    public static final Semaphore semaphoreBuyer=new Semaphore(0);
    public static final Semaphore semaphoreCashier=new Semaphore(1);



    static void addBuyer() {
        buyersCreated.incrementAndGet();
        buyersInMarketNow.incrementAndGet();
    }
    static void removeBuyer() {
        buyersInMarketNow.decrementAndGet();
        }


    static boolean marketClosed() {
        synchronized (monitor) {
            return buyersCreated.get() >= buyerPlan && buyersInMarketNow.get() == 0;
        }
    }
}
