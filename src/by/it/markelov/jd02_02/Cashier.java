package by.it.markelov.jd02_02;

public class Cashier extends Thread {
    public Cashier(String s) {
        super(s);
        this.start();
    }

    public void serve() {
        synchronized (Queue.monitorForQueue) {
            Buyer buyer = Queue.buyers.peekFirst();
            if (buyer == null) {
                System.out.println("Очередь пуста");
            } else {
                System.out.println("Обслуживаю :" + buyer);
                try {
                    Thread.sleep(Util.random(2000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        serve();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}