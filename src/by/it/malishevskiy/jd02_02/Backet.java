package by.it.malishevskiy.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Backet implements IUseBacket {
    @Override
    public void takeBacket(int customerNumber) {
        System.out.println("Покупатель №" + customerNumber + ": взял корзину");
    }

    @Override
    public void putGoodsToBacket(int customerNumber) {
        HashMap<String, Integer> goodsList = new HashMap() {{
            put("Мясо", 45);
            put("Картошка", 10);
            put("Сало", 55);
            put("Помидоры", 25);
            put("Верхняя Одежда", 200);
            put("Нижняя одежда", 160);
        }};
        List<String> keys = new ArrayList<>(goodsList.keySet());
        int goodsQuan = (int) Util.random(1, 4);
        int sum = 0;
        for (int i = 0; i < goodsQuan; i++) {
            String prod = keys.get(Util.random(4));
            int price = goodsList.get(prod);
            System.out.println("Покупатель №" + customerNumber + ": купил " + prod + " за " + price);
            sum += price;
            Util.sleep(Util.random(100, 200));
        }
        System.out.println("Суммма чека покупателя " + customerNumber + " равна " + sum);
    }
}