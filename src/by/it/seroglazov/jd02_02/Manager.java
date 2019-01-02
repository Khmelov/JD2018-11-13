package by.it.seroglazov.jd02_02;

public class Manager implements Runnable {

    private Thread thread;
    private Shop shop;
    private boolean endWork = false;

    Manager(Shop shop) {
        this.shop = shop;
        thread = new Thread(this, "Manager");
        thread.start();
    }

    @Override
    public void run() {
        while (!endWork) {
            SleepCases.sleepFor(1);
            shop.checkForCashiers(this);
            if (shop.isClosedShop()) {
                shop.freePersonal(this);
                break;
            }
        }
        System.out.println("Магазин закрылся.");
    }

    void endOfWorkDay() {
        endWork = true;
    }


}
