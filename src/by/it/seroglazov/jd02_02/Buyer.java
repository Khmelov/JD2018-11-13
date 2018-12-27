package by.it.seroglazov.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private int num; // Номер покупателя

    public boolean isPensioneer() {
        return pensioneer;
    }

    private boolean pensioneer;

    private final Shop shop;
    //private Basket basket;

    Buyer(int num, Shop shop) {
        super("BuyerN" + num);
        this.num = num;
        this.shop = shop;
        pensioneer = Math.random() < 0.25;
        start();
    }

    // Если пустили в магазин, возвращает true, иначе false
    @Override
    public boolean enterToMarket() {
        int c = shop.enter(this);
        if (c >= 0) {
            if (Runner.FULL_LOG) System.out.println(this + " зашёл в магазин (стало магазине: " + c + ")");
            yield();
            return true;
        } else {
            if (c == -1) if (Runner.FULL_LOG) System.err.println(this + " не пустили в магазин.");
            return false;
        }
    }

    @Override
    public void chooseGoods() {
        SleepCases.sleepRandom(500, 2000);
        if (Runner.FULL_LOG) System.out.println(this + " выбрал товар.");
        yield();

    }

    @Override
    public boolean goToOut() {
        int c = shop.leave(this);
        if (c >= 0) {
            if (Runner.FULL_LOG) System.out.println(this + " вышел из магазина (осталось в магазине " + c + ")");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        if (enterToMarket()) {
            takeBasket();
            chooseGoods();
            putGoodsToBasket();
            getInLine();
            while (!goToOut())
                SleepCases.sleepFor(100); // Если магазин не выпускает то здесь застрянет покупатель (значит ошибка в логике)
        }
    }

    @Override
    public String toString() {
        return (pensioneer ? "(П)" : "   ") + this.getName();
    }

    String getShortName() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        if (shop.takeBasket(this)) {
            if (Runner.FULL_LOG) System.out.println(this + " взял корзину.");
            SleepCases.sleepRandom(100, 200);
        } else {
            if (Runner.FULL_LOG) System.err.println(this + " не могу взять корзину!");
        }
    }

    @Override
    public void putGoodsToBasket() {
        String[] goods = shop.putRandomGoodsToBasket(this, MyRandom.getRandom(1, 4));
        for (int i = 0; i < goods.length; i++) {
            if (Runner.FULL_LOG) System.out.println(this + " положил в корзину " + goods[i] + '.');
            SleepCases.sleepRandom(100, 200);
        }
    }

    public void setStayingInLine(boolean stayingInLine) {
        this.stayingInLine = stayingInLine;
    }

    private boolean stayingInLine = false;

    // Встать в очередь
    private void getInLine() {
        int c = shop.getInLine(this);
        if (Runner.FULL_LOG) System.out.println(this + " встал в очередь (очередь: " + c + ")");
        stayingInLine = true;
        synchronized (this) {
            while (stayingInLine) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException " + e.getMessage());
                }
            }
        }
    }


}
