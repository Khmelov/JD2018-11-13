package by.it.skarpovich.jd01_15;

import java.io.*;
import java.util.regex.*;

/**
 * TaskB
 *  В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 *  Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 *  Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 *  Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 *  Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”) и внутри комментария тоже
 * /** bla... /*так не бывает*...bla... //и так тоже bla...
 */

public class TaskBregex {
    public static void main(String[] args) {
        //Определеяем директорию файла для программы
        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + clDir;
        String result=null;
        /*Читаем файл используя классы FileReader и BufferedReader, создаем StringBuilder и записываем
         * в него содержимое файла построчно*/
        /*Читаем файл используя классы FileReader и BufferedReader, создаем StringBuilder и записываем
         * в него содержимое файла построчно*/

        try (BufferedReader bfr = new BufferedReader(new FileReader(path + "TaskBregex.java"))) {
            StringBuilder sbuilder = new StringBuilder();
            while (bfr.ready()) {
                sbuilder.append(bfr.readLine()).append("\n");
            }
            //Паттерн для многострочных комментариев Java.
            Pattern commentsPattern = Pattern.compile("//[^\\n]*+");
            Matcher commentsMatcher = commentsPattern.matcher(sbuilder);
            //Удаляем однострочные комментарии
            while (commentsMatcher.find()) {
                sbuilder.replace(commentsMatcher.start(), commentsMatcher.end(), "");
                commentsMatcher.reset();
            }
            //Паттерн для многострочных комментариев Java.
            Pattern stringsPattern = Pattern.compile("(?s)/\\*.*?\\*/");
            Matcher stringsMatcher = stringsPattern.matcher(sbuilder);
            //Удаляем многострочные комментарии
            while (stringsMatcher.find()) {
                sbuilder.replace(stringsMatcher.start(), stringsMatcher.end(), "");
                stringsMatcher.reset();
            }
            //Выводим код программы без комментариев в консоль
            result=sbuilder.toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter prw = new PrintWriter(new FileWriter(path + "TaskBregex.txt")))
        {
            prw.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}