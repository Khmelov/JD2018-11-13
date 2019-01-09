package by.it.medvedeva.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

class QueueBuyer {

    private Deque<Buyer> deque=new LinkedList<>();
    int size = 0;
    boolean lock = false;

    synchronized void add(Buyer buyer){

        size++;
        deque.addLast(buyer);

    }
    synchronized Buyer extract(){
        if (size>0) size--;
        return deque.pollFirst();
    }
    synchronized int getSize() {
        return size;
    }
    synchronized boolean getLock() {
        if (!lock) {
            lock = true;
            return true;
        } else {
            return false;
        }
    }
    synchronized void releaseLock() {
        lock = false;
    }
}