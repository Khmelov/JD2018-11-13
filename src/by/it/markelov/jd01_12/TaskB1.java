package by.it.markelov.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Map<String, Integer> couples = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.equalsIgnoreCase("end")) break;
            else {
                word = word.replaceAll("[,.!?;:-]", "");
            }
            words.add(word);
        }
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            String element = it.next();
            int frequency = Collections.frequency(words, element);
            couples.put(element, frequency);
        }
        Set<Map.Entry<String, Integer>> set = couples.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}


