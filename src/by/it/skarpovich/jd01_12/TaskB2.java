package by.it.skarpovich.jd01_12;
import java.util.*;
/**
 TaskB2. Считалка. В кругу стоят N человек.
 При ведении счета по кругу итератором вычеркивается каждый второй человек, пока не останется один.
 Нужно составить два метода, моделирующие процесс и возвращающие имя оставшегося человека:
 static String process(ArrayList<String> peoples)
 static String process(LinkedList<String> peoples)
 Покажите работу методов в main
 */

class TaskB2 {
    public static void main(String[] args) {
        String[] strNamesArray = new String[]{"Вася", "Петя", "Саша", "Дима", "Жанна", "Гоша", "Федор", "Иосиф", "Владимир", "Боря", "Ден"};
        List<String> strNamesColl = Arrays.asList(strNamesArray);      // Создаем базовую коллекцию из массива String
        ArrayList<String> arrList = new ArrayList<>(strNamesColl);     // Заполняем ArrayList элементами из базовой коллекции
        LinkedList<String> lnkList = new LinkedList<>(strNamesColl);   // Заполняем LinkedList элементами из базовой коллекции
        System.out.println("В ArrayList остался: "+process(arrList));
        System.out.println("В LinkedList остался: "+process(lnkList));
    }

    static String process(ArrayList<String> peoples) {
        int count = 0;
        while (peoples.size() > 1) {                                   // Повторяем цикл пока в коллекции не останется один элемент
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                count++;
                if (count % 2 == 0) iter.remove();                     // Удаляем четные элементы из коллекции при помощи итератора
            }
        }
        return peoples.get(0);                                         // Возвращаем оставшийся элемент в коллекции
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





