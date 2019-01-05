package by.it.lobkova.jd02_03;

import java.util.Deque;
import java.util.LinkedList;

class QueueBuyer {
    public static Deque<Buyer> getDeque() {
        return deque;
    }

    private static Deque<Buyer> deque = new LinkedList<>();

    //synchronized (QueueBuyer.class)
    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    //synchronized (QueueBuyer.class)
    static synchronized Buyer extract(){
        return deque.pollFirst();
    }
}
