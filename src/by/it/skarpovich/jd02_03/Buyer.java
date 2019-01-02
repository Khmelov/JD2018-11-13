package by.it.skarpovich.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {
    Semaphore semaphore = new Semaphore(20);

    private boolean waiting = false;

    void stopWait() {
        synchronized (this) {
            waiting = false;
            this.notify();
        }
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }


    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + "entered the market.");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
        System.out.println(this + "took a basket");
    }

    @Override
    public void chooseGoods() {
        try { semaphore.acquire();
            System.out.println(this + "started to choose goods");
            int timeout = Util.random(500, 2000);
            Util.sleep(timeout);
            System.out.println(this + "chose goods.");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = Util.random(100, 200);
        Util.sleep(timeout);
        int goodsCount = Util.random(1, 4);  // Получаем случайное количество товаров от 1 до 4-х.
        // Выводим количество товаров и результат(список случайных покупок с ценами) из метода goods
        System.out.println(this + "put " + goodsCount + " good(s) to the basket: " + Basket.goods(goodsCount));
        System.out.println("Сумма к оплате:" + Basket.BasketSum());
    }

    @Override
    public void goToQueue() {
        try {
            QueueBuyer.add(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waiting = true;
        synchronized (this) {
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "left the market.");
        Dispatcher.removeBuyer();
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }
}
