package by.it.denisova.jd02_03;

import java.util.concurrent.Semaphore;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "--- Cashier №" + number + ": ";
    }

    private static Semaphore semaphore = new Semaphore(20);

    @Override
    public void run() {
        System.out.println(this + " started work");
        try {
            semaphore.acquire();
            while (!Dispatcher.marketClosed()) {
                Buyer buyer = QueueBuyer.extract();
                if (buyer == null) {
                    Util.sleep(1);
                } else {
                    System.out.println(this + " started service " + buyer);
                    Util.sleep(Util.random(200, 5000));
                    int sum = 0;
                    for (Good good: buyer.getBasket().goods) {
                        System.out.println("*** " + buyer + " buy - " + good.id + " = " + good.value + "$ ***");
                        sum += good.value;
                    }
                    System.out.println("** The amount of goods = " + sum + "$");
                    System.out.println(this + " finished service " + buyer + "\n\n");
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return  name;
    }
}