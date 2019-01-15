package by.it.nickgrudnitsky.jd02_01;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private Map<String, Double> backet = new HashMap<>();
    private Map<String, Double> goods = new HashMap<>();
    static CopyOnWriteArraySet<Buyer> buyers = new CopyOnWriteArraySet<>();
    private boolean pensioneer;


    private void goods() {
        goods.put("apple", 0.25);
        goods.put("bread", 0.35);
        goods.put("milk", 1.10);
        goods.put("potatoes", 3.50);
        goods.put("pork", 5.0);

        Set<String> keys = goods.keySet();
        List<String> list = new ArrayList<>(keys);

        int amount = Util.random(1, 4);
        for (int i = 0; i < amount; i++) {
            String s = list.get(Util.random(0, 4));
            backet.put(s, goods.get(s));
        }
        System.out.println(this + " " + backet);
    }

    Buyer(int number) {
        super("Buyer #" + number + " ");
        int random = Util.random(1, 4);
        pensioneer = random == 4;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    synchronized public void enterToMarket() {
        buyers.add(this);
        System.out.println(this + "enter to market.");
    }

    @Override
    public void chooseGoods() {
        /*System.out.println(this + "choosing goods.");*/
        if (pensioneer) {
            Util.sleep((int) (Util.random(5000, 10000) * 1.5));
        } else {
            Util.sleep(Util.random(5000, 10000));
        }
        System.out.println(this + "choosed goods.");
    }

    @Override
    synchronized public void goOut() {
        buyers.remove(this);
        System.out.println(this + "go out from market.");

    }

    @Override
    public String toString() {
        if (pensioneer) {
            return getName() + "pensioneer";
        } else {
            return getName();
        }
    }

    @Override
    public void takeBacket() {
        if (pensioneer) {
            Util.sleep((int) (Util.random(100, 200) * 1.5));
        } else {
            Util.sleep(Util.random(100, 200));
        }
        System.out.println(this + "took backet.");
    }

    @Override
    public void putGoodsToBacket() {
        if (pensioneer) {
            Util.sleep((int) (Util.random(100, 200) * 1.5));
        } else {
            Util.sleep(Util.random(100, 200));
        }
        System.out.println(this + "put goods in to the bucket.");
    }

}
