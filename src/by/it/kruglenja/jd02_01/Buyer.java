package by.it.kruglenja.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    public Buyer(int num) {
        super("Покупатель №" + num);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName() + ": ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "выбирает товар");
        putGoodsToBacket();
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goOut() {
        System.out.println(this + "отправился на выход");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        HashMap<String, Integer> goodsList = new HashMap<>() {{
            put("Колбасу", 228);
            put("Картоху", 322);
            put("Сало", 2077);
            put("Огурец", 155);
            put("Туфли", 300);
        }};
        List<String> keys = new ArrayList<>(goodsList.keySet());
        int goodsQuan = (int) Util.random(1, 4);
        for (int i = 0; i < goodsQuan; i++) {
            String prod = keys.get(Util.random(4));
            int price = goodsList.get(prod);
            System.out.println(this + "купил " + prod + " за " + price);
            Util.sleep(Util.random(100, 200));
        }
    }

}
