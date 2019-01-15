package by.it.nickgrudnitsky.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyer {

    private static Deque<Buyer> deque = new LinkedList<>();

    //synchronized (QueueBuyer.class)
    static synchronized void addBuyer (Buyer buyer){
        deque.addLast(buyer);
    }

    static synchronized Buyer extract (Buyer buyer){
        return deque.pollFirst();
    }
}
