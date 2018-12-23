package by.it.kruglenja.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Backet implements IUseBacket{
    @Override
    public void takeBacket(int customerNumber) {
        System.out.println("Покупатель №" + customerNumber + ": взял корзину");
    }

    @Override
    public void putGoodsToBacket(int customerNumber) {
        HashMap<String, Integer> goodsList = new HashMap<String, Integer>() {{
            put("колбасу", 228);
            put("картоху", 322);
            put("сало", 2077);
            put("огурец", 155);
            put("туфли", 300);
        }};
        List<String> keys = new ArrayList<>(goodsList.keySet());
        int goodsQuan = (int) Util.random(1, 4);
        for (int i = 0; i < goodsQuan; i++) {
            String prod = keys.get(Util.random(4));
            int price = goodsList.get(prod);
            System.out.println("Покупатель №" + customerNumber + ": купил " + prod + " за " + price);
            Util.sleep(Util.random(100, 200));
        }
    }
}
