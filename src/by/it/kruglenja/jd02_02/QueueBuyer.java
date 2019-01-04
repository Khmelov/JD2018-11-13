package by.it.kruglenja.jd02_02;

import java.io.DataInputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by user on 20.12.2018.
 */
public class QueueBuyer {

    private static LinkedList<Buyer> buyerQueue = new LinkedList<>();
    private static LinkedList<Buyer> oldMansQueue = new LinkedList<>();

    public static int getBuyersInQueue() {
        return buyerQueue.size();
    }

    //Добавляем баера в очередь
    static synchronized void addBuyer(Buyer buyer) {
        buyerQueue.addLast(buyer);
        System.out.println("++++++++++++++" + buyerQueue.size());
    }

    //Удаляем баера из очереди
    static Buyer buyerExtract() {
        return buyerQueue.pollFirst();
    }

}

