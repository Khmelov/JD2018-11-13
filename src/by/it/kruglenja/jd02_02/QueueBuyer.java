package by.it.kruglenja.jd02_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by user on 20.12.2018.
 */
public class QueueBuyer {

    private static ConcurrentLinkedDeque<Buyer> buyerQueue = new ConcurrentLinkedDeque<>();


    static synchronized void addBuyer(Buyer buyer) {
        buyerQueue.addLast(buyer);
        System.out.println("++++++++++++++" + buyerQueue.size());
    }

    static Buyer buyerExtract() {
        return buyerQueue.pollFirst();

    }
    public static int getBuyersInQueue(){
        return buyerQueue.size();
    }
}

