package by.it._examples_.jd01_14;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Class03_ReadFile {
    public static void main(String[] args) {
        //путь к файлу от корня проекта, здесь корень System.getProperty("user.dir")
        String src=System.getProperty("user.dir")+"/src/by/it/_examples_/jd01_14/";
        String filename = src+"text.txt";

        File f = new File(filename); // объект для связи с файлом на диске
        int b, count = 0;
        FileReader is = null;        //объявляем до try, чтобы is был доступен в finally
        try {
            is = new FileReader(f);                 //так читаем СИМВОЛЫ
            while ((b = is.read()) != -1) {         // чтение одного байта.
                System.out.print((char) b);
                count++;
            }
            System.out.println("\n Число байт = " + count);
            System.out.println(" Кодировка "+is.getEncoding());
        } catch (IOException e) {
            System.err.println(" Ошибка файла: " + e );
        } finally {
            try {
                if (is != null) {
                    is.close(); // закрытие потока ввода. НУЖНО ДЕЛАТЬ ВСЕГДА.
                }
            } catch (IOException e)
                {System.err.println("ошибка закрытия: " + e);}
        }
    }

}
