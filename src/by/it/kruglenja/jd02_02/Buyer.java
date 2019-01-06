package by.it.kruglenja.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer {

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

        System.out.println(this + "выбирает товар");
        backet.putGoodsToBacket(customerNumber);
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "выбрал товар");

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
