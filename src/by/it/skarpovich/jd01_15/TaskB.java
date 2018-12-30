package by.it.skarpovich.jd01_15;

import java.io.*;
/**
 * TaskB2
 *  В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 *  Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 *  Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 *  Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 *  Считайте, что комментарии внутри строки невозможны  и внутри комментария тоже
 */

public class TaskB {
    public static void main(String[] args) {
        //Определеяем директорию файла для программы
        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + clDir;

        /*Читаем файл используя классы FileReader и BufferedReader, создаем StringBuilder и записываем
         * в него содержимое файла построчно*/

        StringBuilder sbuilder = new StringBuilder(3500);
        try (BufferedReader bfr = new BufferedReader(new FileReader(path + "TaskB.java"))) {

            while (bfr.ready()) {
                char ch = (char) bfr.read(); // Создаем переменную-курсор, приводим к char
                if (ch == '/') {    // Если /, читаем следующий символ
                    ch = (char) bfr.read();

                    if (ch == '/') {  // Если после / снова / - это комментарий
                        while (ch != '\n') { ch = (char) bfr.read(); } // пропускаем остальное до переноса строки

                    } else if (ch == '*') { //Если после / идет * - это многострочный или JavaDoc
                        while (bfr.ready()) {  // Пропускаем символы, пока не дойдем до /
                            ch = (char) bfr.read();
                            if (ch == '/') {   // Если /, записываем и его в ch (пропускаем) и прерываем цикл.
                               ch = (char) bfr.read();
                                break;
                            }
                        }
                    } else sbuilder.append('/');  // Если был только один /, просто добавляем его  StringBuilder.
                }
                sbuilder.append(ch); // Если не было /-ей добавлем ch в StringBuilder
            }
            System.out.println(sbuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Создаем файл FileWriter-ом и пишем в него PrintWriter-ом*. Буфер не используется, т.к.
        * PrintWriter является буферизированым*/
        try (PrintWriter prw = new PrintWriter(new FileWriter(path + "TaskB.txt")))
        {
            prw.print(sbuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}