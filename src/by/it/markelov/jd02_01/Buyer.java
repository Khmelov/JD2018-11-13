package by.it.markelov.jd02_01;

import java.util.*;

import static by.it.markelov.jd02_01.Dispatcher.*;
import static by.it.markelov.jd02_01.Goods.pricelist;
import static by.it.markelov.jd02_01.Util.*;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    public Buyer(String s) {
        super(s);
        this.start();
    }


    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBasket() {
        try {
            Thread.sleep(random(200, 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int random = random(0, 2000);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBasket() {
        try {
            Thread.sleep(random(200, 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> keys = pricelist.keySet();//сет наименований продуктов
        String[] keysString = keys.toArray(new String[keys.size()]);//преобразуем в массив
        List<String> list = Arrays.asList(keysString);//преобразуем в лист
        Collections.shuffle(list);//перетасовываем в произвольном порядке

        Basket basket = new Basket();//создаем корзину покупателя
        int random = Util.random(1,4);
        for (int i = 0; i < random; i++) {
            String nameOfProduct = list.get(i);//вынимаем имя продукта из перетасованного листа
            Integer priceOfProduct = pricelist.get(nameOfProduct);//получаем цену продукта из прайслиста
            basket.basket.put(nameOfProduct, priceOfProduct);//заполняем корзину покупателя
        }
        System.out.println(this + " положил товар в корзину: ");
        System.out.println(basket.basket);
    }

    @Override
    public void goOut() {
        ++buyersOut;
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }




/*   HashMap<String, Integer> basket;
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
*/
}
