package by.it.skarpovich.jd01_14;
/**В классе TaskB нужно выполнить следующие шаги:
В файле с текстом TaskB.txt нужно подсчитать общее количество знаков препинания и слов
Вывести результат на консоль в виде одной строки: words=123, punctuaction marks=15;
Продублировать вывод консоль в файл resultTaskB.txt*/
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        try (// Scanner sc = new Scanner(new FileReader(dir(TaskB.class) + "text.txt")); // Реализация через Scanner
             BufferedReader bfr = new BufferedReader(new FileReader(TaskA.dir(TaskB.class) + "text.txt")); // Потое для чтения из файла text.txt
             PrintWriter outFile = new PrintWriter  // Поток для записи в файл
                     (new FileWriter(TaskA.dir(TaskB.class) + "resultTaskB.txt")) // (метод dir реализован в классе A)
        ) {
            StringBuilder sb = new StringBuilder(950);

            // ... Реализация через  класс Scanner (медленная)
//            while (sc.hasNext()) {
//                sb.append(sc.nextLine()).append("\n");
//            }
            while (bfr.ready()) {   // Пока поток доступен для чтения. ~ (bfr=is.read())!=-1
                sb.append(bfr.readLine()).append("\n");   // Добавляем текст в String Builder построчно из потока BufferReader
            }
            //System.out.println(sb); // Проверка добавленного текста
            Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]+"); // Паттерн для русских слов
            Matcher m1 = p1.matcher(sb);
            int countWords = 0;
            while (m1.find()) {
                countWords++;
            }
            Pattern p2 = Pattern.compile("[\\p{Punct}]+"); // Паттерн для знаков препинания
            Matcher m2 = p2.matcher(sb);
            int countPuncts = 0;
            while (m2.find()) {
                countPuncts++;
            }
            System.out.println("words=" + countWords + ", " + "punctuation marks=" + countPuncts); //Вывод а консоль
            outFile.println("words=" + countWords + ", " + "punctuation marks=" + countPuncts);  // Вывод в файл через поток PrintWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}