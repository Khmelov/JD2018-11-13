package by.it.seroglazov.jd02_02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Shop {

    private HashMap<String, Double> goods;
    private HashSet<Buyer> buyers;

    public Shop() {
        goods = new HashMap<>();
        buyers = new HashSet<Buyer>();
        goods.put("Мясо", 10.0);
        goods.put("Сало", 6.5);
        goods.put("Колбаса", 7.6);
        goods.put("Майонез", 2.2);
        goods.put("Батон", 1.0);
        goods.put("Хлеб", 1.1);
        goods.put("Молоко", 3.7);
        goods.put("Штаны", 25.7);
        goods.put("Шапка", 15.4);
        goods.put("Куртка", 48.24);
        goods.put("Карандаш", 0.3);
        goods.put("Гвозди", 5.5);
    }

    // Return random good from goods
    public String takeSomeGood(){
        int num = MyRandom.getRandom(0, goods.size() - 1);
        Iterator<String> it = goods.keySet().iterator();
        for (int i = 0; i < num; i++) {
            it.next();
        }
        return it.next();
    }

    public synchronized int enter(Buyer buyer){
        buyers.add(buyer);
        return buyers.size();
    }

    public synchronized int leave(Buyer buyer){
        buyers.remove(buyer);
        return buyers.size();
    }

    public synchronized int buyersCount(){
        return buyers.size();
    }
}
