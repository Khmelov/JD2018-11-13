package by.it.vchernetski.jd02_03;


import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBuyer {
    static Comparator<Buyer> comparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            if(o1.pensioneer&&!o2.pensioneer)return -1;
            if(!o1.pensioneer&&o2.pensioneer)return 1;
            if(o1.pensioneer&&o2.pensioneer){
                if(o1.timeToQueue<=o2.timeToQueue) return -1;
                else return 1;
            }
            if(!o1.pensioneer&&!o2.pensioneer){
                if(o1.timeToQueue<=o2.timeToQueue) return -1;
                else return 1;
            }
            return 0;
        }
    };
    static PriorityBlockingQueue<Buyer> buyers = new PriorityBlockingQueue<>(30,comparator);
    public static void add(Buyer buyer){
        buyers.put(buyer);
        if(buyer.pensioneer) Dispatcher.pensioneerBuyerInQueueu.getAndAdd(1);
    }
    public static Buyer extract(){
        Buyer buyer = buyers.poll();
        return buyer;
    }
}
