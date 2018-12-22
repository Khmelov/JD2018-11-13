package by.it.vchernetski.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Good {
    protected static Map<String, Integer> goods = new HashMap<>();
    protected static void fillGoods(){
        goods.put("Pants", 20);
        goods.put("Jack-towel",10);
        goods.put("Bread",2);
        goods.put("Rise",3);
        goods.put("Meat",7);
        goods.put("Toothbrush",1);
        goods.put("Soup",1);
        goods.put("Potatoes",2);
        goods.put("T-short",8);
        goods.put("Vegetables",1);
    }
}
