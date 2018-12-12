package by.it._examples_.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapConstructor {
    private static final int capacity = 4;

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<Integer, String>(capacity, 1.0f, true) {
            @Override
            protected boolean
            removeEldestEntry(Map.Entry<Integer, String> eldest) {
                //тут можно сравнить с capacity и вернуть true, иначе старое поведение (false)
                return this.size() > capacity || super.removeEldestEntry(eldest);
            }
        };
        hashMap.put(1, "a");
        System.out.println(hashMap);
        hashMap.put(2, "a");
        System.out.println(hashMap);
        hashMap.put(3, "a");
        System.out.println(hashMap);
        hashMap.put(4, "a"); hashMap.get(1);
        System.out.println(hashMap);
        hashMap.put(5, "a"); hashMap.get(2);
        System.out.println(hashMap);
        hashMap.get(3);
        System.out.println(hashMap);
    }
}
