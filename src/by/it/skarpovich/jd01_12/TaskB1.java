package by.it.skarpovich.jd01_12;

import java.util.*;
/**
 TaskB1. Нужно ввести с консоли текст на английском языке до строки “end” (100 и более слов).
 Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
 Вывести все различные слова формате слово=частота. Слова, отличающиеся регистром букв, считать различными. isn't или don’t – одно слово.
 */
public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // Создаем хэш-мэп
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.next()).equals("end")) {
            //String value = String.valueOf(str);                    //?
            str = str.replaceAll("[^a-zA-Z']", " "); // Оставляем все слова + слова с апострофом
            for(String s: str.split(" ")) {
                if(map.containsKey(s)) {                             // Если слово содержится в коллекции, увеличиваем ключ на единицу
                    map.put(s, map.get(s) + 1);
                }
                else {
                    map.put(s, 1);                                   // Иначе добавляем слово и ключ=1
                }
            }
           map.remove("");                                       //
        }
        System.out.println(map);
    }
}
