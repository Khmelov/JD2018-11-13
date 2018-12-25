package by.it.vchernetski.jd02_02;

import java.util.Map;

public class Backet {
    protected static Map.Entry<String,Integer> putGoods() {
        int nOfGood = Util.random(Good.goods.size() - 1);//номер выбранного товара
        int index = 0;
        for(Map.Entry<String,Integer> entry: Good.goods.entrySet()){
            if (index == nOfGood) return entry;
            index++;
        }
        return null;
    }
}
