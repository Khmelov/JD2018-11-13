package by.it.denisova.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyer {
    private static Deque<Buyer> deque = new LinkedList<>();

    public static Deque<Buyer> getDeque() {
        return deque;
    }

    //synchronized (QueueBuyer.class)
    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    //synchronized (QueueBuyer.class)
    static synchronized Buyer extract(){
        return deque.pollFirst();
    }
}