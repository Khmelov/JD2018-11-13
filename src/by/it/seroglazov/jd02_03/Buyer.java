package by.it.seroglazov.jd02_03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private int num; // Номер покупателя

    public boolean isPensioneer() {
        return pensioneer;
    }

    private boolean pensioneer;

    private final Shop shop;
    //private Basket basket;

    Lock lock = new ReentrantLock();
    Condition servedByCashier = lock.newCondition();

    Buyer() {
        shop = null;
    }

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

    /*public boolean isLeaveTheLine() {
        return leaveTheLine.get();
    }*/

    // Это для того, чтобы кассир убедился, что чертов покупатель проснулся и ушел из магазина
    // после обслуживания(обслуживают их во сне как бы)
    //private AtomicBoolean leaveTheLine = new AtomicBoolean(false);

    void setStayingInLine(boolean state) {
        stayingInLine.set(state);
    }

    private AtomicBoolean stayingInLine = new AtomicBoolean(false);


    // Встать в очередь
    private void getInLine() {
        lock.lock();
        try {
            int c = shop.getInLine(this);
            if (Runner.FULL_LOG) System.out.println(this + " встал в очередь (очередь: " + c + ")");
            stayingInLine.set(true);
            while (stayingInLine.get()) {
                //System.out.println(this + " все ещё стоит в очереди!");
                //servedByCashier.await(1000, TimeUnit.MILLISECONDS); // Ожидаем когда нас обслужить кассир
                servedByCashier.await(); // Ожидаем когда нас обслужить кассир
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        } finally {
            lock.unlock();
        }
        //leaveTheLine.set(true);
    }


}
