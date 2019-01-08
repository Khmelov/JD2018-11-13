package by.it.naumenko.jd02_03;

import by.it.naumenko.jd02_01.Byuer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueeBuyer {
    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>();
    static void addBuyerQuee(Buyer buyer){
        //synchronized (QueeBuyer.class)
        deque.add(buyer);
    }

    static Buyer buyerExtract(){
        return deque.pollFirst();


    }
//    private final  static ConcurrentLinkedQueue queeByuers = new ConcurrentLinkedQueue();
//
//    public static boolean addBuyerQuee(Byuer byuer){
//        return queeByuers.add(byuer);
//    }
//
//    public static Buyer pol(){
//        if (queeByuers.isEmpty())
//            return null;
//        else
//            return (Buyer) queeByuers.poll();
//    }
}
