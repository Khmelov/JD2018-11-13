package by.it.vchernetski.jd02_01;

import java.util.Map;

public class Backet {
    protected String putGood() {
        int noofgood = Util.random(Good.mapGoods.size()-1);//номер выбранного товара
        int index = 0;// номер товара
        for (Map.Entry<String,Integer> entry:Good.mapGoods.entrySet()) {
            if (index == noofgood) {
                return "put good: " + entry.getKey() + " price: " + entry.getValue();
            }
            index++;
        }
        return "good didn't find";
    }
}
