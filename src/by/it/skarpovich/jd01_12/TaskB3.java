package by.it.skarpovich.jd01_12;
import java.util.*;
/**
 * TaskB3. Скопируйте предыдущую задачу и измерьте на размере задачи в 4096 элемент какой из двух методов работает быстрее. Объясните итог.
 * Подумайте, как можно было бы решить задачу в методе prоcess(LinkedList<String> peoples) без итератора и снижения быстродействия,
 * используя интерфейсы очередей. Проверьте свою идею.
 * */
class TaskB3 {

        public static void main(String[] args) {
                        Timer t=new Timer();
                        String[] strNamesArray = new String[4096];
            for (int i = 0; i <4096; i++) {
                strNamesArray[i]=String.valueOf(i);
            }
            System.out.println("Добавление элементов в массив заняло: "+t);
            List<String> strNamesColl = Arrays.asList(strNamesArray);
            System.out.println("Добавление элементов массива в ArrayList заняло: "+t);
            System.out.println();

            ArrayList<String> arrList = new ArrayList<>(strNamesColl);
            System.out.println("Копирование из коллекции ArrayList в ArrayLlist заняло: "+t);

            System.out.println("В ArrayList остался: "+process(arrList));
            System.out.println("Считалка используя ArrayLlist заняла: "+t);
            System.out.println();

            LinkedList<String> lnkList = new LinkedList<>(strNamesColl);
            System.out.println("Копирование коллекции из ArrayList в LinkedList заняло: "+t);

            System.out.println("В LinkedList остался: "+process(lnkList));
            System.out.println("Считалка используя LinkedLlist заняла: "+t);
        }

         static class Timer {
            private long iniTime;
            private Double Delta;
            public Timer() {iniTime=System.nanoTime(); }
            public String toString() {
                Delta=(double)(System.nanoTime()-iniTime)/1000;
                iniTime=System.nanoTime();
                return Delta.toString()+" микросекунд.";
            }
         }

        static String process(ArrayList<String> peoples) {
            int count = 0;
            while (peoples.size() > 1) {
                Iterator<String> iter = peoples.iterator();
                while (iter.hasNext()) {
                    iter.next();
                    count++;
                    if (count % 2 == 0) iter.remove();
                }
            }
            return peoples.get(0);
        }

        static String process(LinkedList<String> peoples) {
            int count = 0;
            while (peoples.size() > 1) {
                Iterator<String> iter = peoples.iterator();
                while (iter.hasNext()) {
                    iter.next();
                    count++;
                    if (count % 2 == 0) iter.remove();
                }
            }
            return peoples.get(0);
        }
    }
