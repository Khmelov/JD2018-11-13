package by.it.vchernetski.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyer {
    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Buyer> pensioneer = new LinkedList<>();
    static synchronized void add(Buyer buyer){
       if(buyer.pensioneer) pensioneer.addLast(buyer);
       else deque.addLast(buyer);
    }
    static synchronized int sizePensioneer(){return pensioneer.size();}
    static synchronized int sizeNotPensioneer(){return deque.size();}
    static synchronized Buyer extractPensioner(){return pensioneer.pollFirst();}
    static synchronized Buyer extractNotPensioner(){return deque.pollFirst();}
    public static int getDequeSize(){return deque.size()+pensioneer.size();}
}
