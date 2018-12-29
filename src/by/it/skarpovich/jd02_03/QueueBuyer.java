package by.it.skarpovich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyer {

    private static BlockingDeque<Buyer> deque=new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) throws InterruptedException {
        deque.putLast(buyer);
    }

    static Buyer extract(){
        return deque.pollFirst();
    }

}
