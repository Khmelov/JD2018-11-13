package by.it.seroglazov.jd02_01;

public class Buyer implements IBuyer, Runnable {

    // Номер покупателя
    private int num;
    private Thread th;

    public Buyer(int num) {
        this.num = num;
        th = new Thread(this, "Покупатель № " + num);
        th.start();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            sleepRandom(500, 2000);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
        System.out.println(this + " выбрал товар.");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public String toString() {
        return th.getName();
    }

    private void sleepRandom(int minMillis, int maxMillis) throws InterruptedException {
        int millis = minMillis + (int)(Math.random()*(maxMillis - minMillis + 1));
        Thread.sleep(millis);
    }
}
