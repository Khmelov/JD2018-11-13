package by.it.zakharenko.jd02_03;

import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyer {
    public static Deque<Buyer> getDeque() {
        return deque;
    }

    private static BlockingDeque<Buyer> deque=new LinkedBlockingDeque<>(30);

    //synchronized (QueueBuyer.class)
    static synchronized void add(Buyer buyer){
        deque.addLast(buyer);
    }

    //synchronized (QueueBuyer.class)
    static synchronized Buyer extract(){
        return deque.pollFirst();
    }
}
