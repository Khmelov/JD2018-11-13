package by.it.seroglazov.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;

public class Manager implements Runnable {

    private Shop shop;
    private AtomicBoolean endWork = new AtomicBoolean(false);

    Manager(Shop shop) {
        this.shop = shop;
        new Thread(this, "Manager").start();
    }

    @Override
    public void run() {
        while (!endWork.get()) {
            SleepCases.sleepFor(1);
            shop.checkForCashiers(this);
            //shop.checkIfNeedCloseTheShop();
            if (shop.isClosedShop()) {
                shop.freePersonal(this);
                break;
            }
        }
        System.out.println("Магазин закрылся.");
    }

    void endOfWorkDay() {
        endWork.set(true);
    }


}
