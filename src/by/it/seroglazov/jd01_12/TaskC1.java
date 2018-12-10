package by.it.seroglazov.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {
        TreeMap<UUID, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        UUID id;
        while (true) {
            String str = scanner.next();
            if (str.equals("end")) break;
            do {
                id = UUID.randomUUID();
            } while (map.containsKey(id));
            map.put(id, str);
        }
        // Выод на консоль
        for (Map.Entry<UUID, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }

        // Удаляем повторения - для этого ложим в новый HashMap в котором меняем местами ключи и значения
        HashMap<String, UUID> newMap = new HashMap<>(map.size());
        for (Map.Entry<UUID, String> item : map.entrySet()) {
            newMap.putIfAbsent(item.getValue(), item.getKey());
        }
        // А теперь складываем назад в map
        map = new TreeMap<UUID, String>();
        for (Map.Entry<String, UUID> item : newMap.entrySet()) {
            map.put(item.getValue(), item.getKey());
        }

        // Выод на консоль
        System.out.println("После сжатия:");
        for (Map.Entry<UUID, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }


    }
}
