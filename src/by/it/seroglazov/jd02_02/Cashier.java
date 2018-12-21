package by.it.seroglazov.jd02_02;

public class Cashier implements Runnable {

    private final Shop shop;
    private Thread thread;
    private boolean endWork = false;
    private boolean isWaiting = false;
    //private final Object monitor = new Object();

    Cashier(int num, Shop shop) {
        this.shop = shop;
        thread = new Thread(this, "CashierN" + num);
        thread.start();
    }

    @Override
    public void run() {
        while (!endWork) {
            Buyer buyer = shop.takeFromLine();
            if (buyer != null) service(buyer);
            else {
                System.out.println(this + " касса закрылась");
                pause();
                //SleepCases.sleepFor(1);
            }
        }
    }

    // Обслуживание покупателя
    private void service(Buyer b) {
        System.out.println(this + " обслуживает " + b.getShortName());
        shop.check(b, this);
        SleepCases.sleepRandom(2000, 5000);
        synchronized (b) {
            b.notify();
        }
    }

    @Override
    public String toString() {
        return "   " + thread.getName();
    }

    synchronized void endOfWorkDay() {
        endWork = true;
        wakeAndClose();
    }

    private synchronized void pause() {
        isWaiting = true;
        try {
            wait();
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }


    // Разбуть кассира если он отдыхает и заставить работать
    // Возвращает true если кассир отдыхал
    synchronized boolean wakeUp() {
        if (isWaiting) {
            isWaiting = false;
            notify();
            System.out.println(this + " приступил к работе!");
            return true;
        } else return false;
    }

    private synchronized void wakeAndClose() {
        notify();
    }

    synchronized boolean isWaiting(){
        return isWaiting;
    }

    Thread getThread(){
        return thread;
    }
}
