package by.it.naumenko.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Tovar {
    public static Map<String,Double> tovar = new HashMap<>();

    public static void clearTovar(){
        tovar.put("Молоко",1.25);
        tovar.put("Хлеб",1.50);
        tovar.put("Яйца",2.10);
        tovar.put("Кефир",1.33);
        tovar.put("Батон",1.41);
        tovar.put("Колбаса",4.80);
        tovar.put("Курица",5.90);
        tovar.put("Печенье",2.60);
        tovar.put("Чай",3.55);
        tovar.put("Мандорины",2.35);
    }

    static void getPosition(HashMap map, int position){
        Object[] key = map.keySet().toArray();
        System.out.println(key[position]+"="+map.get(key[position]));
    }
}
