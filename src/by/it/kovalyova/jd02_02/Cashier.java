package by.it.kovalyova.jd02_02;

public class Cashier implements Runnable {
    private String name;
    public QueueBuyer myqueue = new QueueBuyer();
    private QueueBuyer mainqueue;

    public Cashier(int number, QueueBuyer queue){
        name = "--- Cashier №" + number + ": ";
        mainqueue = queue;
    }

    @Override
    public void run() {
        System.out.println(this+" started work");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = myqueue.extract();
            if (buyer==null){
                buyer = mainqueue.extract();
                if (buyer==null) {

                    System.out.println(this + "finished work by no buyers");
                    return;
                }
            }
            else {
                System.out.println(this+"started service "+buyer);
                int time=Util.random(2000,5000);
                Util.sleep(time);
                System.out.println(this+"finished service "+buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            if (mainqueue.getLock()) {
                Buyer newbuyer = mainqueue.extract();
                mainqueue.releaseLock();
                if (newbuyer!=null) {
                    myqueue.add(newbuyer);
                    System.out.println(this + "added " + newbuyer);
                } else {
                    System.out.println(this+"no buyers");
                }


            } else {
                System.out.println("Can't");
            }
        }
        System.out.println(this+"closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
