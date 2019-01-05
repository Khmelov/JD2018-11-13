package by.it.lobkova.jd02_03;

public class Cashier extends Thread implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "--- Cashier №" + number + ": ";
        Dispatcher.addCashier();
    }

    private static boolean isKill = false;

    @Override
    public void run() {
        while (!isKill) {
            System.out.println(this + " started work");
            while (!Dispatcher.marketClosed()) {
                Buyer buyer = QueueBuyer.extract();
                if (buyer == null) {
                    Util.sleep(1);
                } else {
                    System.out.println(this + " started service " + buyer);
                    Util.sleep(buyer.getBasket().goods.size() * 1000);
                    int sum = 0;
                    for (Good good : buyer.getBasket().goods) {
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
        }
        System.out.println(this + " closed");
    }

    public void kill() {
        isKill = true;
    }

    @Override
    public String toString() {
        return  name;
    }
}
