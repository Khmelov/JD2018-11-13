package by.it.skarpovich.jd01_14;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TaskB {
    static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        try (Scanner sc = new Scanner((dir(TaskB.class) + "text.txt"));
                //BufferedReader isr = new BufferedReader(new FileReader(dir(TaskB.class) + "text.txt"));
        ) {
            String str=null;
                while (sc.hasNext()) {
                    str = str.replaceAll("[^a-zA-Z]", " "); // Оставляем все слова + слова с апострофом
                    for (String s : str.split(" ")) {
                        if (map.containsKey(s)) {                             // Если слово содержится в коллекции, увеличиваем ключ на единицу
                            map.put(s, map.get(s) + 1);
                        } else {
                            map.put(s, 1);                                   // Иначе добавляем слово и ключ=1
                        }
                    }
                    map.remove("");                                       //
                }
                System.out.println(map);
            }
        }

    }




