package by.it.kruglenja.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer {

    private Backet backet = new Backet();
    private int customerNumber;
    public static List<Integer> queue = new ArrayList<>();

    Buyer(int number) {
        super("Покупатель №" + number);
        customerNumber = number;
        Dispathcer.addBayer();
    }

    @Override
    public void run() {
        enterToMarket();
        backet.takeBacket(customerNumber);
        chooseGoods();
        goToQueue();
        Util.sleep(5000);
        CashierDispatcher.runChasier();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName() + ": ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        backet.putGoodsToBacket(customerNumber);
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "выбрал товар и стал в очередь");

    }

    @Override
    public void goToQueue() {
        QueueBuyer.addBuyer(this);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "отправился на выход");
        Dispathcer.removeBuyer();
    }
}
