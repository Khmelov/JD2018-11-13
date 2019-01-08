package by.it.denisova.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "--- Cashier №" + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this + " started work");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyer.extract();
            if (buyer == null) {
                Util.sleep(1);
            } else {
                System.out.println(this + " started service " + buyer);
                Util.sleep(Util.random(2000, 5000));
                int sum = 0;
                for (Good good: buyer.getBasket().goods) {
                    System.out.println("*** " + good.id + " - " + good.value + " ***");
                    sum += good.value;
                }
                System.out.println("** The amount of goods = " + sum);
                System.out.println(this + " finished service " + buyer + "\n\n");
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return  name;
    }
}