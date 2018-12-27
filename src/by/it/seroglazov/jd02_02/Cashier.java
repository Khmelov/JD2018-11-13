package by.it.seroglazov.jd02_02;

public class Cashier implements Runnable {

    private final Shop shop;
    private Thread thread;
    private boolean endWork = false;
    private boolean isWaiting = false;

    public int getNomer() {
        return nomer;
    }

    private int nomer;
    //private final Object monitor = new Object();

    Cashier(int num, Shop shop) {
        this.shop = shop;
        nomer = num;
        thread = new Thread(this, "CashierN" + num);
        thread.start();
    }

    @Override
    public void run() {
        while (!endWork) {
            Buyer buyer = shop.takeFromLine();
            if (buyer != null) {
                int len = shop.lineLength();
                service(buyer, len);
            }
            else {
                if (Runner.FULL_LOG) System.out.println(this + " касса закрылась");
                pause();
            }
        }
    }

    // Обслуживание покупателя
    private void service(Buyer b, int lineLength) {
        if (Runner.FULL_LOG) System.out.println(this + " обслуживает " + b.getShortName());
        shop.check(b, this, lineLength);
        SleepCases.sleepRandom(2000, 5000);
        synchronized (b) {
            b.setStayingInLine(false);
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
        while (isWaiting) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        }
    }


    // Разбуть кассира если он отдыхает и заставить работать
    // Возвращает true если кассир отдыхал
    synchronized boolean wakeUp() {
        if (isWaiting) {
            isWaiting = false;
            notify();
            if (Runner.FULL_LOG) System.out.println(this + " приступил к работе!");
            return true;
        } else return false;
    }

    private synchronized void wakeAndClose() {
        isWaiting = false;
        notify();
    }

    synchronized boolean isWaiting(){
        return isWaiting;
    }

    Thread getThread(){
        return thread;
    }
}
