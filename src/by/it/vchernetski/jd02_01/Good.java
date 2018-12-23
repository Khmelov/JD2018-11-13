package by.it.vchernetski.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Good {
    protected static Map<String,Integer> mapGoods = new HashMap<>();
    static void fillMapGoods(){
        for (int i = 1; i <=10; i++) {
            mapGoods.put("good № "+i,Util.random(1,100));
        }
    }
}
