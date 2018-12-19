package by.it.seroglazov.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    // Номер покупателя
    private int num;
    private Shop shop;
    private int kspeed;

    Basket basket;

    public Buyer(int num, Shop shop, int kspeed) {
        super("Покупатель № " + num);
        this.num = num;
        this.shop = shop;
        this.kspeed = kspeed;
        start();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашёл в магазин.");
        yield();
    }

    @Override
    public void chooseGoods() {
        sleepRandom(500, 2000);
        System.out.println(this + " выбрал товар.");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    private void sleepRandom(int minMillis, int maxMillis) {
        int millis = MyRandom.getRandom(minMillis, maxMillis);
        try {
            Thread.sleep(millis / kspeed);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }

    @Override
    public void takeBasket() {
        basket = new Basket();
        System.out.println(this + " взял корзину.");
        sleepRandom(100, 200);
    }

    @Override
    public void putGoodsToBasket() {
        int n = MyRandom.getRandom(1, 4);
        for (int i = 0; i < n; i++) {
            sleepRandom(100, 200);
            String good = shop.takeSomeGood();
            basket.putGoodToBasket(good);
            System.out.println(this + " положил в корзину " + good + '.');
        }
    }
}
