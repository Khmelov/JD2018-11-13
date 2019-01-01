package by.it.seroglazov.jd02_03;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    boolean isPensioneer() {
        return pensioneer;
    }
    private final boolean pensioneer;

    // У покупателя есть ссылка на магазин, где он находится
    private final Shop shop;

    Lock lock = new ReentrantLock();
    Condition servedByCashier = lock.newCondition();

    Buyer() {
        shop = null;
        pensioneer = false;
    }

    Buyer(int num, Shop shop) {
        super("BuyerN" + num);
        this.shop = shop;
        pensioneer = Math.random() < 0.25;
        start();
    }

    // Если пустили в магазин, возвращает true, иначе false
    @Override
    public boolean enterToMarket() {
        int c = shop.enter(this);
        if (c >= 0) {
            if (Runner.FULL_LOG) System.out.println(this + " зашёл в магазин (стало в магазине: " + c + ")");
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
            enterTradeHall();
            chooseGoods();
            putGoodsToBasket();
            leaveTradeHall();
            getInLine();
            putBasketBack();
            while (!goToOut())
                SleepCases.sleepFor(100); // Если магазин не выпускает то здесь застрянет покупатель (значит ошибка в логике)
        }
    }

    private void enterTradeHall() {
        shop.enterToTradeHall(this);
    }

    private void leaveTradeHall() {
        shop.leaveTradeHall(this);
    }

    private void putBasketBack() {
        if (shop.putBasketBack(this)) {
            if (Runner.FULL_LOG) System.out.println(this + " положил корзину на место.");
        } else {
            if (Runner.FULL_LOG) System.out.println(this + " НЕ СМОГ положить корзину на место.");
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
        for (String good : goods) {
            if (Runner.FULL_LOG) System.out.println(this + " положил в корзину " + good + '.');
            SleepCases.sleepRandom(100, 200);
        }
    }

    void setFalseStayingInLine() {
        stayingInLine.set(false);
    }

    private AtomicBoolean stayingInLine = new AtomicBoolean(false);

    // Встать в очередь
    private void getInLine() {
        lock.lock();
        try {
            @SuppressWarnings("UnusedAssignment")
            int c = shop.getInLine(this);
            if (Runner.FULL_LOG) System.out.println(this + " встал в очередь (очередь: " + c + ")");
            stayingInLine.set(true);
            while (stayingInLine.get()) {
                servedByCashier.await(); // Ожидаем когда нас обслужит кассир
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
