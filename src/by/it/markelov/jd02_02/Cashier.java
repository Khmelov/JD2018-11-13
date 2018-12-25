package by.it.markelov.jd02_02;

import static by.it.markelov.jd02_02.Queque.*;

public class Cashier extends Thread {
    public Cashier(String s) {
        super(s);
        this.start();
    }

    Buyer buyer;

    public void serve() {
        synchronized (Buyer.monitor) {
            while (!quequeBuyers.isEmpty()) {

                try {
                    Thread.sleep(Util.random(2000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                buyer = quequeBuyers.pollFirst();
                if (buyer != null) {
                    System.out.println("                                          Обслужил покупателя " + buyer);
                } else System.out.println("                                                      Очередь пуста");
                Buyer.monitor.notify();

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
