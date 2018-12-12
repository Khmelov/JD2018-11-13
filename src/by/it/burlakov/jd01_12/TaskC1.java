package by.it.burlakov.jd01_12;


import java.util.*;

public class TaskC1 {

    private static Map<Integer, String> c1 = new TreeMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;

        while(!(line = scanner.nextLine()).equalsIgnoreCase("end")){
            c1.put(randomCode(), line);
        }
        Set<String> set = new TreeSet<>();
        for (Map.Entry<Integer, String> temp : c1.entrySet()) {
            set.add(temp.getValue());
        }

        for(String str: set){
            removeSame(str);
        }

        printMap(c1);
    }
    private static int randomCode() {
        int number = (int) (Math.random() * (System.nanoTime()/100000000));
        return number;
    }

    public static void removeSame(String str) {

        Iterator<Map.Entry<Integer, String>> iterator = c1.entrySet().iterator();

        int count = 0;
        Map.Entry<Integer, String> mapEntry;

        while (iterator.hasNext()) {
            mapEntry = iterator.next();
            if (mapEntry.getValue().equals(str)) {
                if(count > 0){
                    iterator.remove();
                } else {
                    count++;
                }
            }
        }
    }

    private static void printMap(Map<Integer, String> map){
        for (Map.Entry<Integer, String> temp : map.entrySet()) {
            System.out.println(temp.getKey() +" = "+ temp.getValue());
        }
    }
}
