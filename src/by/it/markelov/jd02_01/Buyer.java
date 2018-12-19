package by.it.markelov.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    HashMap<String, Integer> basket;
    public Buyer (String name) {
        super(name);
        basket=new HashMap<>();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this.getName()+ " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        int pause = (500 + (int) (Math.random()*1501));
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+" выбрал товар");
    }

    @Override
    public void goOut() {
        System.out.println(this.getName()+" вышел из магазина");
    }

    @Override
    public void takeBasket() {
        int pause = (100 + (int) (Math.random()*101));
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        int pause = (100 + (int) (Math.random()*101));
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<String, Integer>> entries = Goods.pricecurrant.entrySet();
        int limit=(int) (1+Math.random()*4);
        int count=0;
        System.out.println(this.getName() + " положил товар в корзину");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
            count++;
            if (count==limit) break;
        }
    }

    @Override
    public void run () {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

}
