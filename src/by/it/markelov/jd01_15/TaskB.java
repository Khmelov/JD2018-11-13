package by.it.markelov.jd01_15;

import java.io.*;

public class TaskB {
    public static File pathOfThisDirectory(Class<?> cl) {
        Package aPackage = cl.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \
        String property = System.getProperty("user.dir");//путь к папке проекта
        File file = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator);//объект класса File (путь к рабочей папке)
        return file;
    }
    /*первый многострочный комментарий
     */

    /**
     * JavaDoc comment
     *
     * @param args
     */
    public static void main(String[] args) {
        //первый однострочный комментарий
        File pathOfThisDirectory = pathOfThisDirectory(TaskB.class);
        //второй однострочный комментарий
        StringBuilder sb = new StringBuilder();
        /*второй многострочный комментарий
         */
        try (BufferedReader br = (new BufferedReader(new FileReader(pathOfThisDirectory + File.separator + "TaskB.java")));
             PrintWriter pr = new PrintWriter(pathOfThisDirectory + File.separator + "TaskB.txt")) {
            while (br.ready()) {
                char ch = (char) br.read();//читаем свой файл посимвольно

                if (ch == '\'') {//если натыкаемся на символ '
                    sb.append(ch);//записываем его
                    pr.print(ch);
                    ch = (char) br.read();//делаем один шаг вперед
                    sb.append(ch);//записываем символ
                    pr.print(ch);
                    ch = (char) br.read();//делаем один шаг вперед
                    sb.append(ch);//записываем символ
                    pr.print(ch);
                    continue;//досрочно прерываем этот этап цикла и переходим на следующий
                }

                if (ch == '/') {//если натыкаемся на символ /
                    ch = (char) br.read();//делаем один шаг вперед

                    if (ch == '/') {//если после символа / натыкаемся на еще один символ /, значит это однострочный коммент
                        while (br.ready()) {//бежим дальше по однострочному комменту
                            ch = (char) br.read();
                            if (ch == '\n')
                                break;//пока не натыкаемся на конец строки. Возвращаемся к основному циклу чтения файла и попадаем в строку sb.append(ch);
                        }

                    } else if (ch == '*') {//если после символа / натыкаемся на символ *, значит это многострочный коммент или JavaDoc
                        while (br.ready()) {//бежим дальше по многострочному комменту
                            ch = (char) br.read();
                            if (ch == '/') {//пока не натыкаемся на символ /.
                                ch = (char) br.read();//делаем один шаг вперед
                                break;//возвращаемся к основному циклу чтения файла и попадаем в строку sb.append(ch);
                            }
                        }
                    }
                }
                sb.append(ch);//запись символа
                pr.print(ch);//вывод символа в файл
            }
            System.out.println(sb);//вывод в итогового объекта в консоль
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


