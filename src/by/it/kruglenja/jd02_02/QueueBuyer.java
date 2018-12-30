package by.it.kruglenja.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by user on 20.12.2018.
 */
public class QueueBuyer {

    private static Deque<Buyer> bList = new LinkedList<>();

    static synchronized void addBuyer(Buyer buyer){
        bList.addLast(buyer);
    }

    static Buyer buyerExtract(){
       return bList.pollFirst();

    }

}

