package by.it.vchernetski.jd01_12;


import java.util.*;
/*
В качестве уникального шифра можно использовать обычную статическую переменную (private static Integer id = 0),
просто дабавляя к этой переменной единицу при каждом вызове map.put(K k, V v).
 */
public class TaskC1 {
    private static Integer generatekey(TreeMap<Integer, String> map){
        Integer key = (int)(Math.random()*1000);
        while(map.containsKey(key)){
            key = (int)(Math.random()*1000);
        }
        return key;
    }
    private static TreeMap<Integer, String> deldublicate(TreeMap<Integer,String> col){
        TreeMap<Integer, String> outcol = new TreeMap<>();
        for(Map.Entry<Integer, String> en: col.entrySet()){
            if(!(outcol.containsValue(en.getValue()))) outcol.put(en.getKey(),en.getValue());
        }
        return outcol;
    }
    public static void main(String[] args) {
        TreeMap<Integer, String> C1 = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        String input;
        while(!((input=sc.next()).equalsIgnoreCase("end"))){
            C1.put((generatekey(C1)),input);
        }
        C1 = deldublicate(C1);
        System.out.println(C1);
    }
}
