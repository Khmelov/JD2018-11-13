package by.it.lobkova.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    HashMap<Integer, Integer> backet;

    Buyer(int number) {
        super("Buyer № " + number);
        backet = new HashMap<>();
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
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int time = Util.random(500, 2000);
        Util.sleep(time);
        int goodCount = Util.random(1, 4);
        Good.getGoods();
        List<Integer> buyerGoods = new ArrayList<>(goodCount);

        for (int i = 0; i < goodCount; i++) {
            buyerGoods.add(Good.randomChooseGood());
        }
        System.out.println(this + " choose " + buyerGoods);
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from market");
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }

    @Override
    public void takeBacket() {
        int time = Util.random(100, 200);
        Util.sleep(time);
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        int time = Util.random(100, 200);
        Util.sleep(time);
        System.out.println(this + " put the goods in the basket");

    }
}
