package by.it.mnovikov.jd02_01;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    Buyer(int buyerNum) {
        super("Покупатель № " + buyerNum + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

    @Override
    public void takeBacket() {
        Rnd.sleepTime(100, 200);
        System.out.println(this + " взял корзинку");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " начал выбор товара");
        Rnd.sleepTime(500, 2000);
        System.out.println(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBacket() {
        int countGoods = Rnd.random(1, 4);
        for (int i = 0; i < countGoods; i++) {
            int position = Rnd.random(0, Goods.goods.size() - 1);
            Goods.getPosition(Goods.goods, position);
            Rnd.sleepTime(100, 200);
        }
        System.out.println(this + " положил товары в корзинку");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }
}
