package by.it.markelov.jd02_02;

public class Cashier extends Thread {
    public Cashier(String s) {
        super(s);
        this.start();
    }

    Buyer buyer;

    public void serve() {
        while (!Dispatcher.marketClosed()) {
            try {
                Thread.sleep(Util.random(2000, 5000) / Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buyer = Queue.queueBuyers.pollFirst();
            if (buyer == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;

            } else {
                System.out.println(this.getName() + " обслужил " + buyer.getName());
                Basket basketOfBuyer = buyer.basketOfBuyer;
                basketOfBuyer.basketContent();
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        serve();
    }

}
