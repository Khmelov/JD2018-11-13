package by.it.seroglazov.jd02_02;

public class Cashier implements Runnable {

    private final Shop shop;
    private final int kspeed;
    private Thread thread;
    private boolean endWork = false;

    Cashier(int num, Shop shop, int kspeed) {
        this.shop = shop;
        this.kspeed = kspeed;
        thread = new Thread(this, "Кассир №" + num);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            Buyer buyer = shop.getBuyerFromLine();
            if (buyer != null) service(buyer);
            else {

            }
        }
    }

    // Обслуживание покупателя
    private void service(Buyer b) {
        System.out.println(this + " обслуживает " + b);
        sleepRandom(2000, 5000);
    }

    @Override
    public String toString() {
        return thread.getName();
    }

    private void sleepRandom(int minMillis, int maxMillis) {
        int millis = MyRandom.getRandom(minMillis, maxMillis);
        try {
            Thread.sleep(millis / kspeed);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }

    private void sleepFor(int millis) {
        try {
            Thread.sleep(millis / kspeed);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }

    void endOfWorkDay() {
        endWork = true;
    }
}
