package by.it.medvedeva.jd02_03;


import java.util.Deque;
import java.util.LinkedList;

class QueueBuyer {

    static private Deque<Buyer> deque=new LinkedList<>();
    static int size = 0;
    static boolean lock = false;

    synchronized static void add(Buyer buyer){

        size++;
        deque.addLast(buyer);

    }
    synchronized static Buyer extract(){
        if (size>0) size--;
        return deque.pollFirst();
    }
    synchronized static int getSize() {
        return size;
    }
    synchronized static boolean getLock() {
        if (!lock) {
            lock = true;
            return true;
        } else {
            return false;
        }
    }
    synchronized static void releaseLock() {
        lock = false;
    }
}