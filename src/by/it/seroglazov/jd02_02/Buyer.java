package by.it.seroglazov.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private int num; // Номер покупателя
    private int kspeed;
    private boolean pensioneer;

    private final Shop shop;
    private Basket basket;

    Buyer(int num, Shop shop, int kspeed) {
        super("Покупатель № " + num);
        this.num = num;
        this.shop = shop;
        this.kspeed = kspeed;
        pensioneer = Math.random() < 0.25;
        start();
    }

    @Override
    public void enterToMarket() {
        int c = shop.enter(this);
        System.out.println(this + " зашёл в магазин (стало " + c + ")");
        yield();
    }

    @Override
    public void chooseGoods() {
        sleepRandom(500, 2000);
        System.out.println(this + " выбрал товар.");
        yield();

    }

    @Override
    public void goToOut() {
        int c = shop.leave(this);
        System.out.println(this + " вышел из магазина (осталось " + c + ")");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        getInLine();
        goToOut();
    }

    @Override
    public String toString() {
        return (pensioneer ? "(П) " : "    ") + this.getName();
    }

    private void sleepRandom(int minMillis, int maxMillis) {
        int millis = MyRandom.getRandom(minMillis, maxMillis);
        if (pensioneer) millis = (int) (millis * 1.5);
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
            String good = shop.takeSomeGood();
            basket.putGoodToBasket(good);
            System.out.println(this + " положил в корзину " + good + '.');
            sleepRandom(100, 200);
        }
    }

    // Встать в очередь
    private void getInLine(){
        int c = shop.putBuyerInLine(this);
        System.out.println(this + " встал в очередь (длинна стала " + c + ")");
    }
}
