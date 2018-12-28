package by.it.markelov.jd02_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    public Buyer(String s) {
        super(s);
        Dispatcher.addBuyer();
        this.start();
    }

    private boolean pensioneer = false;

    boolean isPensioneer() {
        int random = Util.random(1, 4);
        if (random == 1) {
            return pensioneer = true;
        } else return pensioneer;
    }

    Basket basketOfBuyer;

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBasket() {
        if (!pensioneer) {
            try {
                Thread.sleep(Util.random(100, 200)/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else
            try {
                Thread.sleep(Util.random(150, 300)/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(this + " взял корзину");
    }


    @Override
    public void chooseGoods() {
        if (!pensioneer) {
            int random = Util.random(500, 2000);
            try {
                Thread.sleep(random/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int random = Util.random(750, 3000);
            try {
                Thread.sleep(random/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBasket() {
        if (!pensioneer) {
            try {
                Thread.sleep(Util.random(100, 200)/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else
            try {
                Thread.sleep(Util.random(150, 300)/Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        Set<String> keys = Goods.pricelist.keySet();//сет наименований продуктов
        List<String> list = new ArrayList<>(keys);//преобразуем в лист
        Collections.shuffle(list);//перетасовываем в произвольном порядке

        Basket basketOfBuyer = new Basket();//создаем корзину покупателя
        int random = Util.random(1, 4);
        for (int i = 0; i < random; i++) {
            String nameOfProduct = list.get(i);//вынимаем имя продукта из перетасованного листа
            Integer priceOfProduct = Goods.pricelist.get(nameOfProduct);//получаем цену продукта из прайслиста
            basketOfBuyer.basket.put(nameOfProduct, priceOfProduct);//заполняем корзину покупателя
        }
        System.out.println(this + " положил товар в корзину: ");
        System.out.println(basketOfBuyer.basket);
    }

    @Override
    public void goToQueue() {
        Queue.queueBuyers.addLast(this);
        System.out.println(this + " встал в очередь и ожидает");
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void goOut() {
        Dispatcher.removeBuyer();
        System.out.println(this + " вышел из магазина");
    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        isPensioneer();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }
}



