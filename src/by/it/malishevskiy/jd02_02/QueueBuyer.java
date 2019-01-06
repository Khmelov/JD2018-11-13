package by.it.malishevskiy.jd02_02;

import java.util.Deque;
import java.util.LinkedList;


public class QueueBuyer {

    private static Deque<Buyer> bList = new LinkedList<>();

    static synchronized void addBuyer(Buyer buyer){
        bList.addLast(buyer);
    }

    static Buyer buyerExtract(){
       return bList.pollFirst();

    }

}
