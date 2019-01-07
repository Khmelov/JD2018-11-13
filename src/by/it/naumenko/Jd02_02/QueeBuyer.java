package by.it.naumenko.Jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueeBuyer {
    private static Deque<Buyer> deque = new LinkedList<>();
    static void addBuyerQuee(Buyer buyer){
        //synchronized (QueeBuyer.class)
        deque.addLast(buyer);
    }

    static synchronized Buyer buyerExtract(){
        return deque.pollFirst();


    }
}
