package by.it.mnovikov.jd02_02;

public class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "---- Cashier №" + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this + " начал работу");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyer.extract();
            if (buyer == null) {
                Util.sleep(1);
            } else {
                System.out.println(this + " начал обслуживать " + buyer);
                int timeout = Util.random(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " закончил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        System.out.println(this + " закрылся");
    }

    @Override
    public String toString() {
        return name;
    }
}
