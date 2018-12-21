package by.it.kruglenja.jd02_02;

public class Cashier implements Runnable {
    public String name;

    public Cashier(int number) {
        name = "--- КассА №" + number + ": ";
    }

    @Override
    public void run() {
        System.out.println("Касса №" + this + " открылась!");
        while (!Dispathcer.marketClosed()) {
            Buyer buyer = QueueBuyer.buyerExtract();
            if (buyer == null) {
                Util.sleep(1);
            } else {
                System.out.println(this + "начала обслуживание " + buyer);
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                System.out.println(this + "закончила обслуживание " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
        System.out.println("Касса №" + this + " закрылась");
    }

    @Override
    public String toString() {
        return name;
    }
}
