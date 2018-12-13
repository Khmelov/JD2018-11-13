package by.it._examples_.jd01_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Class01_Autoclose {
    public static void main(String[] args) {
        //вычислим каталог, в котором находится проект
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_14/";
        String fin = src + "text.txt";
        //или то же самое можно сделать через выделенную функцию
        fin=Utils.getFilePath("text.txt");
        //указание ресурса в try автоматически закроет его при выходе (Java 7)
        //возможный способ автоматического закрытия потоков  (Java 7 и выше)
        try (FileInputStream is = new FileInputStream(new File(fin))) {

            int b;
            while ((b = is.read()) != -1) { /* чтение */
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.err.println("ошибка файла: " + e);
        }
    } //main
}
