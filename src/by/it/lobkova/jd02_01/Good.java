package by.it.lobkova.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Good {

    static HashMap<Integer, Integer> goods = new HashMap<>();
    static List<Integer> numberGoods = new ArrayList<>();

    public static void getGoods() {
        for (int i = 0; i <= 2; i++) {
            goods.put(Dispatcher.goodCounter, Util.random(100));
            numberGoods.add(Dispatcher.buyerCounter);
            Dispatcher.goodCounter++;
        }
    }

    public static int randomChooseGood () {
        int index = numberGoods.get(Util.random(2, Good.numberGoods.size() - 1));
        return index;
    }

}
